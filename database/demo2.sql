-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 25, 2017 at 02:34 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `demo2`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL,
  `atrollno` varchar(100) DEFAULT NULL,
  `atdiv` varchar(5) DEFAULT NULL,
  `atstatus` varchar(25) DEFAULT NULL,
  `atdate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `atrollno`, `atdiv`, `atstatus`, `atdate`) VALUES
(1, '1', 'A', 'present', '2017-04-23'),
(2, '2', 'A', 'present', '2017-04-23'),
(3, '4', 'A', 'present', '2017-04-23'),
(4, '5', 'A', 'present', '2017-04-23'),
(5, '3', 'A', 'present', '2017-04-23'),
(6, '6', 'A', 'absent', '2017-04-23'),
(7, '8', 'A', 'absent', '2017-04-23'),
(8, '7', 'A', 'absent', '2017-04-23'),
(9, '10', 'A', 'absent', '2017-04-23'),
(10, '13', 'A', 'absent', '2017-04-23'),
(11, '12', 'A', 'absent', '2017-04-23'),
(12, '16', 'A', 'absent', '2017-04-23'),
(13, '11', 'A', 'absent', '2017-04-23'),
(14, '9', 'A', 'absent', '2017-04-23'),
(15, '15', 'A', 'absent', '2017-04-23'),
(16, '14', 'A', 'absent', '2017-04-23'),
(17, '21', 'A', 'absent', '2017-04-23'),
(18, '17', 'A', 'absent', '2017-04-23'),
(19, '18', 'A', 'absent', '2017-04-23'),
(20, '20', 'A', 'absent', '2017-04-23'),
(21, '19', 'A', 'absent', '2017-04-23'),
(22, '22', 'A', 'absent', '2017-04-23'),
(23, '23', 'A', 'absent', '2017-04-23'),
(24, '25', 'A', 'absent', '2017-04-23'),
(25, '27', 'A', 'absent', '2017-04-23'),
(26, '26', 'A', 'absent', '2017-04-23'),
(27, '24', 'A', 'absent', '2017-04-23'),
(28, '30', 'A', 'absent', '2017-04-23'),
(29, '28', 'A', 'absent', '2017-04-23'),
(30, '29', 'A', 'absent', '2017-04-23'),
(31, '31', 'A', 'absent', '2017-04-23'),
(32, '32', 'A', 'absent', '2017-04-23'),
(33, '37', 'A', 'absent', '2017-04-23'),
(34, '35', 'A', 'absent', '2017-04-23'),
(35, '33', 'A', 'absent', '2017-04-23'),
(36, '38', 'A', 'absent', '2017-04-23'),
(37, '34', 'A', 'absent', '2017-04-23'),
(38, '36', 'A', 'absent', '2017-04-23'),
(39, '39', 'A', 'absent', '2017-04-23'),
(40, '41', 'A', 'absent', '2017-04-23'),
(41, '42', 'A', 'absent', '2017-04-23'),
(42, '40', 'A', 'absent', '2017-04-23'),
(43, '43', 'A', 'absent', '2017-04-23'),
(44, '44', 'A', 'absent', '2017-04-23'),
(45, '47', 'A', 'absent', '2017-04-23'),
(46, '48', 'A', 'absent', '2017-04-23'),
(47, '49', 'A', 'absent', '2017-04-23'),
(48, '45', 'A', 'absent', '2017-04-23'),
(49, '46', 'A', 'absent', '2017-04-23'),
(50, '52', 'A', 'absent', '2017-04-23'),
(51, '51', 'A', 'absent', '2017-04-23'),
(52, '50', 'A', 'absent', '2017-04-23'),
(53, '53', 'A', 'absent', '2017-04-23'),
(54, '54', 'A', 'absent', '2017-04-23'),
(55, '55', 'A', 'absent', '2017-04-23'),
(56, '56', 'A', 'absent', '2017-04-23'),
(57, '58', 'A', 'absent', '2017-04-23'),
(58, '57', 'A', 'absent', '2017-04-23'),
(59, '59', 'A', 'absent', '2017-04-23'),
(60, '60', 'A', 'absent', '2017-04-23'),
(61, '62', 'A', 'absent', '2017-04-23'),
(62, '63', 'A', 'absent', '2017-04-23'),
(63, '65', 'A', 'absent', '2017-04-23'),
(64, '61', 'A', 'absent', '2017-04-23'),
(65, '67', 'A', 'absent', '2017-04-23'),
(66, '64', 'A', 'absent', '2017-04-23'),
(67, '69', 'A', 'absent', '2017-04-23'),
(68, '71', 'A', 'absent', '2017-04-23'),
(69, '70', 'A', 'absent', '2017-04-23'),
(70, '72', 'A', 'absent', '2017-04-23'),
(71, '66', 'A', 'absent', '2017-04-23'),
(72, '68', 'A', 'absent', '2017-04-23'),
(73, '73', 'A', 'absent', '2017-04-23'),
(74, '77', 'A', 'absent', '2017-04-23'),
(75, '75', 'A', 'absent', '2017-04-23'),
(76, '74', 'A', 'absent', '2017-04-23'),
(77, '76', 'A', 'absent', '2017-04-23'),
(78, '79', 'A', 'absent', '2017-04-23'),
(79, '80', 'A', 'absent', '2017-04-23'),
(80, '78', 'A', 'absent', '2017-04-23'),
(81, '2', 'A', 'present', '2017-04-23'),
(82, '3', 'A', 'present', '2017-04-23'),
(83, '1', 'A', 'absent', '2017-04-23'),
(84, '5', 'A', 'absent', '2017-04-23'),
(85, '4', 'A', 'absent', '2017-04-23'),
(86, '10', 'A', 'absent', '2017-04-23'),
(87, '9', 'A', 'absent', '2017-04-23'),
(88, '6', 'A', 'absent', '2017-04-23'),
(89, '8', 'A', 'absent', '2017-04-23'),
(90, '11', 'A', 'absent', '2017-04-23'),
(91, '14', 'A', 'absent', '2017-04-23'),
(92, '7', 'A', 'absent', '2017-04-23'),
(93, '15', 'A', 'absent', '2017-04-23'),
(94, '13', 'A', 'absent', '2017-04-23'),
(95, '12', 'A', 'absent', '2017-04-23'),
(96, '16', 'A', 'absent', '2017-04-23'),
(97, '17', 'A', 'absent', '2017-04-23'),
(98, '20', 'A', 'absent', '2017-04-23'),
(99, '21', 'A', 'absent', '2017-04-23'),
(100, '24', 'A', 'absent', '2017-04-23'),
(101, '18', 'A', 'absent', '2017-04-23'),
(102, '19', 'A', 'absent', '2017-04-23'),
(103, '23', 'A', 'absent', '2017-04-23'),
(104, '22', 'A', 'absent', '2017-04-23'),
(105, '26', 'A', 'absent', '2017-04-23'),
(106, '30', 'A', 'absent', '2017-04-23'),
(107, '25', 'A', 'absent', '2017-04-23'),
(108, '27', 'A', 'absent', '2017-04-23'),
(109, '28', 'A', 'absent', '2017-04-23'),
(110, '31', 'A', 'absent', '2017-04-23'),
(111, '33', 'A', 'absent', '2017-04-23'),
(112, '29', 'A', 'absent', '2017-04-23'),
(113, '35', 'A', 'absent', '2017-04-23'),
(114, '32', 'A', 'absent', '2017-04-23'),
(115, '34', 'A', 'absent', '2017-04-23'),
(116, '36', 'A', 'absent', '2017-04-23'),
(117, '43', 'A', 'absent', '2017-04-23'),
(118, '44', 'A', 'absent', '2017-04-23'),
(119, '37', 'A', 'absent', '2017-04-23'),
(120, '45', 'A', 'absent', '2017-04-23'),
(121, '39', 'A', 'absent', '2017-04-23'),
(122, '42', 'A', 'absent', '2017-04-23'),
(123, '38', 'A', 'absent', '2017-04-23'),
(124, '41', 'A', 'absent', '2017-04-23'),
(125, '40', 'A', 'absent', '2017-04-23'),
(126, '50', 'A', 'absent', '2017-04-23'),
(127, '51', 'A', 'absent', '2017-04-23'),
(128, '49', 'A', 'absent', '2017-04-23'),
(129, '47', 'A', 'absent', '2017-04-23'),
(130, '46', 'A', 'absent', '2017-04-23'),
(131, '52', 'A', 'absent', '2017-04-23'),
(132, '48', 'A', 'absent', '2017-04-23'),
(133, '58', 'A', 'absent', '2017-04-23'),
(134, '55', 'A', 'absent', '2017-04-23'),
(135, '57', 'A', 'absent', '2017-04-23'),
(136, '56', 'A', 'absent', '2017-04-23'),
(137, '59', 'A', 'absent', '2017-04-23'),
(138, '54', 'A', 'absent', '2017-04-23'),
(139, '60', 'A', 'absent', '2017-04-23'),
(140, '53', 'A', 'absent', '2017-04-23'),
(141, '64', 'A', 'absent', '2017-04-23'),
(142, '63', 'A', 'absent', '2017-04-23'),
(143, '66', 'A', 'absent', '2017-04-23'),
(144, '61', 'A', 'absent', '2017-04-23'),
(145, '62', 'A', 'absent', '2017-04-23'),
(146, '65', 'A', 'absent', '2017-04-23'),
(147, '67', 'A', 'absent', '2017-04-23'),
(148, '73', 'A', 'absent', '2017-04-23'),
(149, '74', 'A', 'absent', '2017-04-23'),
(150, '69', 'A', 'absent', '2017-04-23'),
(151, '71', 'A', 'absent', '2017-04-23'),
(152, '72', 'A', 'absent', '2017-04-23'),
(153, '68', 'A', 'absent', '2017-04-23'),
(154, '70', 'A', 'absent', '2017-04-23'),
(155, '76', 'A', 'absent', '2017-04-23'),
(156, '78', 'A', 'absent', '2017-04-23'),
(157, '75', 'A', 'absent', '2017-04-23'),
(158, '77', 'A', 'absent', '2017-04-23'),
(159, '79', 'A', 'absent', '2017-04-23'),
(160, '80', 'A', 'absent', '2017-04-23');

-- --------------------------------------------------------

--
-- Table structure for table `attendance1`
--

CREATE TABLE `attendance1` (
  `id` int(100) NOT NULL,
  `atrollno` varchar(100) NOT NULL,
  `atdiv` varchar(100) NOT NULL,
  `atstatus` varchar(100) NOT NULL,
  `atdate` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `attendance2`
--

CREATE TABLE `attendance2` (
  `id` int(100) NOT NULL,
  `atrollno` varchar(100) NOT NULL,
  `atdiv` varchar(100) NOT NULL,
  `atstatus` varchar(100) NOT NULL,
  `atdate` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance2`
