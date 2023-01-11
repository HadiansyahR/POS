-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2023 at 08:45 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` varchar(5) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `category` varchar(30) NOT NULL,
  `sub_category` varchar(30) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `category`, `sub_category`, `price`, `quantity`) VALUES
('P001', 'Babi Guling', 'Food', 'Pork', 20000, 5),
('P002', 'Espresso', 'Beverage', 'Coffee', 15000, 4),
('P003', 'Steak Babi', 'Food', 'Pork', 30000, 2),
('P004', 'Avocado Juice', 'Beverage', 'Juice', 10000, 5),
('P005', 'Sup Ayam', 'Food', 'Soup', 10000, 3),
('P006', 'Salad Buah Mix', 'Food', 'Salad', 40000, 4),
('P007', 'Nasi Goreng', 'Food', 'Main Course', 15000, 2),
('P008', 'Croissant', 'Food', 'Dessert', 4000, 10),
('P009', 'Vodka', 'Beverage', 'Alcoholic', 50000, 2),
('P010', 'Miposhka', 'Beverage', 'Spirit', 100000, 7),
('P011', 'Power F', 'Beverage', 'Wine', 70000, 2),
('P012', 'Liquor 2', 'Beverage', 'Liquor', 200000, 1),
('P013', 'Bloody Mary', 'Beverage', 'Cocktail', 50000, 6),
('P014', 'Coconut Water', 'Beverage', 'Non-Alcoholic', 10000, 3),
('P015', 'Mocca', 'Beverage', 'Mocktail', 10000, 4);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `table_num` varchar(5) NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `subtotal` double NOT NULL,
  `transaction_date` date NOT NULL,
  `payment_status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transaction_id`, `table_num`, `product_name`, `quantity`, `price`, `subtotal`, `transaction_date`, `payment_status`) VALUES
(1, '4', 'Babi Guling', 2, 20000, 40000, '2023-01-02', 0),
(1, '4', 'Espresso', 1, 15000, 15000, '2023-01-02', 0),
(2, 'TA', 'Nasi Goreng', 2, 15000, 30000, '2023-01-03', 0),
(3, 'TA', 'Sup Ayam', 1, 10000, 10000, '2023-01-11', 0),
(3, 'TA', 'Espresso', 1, 15000, 15000, '2023-01-11', 0),
(3, 'TA', 'Miposhka', 2, 100000, 200000, '2023-01-11', 0),
(4, '5', 'Salad Buah Mix', 1, 40000, 40000, '2023-01-11', 0),
(4, '5', 'Coconut Water', 1, 10000, 10000, '2023-01-11', 0);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `pin` int(5) NOT NULL,
  `username` varchar(30) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`pin`, `username`, `role`) VALUES
(1311, 'lele', 'Admin'),
(2311, 'micel', 'Waiter'),
(3311, 'hadi', 'Cashier');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`pin`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
