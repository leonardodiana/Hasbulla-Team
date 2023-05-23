# Hasbulla-Team
CREATE TABLE testi
(
id_testo			int NOT NULL AUTO_INCREMENT,
nome				varchar(50),
contenuto			text, 
tot_parole			int,
tot_frasi			int,
tot_caratteri varchar(255),
parola_piu_usata	varchar(255),
parola_piu_lunga	varchar(255),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
nparole_per_frase	int,
parola_piu_usata_frase	varchar(255),
parola_piu_lunga_frase	varchar(255),
CONSTRAINT pk_testi
PRIMARY KEY (id_testo)
);