--

INSERT INTO `attendance2` (`id`, `atrollno`, `atdiv`, `atstatus`, `atdate`) VALUES
(1, '6', 'A', 'present', '2017-04-23'),
(2, '2', 'A', 'absent', '2017-04-23'),
(3, '1', 'A', 'absent', '2017-04-23'),
(4, '4', 'A', 'absent', '2017-04-23'),
(5, '7', 'A', 'absent', '2017-04-23'),
(6, '5', 'A', 'absent', '2017-04-23'),
(7, '10', 'A', 'absent', '2017-04-23'),
(8, '8', 'A', 'absent', '2017-04-23'),
(9, '3', 'A', 'absent', '2017-04-23'),
(10, '9', 'A', 'absent', '2017-04-23'),
(11, '11', 'A', 'absent', '2017-04-23'),
(12, '12', 'A', 'absent', '2017-04-23'),
(13, '16', 'A', 'absent', '2017-04-23'),
(14, '18', 'A', 'absent', '2017-04-23'),
(15, '19', 'A', 'absent', '2017-04-23'),
(16, '17', 'A', 'absent', '2017-04-23'),
(17, '15', 'A', 'absent', '2017-04-23'),
(18, '13', 'A', 'absent', '2017-04-23'),
(19, '14', 'A', 'absent', '2017-04-23'),
(20, '20', 'A', 'absent', '2017-04-23'),
(21, '21', 'A', 'absent', '2017-04-23'),
(22, '26', 'A', 'absent', '2017-04-23'),
(23, '22', 'A', 'absent', '2017-04-23'),
(24, '25', 'A', 'absent', '2017-04-23'),
(25, '27', 'A', 'absent', '2017-04-23'),
(26, '29', 'A', 'absent', '2017-04-23'),
(27, '28', 'A', 'absent', '2017-04-23'),
(28, '24', 'A', 'absent', '2017-04-23'),
(29, '23', 'A', 'absent', '2017-04-23'),
(30, '30', 'A', 'absent', '2017-04-23'),
(31, '33', 'A', 'absent', '2017-04-23'),
(32, '34', 'A', 'absent', '2017-04-23'),
(33, '35', 'A', 'absent', '2017-04-23'),
(34, '31', 'A', 'absent', '2017-04-23'),
(35, '37', 'A', 'absent', '2017-04-23'),
(36, '32', 'A', 'absent', '2017-04-23'),
(37, '36', 'A', 'absent', '2017-04-23'),
(38, '38', 'A', 'absent', '2017-04-23'),
(39, '39', 'A', 'absent', '2017-04-23'),
(40, '43', 'A', 'absent', '2017-04-23'),
(41, '40', 'A', 'absent', '2017-04-23'),
(42, '42', 'A', 'absent', '2017-04-23'),
(43, '41', 'A', 'absent', '2017-04-23'),
(44, '45', 'A', 'absent', '2017-04-23'),
(45, '44', 'A', 'absent', '2017-04-23'),
(46, '46', 'A', 'absent', '2017-04-23'),
(47, '48', 'A', 'absent', '2017-04-23'),
(48, '49', 'A', 'absent', '2017-04-23'),
(49, '47', 'A', 'absent', '2017-04-23'),
(50, '52', 'A', 'absent', '2017-04-23'),
(51, '54', 'A', 'absent', '2017-04-23'),
(52, '51', 'A', 'absent', '2017-04-23'),
(53, '50', 'A', 'absent', '2017-04-23'),
(54, '53', 'A', 'absent', '2017-04-23'),
(55, '55', 'A', 'absent', '2017-04-23'),
(56, '56', 'A', 'absent', '2017-04-23'),
(57, '58', 'A', 'absent', '2017-04-23'),
(58, '63', 'A', 'absent', '2017-04-23'),
(59, '60', 'A', 'absent', '2017-04-23'),
(60, '61', 'A', 'absent', '2017-04-23'),
(61, '62', 'A', 'absent', '2017-04-23'),
(62, '66', 'A', 'absent', '2017-04-23'),
(63, '59', 'A', 'absent', '2017-04-23'),
(64, '67', 'A', 'absent', '2017-04-23'),
(65, '57', 'A', 'absent', '2017-04-23'),
(66, '64', 'A', 'absent', '2017-04-23'),
(67, '65', 'A', 'absent', '2017-04-23'),
(68, '71', 'A', 'absent', '2017-04-23'),
(69, '68', 'A', 'absent', '2017-04-23'),
(70, '72', 'A', 'absent', '2017-04-23'),
(71, '75', 'A', 'absent', '2017-04-23'),
(72, '74', 'A', 'absent', '2017-04-23'),
(73, '76', 'A', 'absent', '2017-04-23'),
(74, '69', 'A', 'absent', '2017-04-23'),
(75, '73', 'A', 'absent', '2017-04-23'),
(76, '70', 'A', 'absent', '2017-04-23'),
(77, '78', 'A', 'absent', '2017-04-23'),
(78, '77', 'A', 'absent', '2017-04-23'),
(79, '80', 'A', 'absent', '2017-04-23'),
(80, '79', 'A', 'absent', '2017-04-23');

