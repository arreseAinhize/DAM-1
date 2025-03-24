-- Crear base de datos (opcional)
CREATE DATABASE IF NOT EXISTS book_journal_db;
USE book_journal_db;

-- Tabla de usuarios
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
    correo VARCHAR(100) UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de autores
CREATE TABLE autores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla de géneros
CREATE TABLE generos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla de libros
CREATE TABLE libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    autor_id INT,
    genero_id INT,
    estado ENUM('leyendo', 'completado', 'pendiente') DEFAULT 'pendiente',
    fecha_inicio DATE,
    fecha_fin DATE,
    calificacion TINYINT CHECK (calificacion BETWEEN 1 AND 5),
    resena TEXT,
    imagen_portada VARCHAR(255),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (autor_id) REFERENCES autores(id) ON DELETE SET NULL,
    FOREIGN KEY (genero_id) REFERENCES generos(id) ON DELETE SET NULL
);

-- Tabla de progreso de lectura
CREATE TABLE progreso_lectura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    libro_id INT NOT NULL,
    fecha DATE NOT NULL,
    paginas_leidas INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (libro_id) REFERENCES libros(id) ON DELETE CASCADE
);

-- Función para obtener total de libros leídos
DELIMITER $$

CREATE FUNCTION total_libros_leidos(p_usuario_id INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total
    FROM libros
    WHERE usuario_id = p_usuario_id AND estado = 'completado';
    RETURN total;
END $$

DELIMITER ;

-- Función para calcular el promedio de calificaciones de un usuario
DELIMITER $$

CREATE FUNCTION promedio_calificaciones(p_usuario_id INT)
RETURNS DECIMAL(3,2)
DETERMINISTIC
BEGIN
    DECLARE promedio DECIMAL(3,2);
    SELECT AVG(calificacion) INTO promedio
    FROM libros
    WHERE usuario_id = p_usuario_id AND calificacion IS NOT NULL;
    RETURN IFNULL(promedio, 0.0);
END $$

DELIMITER ;

-- Función para obtener el total de libros leídos por género
DELIMITER $$

CREATE FUNCTION libros_por_genero(p_usuario_id INT, p_genero_id INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE total INT;
    SELECT COUNT(*) INTO total
    FROM libros
    WHERE usuario_id = p_usuario_id AND genero_id = p_genero_id;
    RETURN total;
END $$

DELIMITER ;

-- Procedimiento para registrar un nuevo usuario
DELIMITER $$

CREATE PROCEDURE registrar_usuario (
    IN p_nombre_usuario VARCHAR(50),
    IN p_correo VARCHAR(100),
    IN p_contrasena VARCHAR(255)
)
BEGIN
    INSERT INTO usuarios (nombre_usuario, correo, contrasena)
    VALUES (p_nombre_usuario, p_correo, p_contrasena);
END $$

DELIMITER ;

-- Procedimiento para actualizar el progreso de lectura de un libro
DELIMITER $$

CREATE PROCEDURE actualizar_progreso (
    IN p_libro_id INT,
    IN p_usuario_id INT,
    IN p_paginas INT
)
BEGIN
    DECLARE ultima_fecha DATE;

    -- Insertar progreso
    INSERT INTO progreso_lectura (usuario_id, libro_id, fecha, paginas_leidas)
    VALUES (p_usuario_id, p_libro_id, CURDATE(), p_paginas);

    -- Si el libro ya está completado, no hacer más
    IF (SELECT estado FROM libros WHERE id = p_libro_id) <> 'completado' THEN
        IF (SELECT SUM(paginas_leidas)
            FROM progreso_lectura
            WHERE libro_id = p_libro_id AND usuario_id = p_usuario_id) >= 200 THEN -- puedes parametrizarlo
            UPDATE libros
            SET estado = 'completado', fecha_fin = CURDATE()
            WHERE id = p_libro_id;
        END IF;
    END IF;
END $$

DELIMITER ;

-- Trigger para validar la calificación solo si el libro está completo
DELIMITER $$

CREATE TRIGGER validar_calificacion_completado
BEFORE INSERT ON libros
FOR EACH ROW
BEGIN
    IF NEW.calificacion IS NOT NULL AND NEW.estado <> 'completado' THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Solo puedes calificar libros completados.';
    END IF;
END $$

DELIMITER ;

-- Trigger para actualizar la fecha de fin cuando un libro se marca como completado
DELIMITER $$

CREATE TRIGGER actualizar_fecha_fin_auto
BEFORE UPDATE ON libros
FOR EACH ROW
BEGIN
    IF NEW.estado = 'completado' AND OLD.estado <> 'completado' AND NEW.fecha_fin IS NULL THEN
        SET NEW.fecha_fin = CURDATE();
    END IF;
END $$

DELIMITER ;

-- Vista para obtener libros de un usuario con autor y género
CREATE OR REPLACE VIEW vista_libros_usuario AS
SELECT
    l.id AS libro_id,
    l.usuario_id,
    l.titulo,
    a.nombre AS autor,
    g.nombre AS genero,
    l.estado,
    l.calificacion,
    l.fecha_inicio,
    l.fecha_fin
FROM libros l
LEFT JOIN autores a ON l.autor_id = a.id
LEFT JOIN generos g ON l.genero_id = g.id;

-- Vista para obtener el progreso total de lectura de los libros
CREATE OR REPLACE VIEW vista_progreso_total AS
SELECT
    libro_id,
    usuario_id,
    SUM(paginas_leidas) AS total_paginas,
    MAX(fecha) AS ultima_actualizacion
FROM progreso_lectura
GROUP BY libro_id, usuario_id;
