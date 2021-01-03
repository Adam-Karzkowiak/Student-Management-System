DROP TABLE IF EXISTS APPUSER;

CREATE TABLE APPUSER (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(50) NOT NULL,
                         password VARCHAR(100) NOT NULL,
                         name VARCHAR(50) NOT NULL,
                         surname VARCHAR(80) NOT NULL,
                         pesel VARCHAR(11) NOT NULL,
                         isProfessor BOOLEAN NOT NULL
);

INSERT INTO appuser(id, username, password, name, surname, pesel, isProfessor)
VALUES (1, 'Adam123', 'TestHaslo123', 'Adam', 'Adamski', '90020775794', true);
