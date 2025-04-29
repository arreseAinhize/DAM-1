-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS BookJournal;
USE BookJournal;

-- Tabla de usuarios
CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Tabla de libros (lecturas)
CREATE TABLE Book (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userID INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100),
    genre VARCHAR(50),
    duration INT,
    format ENUM('FISICO', 'EBOOK', 'AUDIOBOOK'),
    FOREIGN KEY (userID) REFERENCES Users(id)
);

-- Tabla para wishlist
CREATE TABLE WishList (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userID INT NOT NULL,
    title VARCHAR(100),
    author VARCHAR(100),
    erosita VARCHAR(10),
    price DECIMAL(10,2),
    FOREIGN KEY (userID) REFERENCES Users(id)
);

-- Tabla para sistema de puntuación personalizado (una columna por estrella)
CREATE TABLE RatingValue (
    userID INT NOT NULL,
    star_1 VARCHAR(100),
    star_2 VARCHAR(100),
    star_3 VARCHAR(100),
    star_4 VARCHAR(100),
    star_5 VARCHAR(100),
    PRIMARY KEY (userID),
    FOREIGN KEY (userID) REFERENCES Users(id)
);

-- Tabla para sistema de reseña personalizado 
CREATE TABLE Review (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bookID INT NOT NULL,
    userID INT NOT NULL,
    reviewText TEXT,
    rating varchar(250),
    format VARCHAR(150),
    genre VARCHAR(50),
    startDate DATE,
    endDate DATE,
    FOREIGN KEY (bookID) REFERENCES Book(id),
    FOREIGN KEY (userID) REFERENCES Users(id)
);

-- Usuario para poder utilizar la aplicacion
CREATE USER IF NOT EXISTS 'journalAdmin'@'%' IDENTIFIED BY 'Admin123';
GRANT INSERT, SELECT, UPDATE, DELETE ON bookjournal.* TO 'journalAdmin'@'%';

-- Insert de valores
INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'drackon', 'Admin123'),
(2, 'uxutxu', 'Ridoc123');

INSERT INTO `ratingvalue`(`userID`, `star_1`, `star_2`, `star_3`, `star_4`, `star_5`) VALUES
(1, 'Hate it, DNF', 'It was ñe' , 'Ez da txarto egon', 'Gusteu jate','Me ha encantado'),
(2, 'no me ha gustado', 'ñe' , 'muy normal - esta bien', 'me ha gustado','Me ha encantado');


INSERT INTO `book` (`userID`, `title`, `author`, `genre`, `duration`, `format`) VALUES
(1, 'Donde no puedas encontrarme', 'Tamara Molina', 'ROMANCE', 450, 'FISICO'),
(1, 'Mala bruja nunca muere', 'Arantxa Comes', 'FANTASY', 445, 'FISICO'),
(1, 'Hércules, el héroe que no quiso serlo', 'Pol Gise', 'OTHER', 349, 'FISICO'),
(1, 'Sísifo, el hombre que engañó a la muerte', 'Pol Gise', 'OTHER', 285, 'FISICO'),
(1, 'Etéreo', 'Joana Marcús', 'NEW_ADULT', 526, 'FISICO'),
(1, 'Solo Leveling', 'Chu-Gong', 'FANTASY', 200, 'EBOOK'),
(1, 'Hades, el dios menos malo', 'Pol Gise', 'OTHER', 205, 'FISICO'),
(1, 'Alas de sangre', 'Rebeca Yarros', 'ROMANTASY', 730, 'FISICO'),
(1, 'Alas de hierro', 'Rebeca Yarros', 'ROMANTASY', 888, 'FISICO'),
(1, 'Instinto', 'Amanda Hocking', 'FICTION', 319, 'FISICO'),
(1, 'Hado', 'Amanda Hocking', 'FICTION', 319, 'FISICO'),
(1, 'Latido', 'Amanda Hocking', 'FICTION', 382, 'FISICO'),
(1, 'Designio', 'Amanda Hocking', 'FICTION', 373, 'FISICO'),
(1, 'Todo lo que sucedió con Miranda Huff', 'Javier Castillo', 'MYSTERY', 373, 'FISICO'),
(1, 'Villian to kill', 'Fupin y Eunji', 'MYSTERY', 115, 'EBOOK'),
(1, 'Kylewood academy', 'Duna Alba', 'ROMANTASY', 702, 'FISICO'),
(1, 'Anywhere', 'Sarah Sprinz', 'OTHER', 517, 'FISICO'),
(1, 'Anyone', 'Sarah Sprinz', 'OTHER', 514, 'FISICO'),
(1, 'Alas de onix', 'Rebeca Yarros', 'ROMANTASY', 890, 'FISICO'),
(1, 'Anytime', 'Sarah Sprinz', 'OTHER', 514, 'FISICO'),
(2, 'En las nubes', 'Hannah Grace', 'ROMANCE', 464, 'EBOOK'),
(2, 'Alas de Sangre', 'Rebecca Yarros', 'ROMANTASY', 736, 'FISICO'),
(2, 'La riada', 'Michael McDowell', 'MYSTERY', 200, 'EBOOK'),
(2, 'El dique', ' Michael McDowell', 'MYSTERY', 201, 'EBOOK'),
(2, 'La casa', ' Michael McDowell', 'MYSTERY', 193, 'FISICO'),
(2, 'La guerra', 'Michael McDowell', 'MYSTERY', 204, 'AUDIOBOOK'),
(2, 'La fortuna', 'Michael McDowell', 'MYSTERY', 198, 'EBOOK'),
(2, 'Lluvia', 'Michael McDowell', 'MYSTERY', 222, 'FISICO'),
(2, 'Alas de hierro', 'Rebecca Yarros', 'ROMANTASY', 888, 'FISICO'),
(2, 'Alas de onix', 'Rebecca Yarros', 'ROMANTASY', 890, 'FISICO'),
(2, 'Sisifo, el hombre que engaño a la muerte', 'Pol Gise', 'OTHER', 288, 'FISICO');

