# Hasbulla-Team
CREATE TABLE testi
(
id_testo			int NOT NULL AUTO_INCREMENT,
nome				varchar(50),
contenuto			text, 
tot_parole			int,
tot_frasi			int,
parola_piu_usata	varchar(255),
parola_piu_lunga	varchar(255),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,     
CONSTRAINT pk_testi
PRIMARY KEY (id_testo)
);
--------------------------------------------------------------------------------------
CREATE TABLE frasi
(
    id_frasi			int NOT NULL AUTO_INCREMENT,
    nparole_per_frase	int,
    parola_piu_usata	varchar(255),
    parola_piu_lunga	varchar(255),
    CONSTRAINT pk_frasi PRIMARY KEY (id_frasi)
);
----------------------------------------------------------------
ALTER TABLE frasi ADD CONSTRAINT fk_id_testi FOREIGN KEY (id_frasi) REFERENCES testi(id_testo);
