-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2021 at 09:34 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `info_siswa`
--

CREATE TABLE `info_siswa` (
  `nis` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jurusan` varchar(20) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `info_siswa`
--

INSERT INTO `info_siswa` (`nis`, `nama`, `jurusan`, `jk`, `alamat`, `id`) VALUES
('124190033', 'Thalib Abu Qitaal', 'Sistem Informasi', 'Laki-Laki', 'Jakarta', 18),
('123123123', 'Muhidin', 'Teknik Kimia', 'Perempuan', 'Dubai', 19),
('321321312', 'Bang Haji Anselmo', 'Teknik Kimia D3', 'Laki-Laki', 'Garut', 20),
('11111111', 'lilo', 'Informatika', 'Laki-Laki', 'Medan punya', 21);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `info_siswa`
--
ALTER TABLE `info_siswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `info_siswa`
--
ALTER TABLE `info_siswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