INSERT INTO `wishlist`(`userID`, `title`, `author`, `erosita`, `price`) VALUES 
(1,'Fleur','Ariana Godoy','Ez', 18.95),
(1,'Heist','Ariana Godoy','Ez', 18.95),
(1,'Una maldición de sombras y espinas','LJ Andrews','Bai', 18.95),
(1,'Una corte de hielo y cenizas','LJ Andrews','Bai', 18.52),
(1,'Una corona de sangre y ruina','LJ Andrews','Ez', 18),
(1,'Twisted love','Ana Huang','Bai', 8.5),
(1,'Twisted games','Ana Huang','Bai', 7.95),
(1,'Twisted hate','Ana Huang','Bai', 8.5),
(1,'Twisted lies','Ana Huang','Ez', 8.5),
(1,'Misha Zhukov debe morir', 'Myriam M. Lejardi', 'Ez',18.95),
(2,'Caraval','Stephanie Garber','Bai', 14.25),
(2,'Legendary','Stephanie Garber','Ez', 15.67),
(2,'Finale','Stephanie Garber','Ez', 17.1),
(2,'Spectacular', 'Stephanie Garber', 'Ez',18.65);

INSERT INTO `review` (`bookID`, `userID`, `reviewText`, `rating`, `format`, `genre`, `startDate`, `endDate`) VALUES
(1, 1, 'Enseña la importancia de sanar y priorizarse a una misma y lo importante que es tener un entorno seguro y sano.', 'Ez da txarto egon', 'FISICO', 'Ez da txarto egon', '2024-12-28', '2025-01-02'),
(2, 1, 'Una historia bastante interesante de una bruja sin sus poderes.', 'Gusteu jate', 'FISICO', 'Gusteu jate', '2025-01-02', '2025-01-06'),
(3, 1, 'Es la historia del mito de Hércules, explicando bastantes puntos mejor que Disney.', 'It was ñe', 'FISICO', 'It was ñe', '2025-01-06', '2025-01-09'),
(4, 1, 'Cuénta el mito de Sísifo, como \"engaño\" a la muerte y como los dioses terminaron castigándolo.', 'Ez da txarto egon', 'FISICO', 'Ez da txarto egon', '2025-01-09', '2025-01-10'),
(5, 1, 'Lloros, likes y cabreos.', 'Me ha encantado', 'FISICO', 'Me ha encantado', '2025-01-11', '2025-01-16'),
(6, 1, 'Beru <3', 'Me ha encantado', 'EBOOK', 'Me ha encantado', '2025-01-18', '2025-01-18'),
(7, 1, 'Karonte <3', 'Gusteu jate', 'FISICO', 'Gusteu jate', '2025-01-20', '2025-01-22'),
(8, 1, 'Lloros, tensión, odio, risa y cabreos.   LIAM', 'Me ha encantado', 'FISICO', 'Me ha encantado', '2025-01-23', '2025-01-27'),
(9, 1, 'Me ha gustado más que Alas de sangre, pero me jode que Jack Barlowe esté vivo...', 'Me ha encantado', 'FISICO', 'Me ha encantado', '2025-01-28', '2025-02-11'),
(10, 1, 'Ñe', 'Ez da txarto egon', 'FISICO', 'Ez da txarto egon', '2025-02-17', '2025-02-20'),
(11, 1, 'Ñe x2', 'Ez da txarto egon', 'FISICO', 'Ez da txarto egon', '2025-02-21', '2025-02-25'),
(12, 1, 'Ñe x3', 'Ez da txarto egon', 'FISICO', 'Ez da txarto egon', '2025-02-25', '2025-03-11'),
(13, 1, 'Ñe x4', 'Ez da txarto egon', 'FISICO', 'Ez da txarto egon', '2025-03-11', '2025-03-13'),
(14, 1, 'Ez jate gusteu zelan idazten dauen Javier Castillok', 'It was ñe', 'FISICO', 'It was ñe', '2025-03-13', '2025-03-18'),
(15, 1, 'Ondiño kapituluek ataratzen dabiz', 'Me ha encantado', 'EBOOK', 'Me ha encantado', '2025-03-19', '2025-03-21'),
(16, 1, 'Tensión y risas', 'Gusteu jate', 'FISICO', 'Gusteu jate', '2025-03-21', '2025-03-28'),
(17, 1, 'Romper el hielon modure, ez dau txarto baina bueño.', 'Ez da txarto egon', 'FISICO', 'Ez da txarto egon', '2025-03-28', '2025-03-30'),
(18, 1, 'Sincleir <3', 'Gusteu jate', 'FISICO', 'Gusteu jate', '2025-04-02', '2025-04-07'),
(19, 1, 'Liburuek nire estabilidade mentalakin bukatu dau...', 'Me ha encantado', 'FISICO', 'Me ha encantado', '2025-04-08', '2025-04-20');
