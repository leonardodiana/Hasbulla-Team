-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 23, 2023 alle 12:56
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
-- Database: `lbp_prova`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `frase`
--

CREATE TABLE `frase` (
  `id_frase` int(11) NOT NULL,
  `id_testo` int(11) NOT NULL,
  `contenuto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `parole`
--

CREATE TABLE `parole` (
  `id_parole` int(11) NOT NULL,
  `id_frase` int(11) NOT NULL,
  `contenuto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `testo`
--

CREATE TABLE `testo` (
  `id_testo` int(11) NOT NULL,
  `contenuto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `frase`
--
ALTER TABLE `frase`
  ADD PRIMARY KEY (`id_frase`),
  ADD KEY `fk_id_testo` (`id_testo`);

--
-- Indici per le tabelle `parole`
--
ALTER TABLE `parole`
  ADD PRIMARY KEY (`id_parole`),
  ADD KEY `fk_id_frase` (`id_frase`);

--
-- Indici per le tabelle `testo`
--
ALTER TABLE `testo`
  ADD PRIMARY KEY (`id_testo`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `frase`
--
ALTER TABLE `frase`
  ADD CONSTRAINT `fk_id_testo` FOREIGN KEY (`id_testo`) REFERENCES `testo` (`id_testo`);

--
-- Limiti per la tabella `parole`
--
ALTER TABLE `parole`
  ADD CONSTRAINT `fk_id_frase` FOREIGN KEY (`id_frase`) REFERENCES `frase` (`id_frase`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
