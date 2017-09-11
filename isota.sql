-- phpMyAdmin SQL Dump
-- version 4.0.10.10
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Май 18 2016 г., 09:26
-- Версия сервера: 5.5.45
-- Версия PHP: 5.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `isota`
--

-- --------------------------------------------------------

--
-- Структура таблицы `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RevisionNum` int(11) NOT NULL,
  `RegistrationDate` date NOT NULL,
  `DirectorFIO` varchar(50) DEFAULT NULL,
  `DirectorUID` int(10) DEFAULT NULL,
  `PhoneNumber` int(10) NOT NULL,
  `CapitalSum` int(11) DEFAULT NULL,
  `Adress` varchar(30) NOT NULL,
  `FIO` varchar(20) NOT NULL,
  `UID` int(10) NOT NULL,
  `DirectorAdress` varchar(30) DEFAULT NULL,
  `DirectorNumber` int(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Дамп данных таблицы `clients`
--

INSERT INTO `clients` (`ID`, `RevisionNum`, `RegistrationDate`, `DirectorFIO`, `DirectorUID`, `PhoneNumber`, `CapitalSum`, `Adress`, `FIO`, `UID`, `DirectorAdress`, `DirectorNumber`) VALUES
(1, 213123123, '2016-03-16', 'akjdasl sadasd', 234567890, 2147483647, 0, '', 'VASYA', 0, '', 0),
(3, 737432, '2016-03-27', 'asasda', 0, 0, 0, '', 'LENA', 0, '', 0),
(4, 1, '2016-02-21', 'null', NULL, 1, NULL, '1', '123', 1, '', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `id`
--

CREATE TABLE IF NOT EXISTS `id` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `reports`
--

CREATE TABLE IF NOT EXISTS `reports` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ClientID` int(10) unsigned NOT NULL,
  `OperationDate` date NOT NULL,
  `Kod` varchar(10) NOT NULL,
  `Sum` float NOT NULL,
  `Paid` float NOT NULL,
  `Returned` float NOT NULL,
  `Overpayment` float NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClientID` (`ClientID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `reports`
--

INSERT INTO `reports` (`ID`, `ClientID`, `OperationDate`, `Kod`, `Sum`, `Paid`, `Returned`, `Overpayment`) VALUES
(1, 1, '2021-02-02', '3', 4, 5, 6, 7);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Login` varchar(10) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `SecurityClass` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`ID`, `Login`, `Password`, `Name`, `LastName`, `SecurityClass`) VALUES
(1, 'admin', '123', 'Admin', 'Admin', 1);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`ClientID`) REFERENCES `clients` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
