-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 16, 2023 alle 10:37
-- Versione del server: 10.4.25-MariaDB
-- Versione PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hasbulla _team`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `frasi`
--

CREATE TABLE `frasi` (
  `id_frasi` int(11) NOT NULL,
  `nparole_per_frase` int(11) DEFAULT NULL,
  `parola_piu_usata` varchar(255) DEFAULT NULL,
  `parola_piu_lunga` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `testi`
--

CREATE TABLE `testi` (
  `id_testo` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `contenuto` text DEFAULT NULL,
  `tot_parole` int(11) DEFAULT NULL,
  `tot_frasi` int(11) DEFAULT NULL,
  `parola_piu_usata` varchar(255) DEFAULT NULL,
  `parola_piu_lunga` varchar(255) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `frasi`
--
ALTER TABLE `frasi`
  ADD PRIMARY KEY (`id_frasi`);

--
-- Indici per le tabelle `testi`
--
ALTER TABLE `testi`
  ADD PRIMARY KEY (`id_testo`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `frasi`
--
ALTER TABLE `frasi`
  MODIFY `id_frasi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `testi`
--
ALTER TABLE `testi`
  MODIFY `id_testo` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `frasi`
--
ALTER TABLE `frasi`
  ADD CONSTRAINT `fk_id_testi` FOREIGN KEY (`id_frasi`) REFERENCES `testi` (`id_testo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
