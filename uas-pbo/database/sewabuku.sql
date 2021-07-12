-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 11, 2021 at 06:12 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpus_sekolah`
--

-- --------------------------------------------------------

--
-- Table structure for table `sewabuku`
--

CREATE TABLE `sewabuku` (
  `id` int(11) NOT NULL,
  `judul` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_harus_kembali` date DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `denda` int(11) DEFAULT NULL,
  `biaya_sewa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sewabuku`
--

INSERT INTO `sewabuku` (`id`, `judul`, `tanggal_pinjam`, `tanggal_harus_kembali`, `tanggal_kembali`, `denda`, `biaya_sewa`) VALUES
(1, 'Pemrograman Java Bagi Pemula : Seri Pertama', '2021-07-01', '2021-07-08', '2021-07-05', 0, 5000),
(2, 'Sebuah Seni Untuk Bersikap Bodo Amat oleh Mark Manson', '2021-07-02', '2021-07-09', '2021-07-06', 0, 5000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sewabuku`
--
ALTER TABLE `sewabuku`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sewabuku`
--
ALTER TABLE `sewabuku`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