-- --------------------------------------------------------

--
-- Table structure for table `attendance3`
--

CREATE TABLE `attendance3` (
  `id` int(100) NOT NULL,
  `atrollno` varchar(100) NOT NULL,
  `atdiv` varchar(100) NOT NULL,
  `atstatus` varchar(100) NOT NULL,
  `atdate` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `attendance4`
--

CREATE TABLE `attendance4` (
  `id` int(100) NOT NULL,
  `atrollno` varchar(100) NOT NULL,
  `atdiv` varchar(100) NOT NULL,
  `atstatus` varchar(100) NOT NULL,
  `atdate` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `attendance5`
--

CREATE TABLE `attendance5` (
  `id` int(100) NOT NULL,
  `atrollno` varchar(100) NOT NULL,
  `atdiv` varchar(100) NOT NULL,
  `atstatus` varchar(100) NOT NULL,
  `atdate` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance5`
--

INSERT INTO `attendance5` (`id`, `atrollno`, `atdiv`, `atstatus`, `atdate`) VALUES
(1, '1', 'A', 'present', '2017-04-23'),
(2, '2', 'A', 'absent', '2017-04-23'),
(3, '9', 'A', 'absent', '2017-04-23'),
(4, '4', 'A', 'absent', '2017-04-23'),
(5, '10', 'A', 'absent', '2017-04-23'),
(6, '5', 'A', 'absent', '2017-04-23'),
(7, '8', 'A', 'absent', '2017-04-23'),
(8, '7', 'A', 'absent', '2017-04-23'),
(9, '13', 'A', 'absent', '2017-04-23'),
(10, '3', 'A', 'absent', '2017-04-23'),
(11, '11', 'A', 'absent', '2017-04-23'),
(12, '6', 'A', 'absent', '2017-04-23'),
(13, '17', 'A', 'absent', '2017-04-23'),
(14, '16', 'A', 'absent', '2017-04-23'),
(15, '12', 'A', 'absent', '2017-04-23'),
(16, '15', 'A', 'absent', '2017-04-23'),
(17, '18', 'A', 'absent', '2017-04-23'),
(18, '14', 'A', 'absent', '2017-04-23'),
(19, '19', 'A', 'absent', '2017-04-23'),
(20, '20', 'A', 'absent', '2017-04-23'),
(21, '22', 'A', 'absent', '2017-04-23'),
(22, '21', 'A', 'absent', '2017-04-23'),
(23, '26', 'A', 'absent', '2017-04-23'),
(24, '24', 'A', 'absent', '2017-04-23'),
(25, '23', 'A', 'absent', '2017-04-23'),
(26, '25', 'A', 'absent', '2017-04-23'),
(27, '27', 'A', 'absent', '2017-04-23'),
(28, '29', 'A', 'absent', '2017-04-23'),
(29, '31', 'A', 'absent', '2017-04-23'),
(30, '28', 'A', 'absent', '2017-04-23'),
(31, '33', 'A', 'absent', '2017-04-23'),
(32, '30', 'A', 'absent', '2017-04-23'),
(33, '32', 'A', 'absent', '2017-04-23'),
(34, '36', 'A', 'absent', '2017-04-23'),
(35, '37', 'A', 'absent', '2017-04-23'),
(36, '34', 'A', 'absent', '2017-04-23'),
(37, '39', 'A', 'absent', '2017-04-23'),
(38, '38', 'A', 'absent', '2017-04-23'),
(39, '35', 'A', 'absent', '2017-04-23'),
(40, '42', 'A', 'absent', '2017-04-23'),
(41, '40', 'A', 'absent', '2017-04-23'),
(42, '47', 'A', 'absent', '2017-04-23'),
(43, '44', 'A', 'absent', '2017-04-23'),
(44, '43', 'A', 'absent', '2017-04-23'),
(45, '48', 'A', 'absent', '2017-04-23'),
(46, '41', 'A', 'absent', '2017-04-23'),
(47, '45', 'A', 'absent', '2017-04-23'),
(48, '46', 'A', 'absent', '2017-04-23'),
(49, '49', 'A', 'absent', '2017-04-23'),
(50, '51', 'A', 'absent', '2017-04-23'),
(51, '52', 'A', 'absent', '2017-04-23'),
(52, '55', 'A', 'absent', '2017-04-23'),
(53, '53', 'A', 'absent', '2017-04-23'),
(54, '54', 'A', 'absent', '2017-04-23'),
(55, '50', 'A', 'absent', '2017-04-23'),
(56, '56', 'A', 'absent', '2017-04-23'),
(57, '61', 'A', 'absent', '2017-04-23'),
(58, '57', 'A', 'absent', '2017-04-23'),
(59, '60', 'A', 'absent', '2017-04-23'),
(60, '59', 'A', 'absent', '2017-04-23'),
(61, '58', 'A', 'absent', '2017-04-23'),
(62, '62', 'A', 'absent', '2017-04-23'),
(63, '64', 'A', 'absent', '2017-04-23'),
(64, '66', 'A', 'absent', '2017-04-23'),
(65, '65', 'A', 'absent', '2017-04-23'),
(66, '67', 'A', 'absent', '2017-04-23'),
(67, '68', 'A', 'absent', '2017-04-23'),
(68, '69', 'A', 'absent', '2017-04-23'),
(69, '70', 'A', 'absent', '2017-04-23'),
(70, '72', 'A', 'absent', '2017-04-23'),
(71, '71', 'A', 'absent', '2017-04-23'),
(72, '74', 'A', 'absent', '2017-04-23'),
(73, '63', 'A', 'absent', '2017-04-23'),
(74, '73', 'A', 'absent', '2017-04-23'),
(75, '75', 'A', 'absent', '2017-04-23'),
(76, '77', 'A', 'absent', '2017-04-23'),
(77, '76', 'A', 'absent', '2017-04-23'),
(78, '78', 'A', 'absent', '2017-04-23'),
(79, '79', 'A', 'absent', '2017-04-23'),
(80, '80', 'A', 'absent', '2017-04-23');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `username` varchar(55) DEFAULT NULL,
  `userpassword` varchar(55) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`id`, `username`, `userpassword`) VALUES
(1, 'user', '123123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `attendance1`
--
ALTER TABLE `attendance1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `attendance2`
--
ALTER TABLE `attendance2`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `attendance3`
--
ALTER TABLE `attendance3`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `attendance4`
--
ALTER TABLE `attendance4`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `attendance5`
--
ALTER TABLE `attendance5`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=161;
--
-- AUTO_INCREMENT for table `attendance1`
--
ALTER TABLE `attendance1`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `attendance2`
--
ALTER TABLE `attendance2`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
--
-- AUTO_INCREMENT for table `attendance3`
--
ALTER TABLE `attendance3`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `attendance4`
--
ALTER TABLE `attendance4`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `attendance5`
--
ALTER TABLE `attendance5`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
