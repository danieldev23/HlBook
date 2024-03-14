-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th3 14, 2024 lúc 07:56 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_final`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `post_content` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `posts`
--

INSERT INTO `posts` (`id`, `user_id`, `post_content`, `image`) VALUES
(26, 4, '', 'file:/Users/macbook/Documents/Projects/Java/HuyLinhSocial/src/main/resources/images/_2019c38c-80a1-4e50-bade-bf35c4a17f7b.jpeg'),
(34, 8, '', 'file:/Users/macbook/Documents/Projects/Java/HuyLinhSocial/src/main/resources/images/_ade93624-39d5-4141-85fc-7edfb73bf242.jpeg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `avatar` varchar(1024) DEFAULT 'file:/Users/macbook/Documents/Projects/Java/HuyLinhSocial/src/main/resources/images/person.png',
  `name` varchar(255) NOT NULL,
  `date_of_birth` varchar(30) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `avatar`, `name`, `date_of_birth`, `email`, `password`) VALUES
(1, 'file:/Users/macbook/Documents/Picture/logo.png', 'Huy IT', '16/01/2005', 'huyit@gmail.com', 'huy'),
(2, 'file:/Users/macbook/Documents/Projects/Java/HuyLinhSocial/src/main/resources/images/logo.png', 'Đặng Quốc Huy', '16/01/2005', 'huydev@gmail.com', 'f6f1bf7196a6d50dc890315517465f2e703101a0215e0b8b0d8ff4344ecc77a2'),
(3, 'file:/Users/macbook/Documents/Picture/anh.png', 'Huy IT', '16/01/2005', 'huyit@dev.com', 'f6f1bf7196a6d50dc890315517465f2e703101a0215e0b8b0d8ff4344ecc77a2'),
(4, 'file:/Users/macbook/Documents/Projects/Java/HuyLinhSocial/images/_2936ce17-884d-45f7-b53e-fb2677732267.jpeg', 'Hoàng Tấn Phú Quốc ', '12/03/2004', 'hoangtanphuquoc@gmail.com', '98cd0fcb5d8b055e7dc1b053c0d924f703dc533a16bac9deadddb7e6eb98d7f1'),
(5, 'file:/Users/macbook/Documents/Projects/Java/HuyLinhSocial/src/main/resources/images/logo.png', 'Đặng Quốc Huy', '16/01/2005', 'dangquochuy@gmail.com', '062eb3055a7cca84de7b4ce3e04e8e13faff28470b48c9619e6c8ca612c3d26c'),
(8, 'file:/Users/macbook/Documents/Projects/Java/HuyLinhSocial/src/main/resources/images/person.png', 'Huy IT', '16/01/2005', 'huyit123@gmail.com', '187c6c9e881d33ab9c94cb369d76f8d16e505143bd6fedbfe80ccf3f413d98d2');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `posts_user_id_foreign` (`user_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
