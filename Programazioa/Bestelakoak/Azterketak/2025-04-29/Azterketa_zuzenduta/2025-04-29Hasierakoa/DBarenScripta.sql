CREATE DATABASE ErabiltzaileenDatuBasea;
USE ErabiltzaileenDatuBasea

CREATE TABLE Erabiltzaileak(
    Kontua VARCHAR(20) PRIMARY KEY,
    Izena VARCHAR(15),
    Abizena VARCHAR(15),
    Adina INT,
    Rola ENUM('ikaslea','irakaslea'),
    Pasahitza VARCHAR(150),
    kontuaID INT AUTO_INCREMENT UNIQUE
);

CREATE TABLE Logs(
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Kontua VARCHAR(20), 
    SarreraData DATETIME,
    IrteeraData DATETIME,
    FOREIGN KEY (Kontua) REFERENCES Erabiltzaileak(Kontua)
);

INSERT INTO Erabiltzaileak VALUES ("rsanmartin","Ruben","SanMartin",24,"irakaslea","Admin123"),
                                  ("monasterio.julen","Julen","Monasterio",20,"ikaslea","12345"),
                                  ("calvo.mireia","Mireia","Calvo",20,"ikaslea","54321");

CREATE USER apriluser IDENTIFIED BY 'apriluser';
GRANT SELECT, INSERT, DELETE, UPDATE ON ErabiltzaileenDatuBasea.* TO apriluser;                                  