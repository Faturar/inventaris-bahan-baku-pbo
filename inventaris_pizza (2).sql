-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2024 at 10:01 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventaris_pizza`
--

-- --------------------------------------------------------

--
-- Table structure for table `barangs`
--

CREATE TABLE `barangs` (
  `kd_barang` varchar(5) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `stok` int(11) NOT NULL DEFAULT '0',
  `stok_minimum` int(11) NOT NULL DEFAULT '0',
  `tanggal_kadaluarsa` date DEFAULT NULL,
  `id_pemasok` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barangs`
--

INSERT INTO `barangs` (`kd_barang`, `nama`, `kategori`, `stok`, `stok_minimum`, `tanggal_kadaluarsa`, `id_pemasok`, `created_at`, `updated_at`) VALUES
('S03', 'Sosis Ayam', 'Bahan', 40, 11, '2022-04-05', 2, '2024-12-23 15:04:26', '2024-12-23 16:00:10');

-- --------------------------------------------------------

--
-- Table structure for table `barang_masuk_keluars`
--

CREATE TABLE `barang_masuk_keluars` (
  `id` int(11) NOT NULL,
  `kd_barang` varchar(5) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `tipe` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang_masuk_keluars`
--

INSERT INTO `barang_masuk_keluars` (`id`, `kd_barang`, `jumlah`, `tanggal`, `tipe`) VALUES
(9, 'S03', 5, '2024-11-02', 'masuk'),
(11, 'S03', 5, '2022-12-03', 'keluar');

--
-- Triggers `barang_masuk_keluars`
--
DELIMITER $$
CREATE TRIGGER `after_barang_masuk_keluars_delete` AFTER DELETE ON `barang_masuk_keluars` FOR EACH ROW BEGIN
    IF OLD.tipe = 'masuk' THEN
        -- Kurangi stok jika tipe adalah 'masuk'
        UPDATE barangs
        SET stok = stok - OLD.jumlah
        WHERE kd_barang = OLD.kd_barang;
    ELSEIF OLD.tipe = 'keluar' THEN
        -- Tambah stok jika tipe adalah 'keluar'
        UPDATE barangs
        SET stok = stok + OLD.jumlah
        WHERE kd_barang = OLD.kd_barang;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_barang_masuk_keluars_insert` AFTER INSERT ON `barang_masuk_keluars` FOR EACH ROW BEGIN
    IF NEW.tipe = 'masuk' THEN
        -- Tambah stok jika tipe adalah 'masuk'
        UPDATE barangs
        SET stok = stok + NEW.jumlah
        WHERE kd_barang = NEW.kd_barang;
    ELSEIF NEW.tipe = 'keluar' THEN
        -- Kurangi stok jika tipe adalah 'keluar'
        UPDATE barangs
        SET stok = stok - NEW.jumlah
        WHERE kd_barang = NEW.kd_barang;
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `after_barang_masuk_keluars_update` AFTER UPDATE ON `barang_masuk_keluars` FOR EACH ROW BEGIN
    IF OLD.tipe = 'masuk' THEN
        -- Jika tipe lama adalah 'masuk', kurangi stok dengan jumlah lama
        UPDATE barangs
        SET stok = stok - OLD.jumlah
        WHERE kd_barang = OLD.kd_barang;
    ELSEIF OLD.tipe = 'keluar' THEN
        -- Jika tipe lama adalah 'keluar', tambahkan stok dengan jumlah lama
        UPDATE barangs
        SET stok = stok + OLD.jumlah
        WHERE kd_barang = OLD.kd_barang;
    END IF;

    IF NEW.tipe = 'masuk' THEN
        -- Jika tipe baru adalah 'masuk', tambahkan stok dengan jumlah baru
        UPDATE barangs
        SET stok = stok + NEW.jumlah
        WHERE kd_barang = NEW.kd_barang;
    ELSEIF NEW.tipe = 'keluar' THEN
        -- Jika tipe baru adalah 'keluar', kurangi stok dengan jumlah baru
        UPDATE barangs
        SET stok = stok - NEW.jumlah
        WHERE kd_barang = NEW.kd_barang;
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `pemasoks`
--

CREATE TABLE `pemasoks` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` text NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemasoks`
--

INSERT INTO `pemasoks` (`id`, `nama`, `alamat`, `no_telepon`, `created_at`, `updated_at`) VALUES
(1, 'PT Maju Sejahtera', 'Jl. Kebon Jeruk No. 45, Jakarta', '081234567890', '2024-12-11 20:32:42', '2024-12-11 20:32:42'),
(2, 'PT Sukses Abadi', 'Jl. Melati No. 10', '081234567891', '2024-12-11 20:32:42', '2024-12-11 20:32:42'),
(3, 'Jali', 'Jalan Talas panjang', '0821232433', '2024-12-11 22:05:56', '2024-12-12 21:10:11'),
(8, 'Jakaa', 'Jakarta', '2', '2024-12-17 06:04:31', '2024-12-23 14:48:26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barangs`
--
ALTER TABLE `barangs`
  ADD PRIMARY KEY (`kd_barang`),
  ADD KEY `id_pemasok` (`id_pemasok`);

--
-- Indexes for table `barang_masuk_keluars`
--
ALTER TABLE `barang_masuk_keluars`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kd_barang` (`kd_barang`);

--
-- Indexes for table `pemasoks`
--
ALTER TABLE `pemasoks`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang_masuk_keluars`
--
ALTER TABLE `barang_masuk_keluars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `pemasoks`
--
ALTER TABLE `pemasoks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barangs`
--
ALTER TABLE `barangs`
  ADD CONSTRAINT `barangs_ibfk_1` FOREIGN KEY (`id_pemasok`) REFERENCES `pemasoks` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `barang_masuk_keluars`
--
ALTER TABLE `barang_masuk_keluars`
  ADD CONSTRAINT `barang_masuk_keluars_ibfk_1` FOREIGN KEY (`kd_barang`) REFERENCES `barangs` (`kd_barang`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
