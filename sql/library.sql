-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 15 Tem 2019, 16:44:17
-- Sunucu sürümü: 10.3.15-MariaDB
-- PHP Sürümü: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `library`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admins`
--

CREATE TABLE `admins` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `admins`
--

INSERT INTO `admins` (`id`, `name`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `books`
--

CREATE TABLE `books` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` text NOT NULL,
  `writer` text NOT NULL,
  `year` date NOT NULL,
  `publisher` text NOT NULL,
  `page` int(10) UNSIGNED NOT NULL,
  `type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `books`
--

INSERT INTO `books` (`id`, `name`, `writer`, `year`, `publisher`, `page`, `type`) VALUES
(1, 'Fahrenheit 451', 'Ray Bradbury', '2018-10-01', 'İthaki Yayınları', 208, 'Roman'),
(2, 'Nutuk', 'Mustafa Kemal Atatürk', '2018-05-05', 'En Kitap', 768, 'Anı'),
(5, 'Otomatik Portakal', 'Anthony Burgess', '2019-07-01', 'İş Bankası Kültür Yayınları', 176, 'Roman'),
(6, 'Yüzüklerin Efendisi - Tek Cilt Özel Basım', 'J.R.R. Tolkien', '2019-07-08', 'Metis Yayıncılık', 1026, 'Fantastik Roman'),
(7, 'Çavdar Tarlasında Çocuklar', 'Jerome David Salinger', '2019-07-02', 'Yapı Kredi Yayınları', 200, 'Roman'),
(8, 'Huzursuzluk', 'Zülfü Livaneli', '2019-07-01', 'Doğan Kitap ', 160, 'Roman'),
(9, 'Bülbülü Öldürmek', 'Harper Lee', '2019-07-01', 'Sel Yayıncılık', 355, 'Roman'),
(10, 'Daha', 'Hakan Günday', '2019-04-08', 'Doğan Kitap', 420, 'Roman'),
(11, 'Nietzsche Ağladığında', 'Irvin D. Yalom', '2019-04-14', 'Ayrıntı Yayınları', 432, 'Roman'),
(12, 'Melekler ve Şeytanlar', 'Dan Brown', '2019-03-04', 'Altın Kitaplar', 576, 'Roman - Macera'),
(13, 'Harry Potter ve Felsefe Taşı', 'J. K. Rowling', '2016-07-12', 'Yapı Kredi Yayınları', 255, 'Fantastik Roman'),
(14, 'Harry Potter ve Sırlar Odası', 'J. K. Rowling', '2017-07-18', 'Yapı Kredi Yayınları', 350, 'Fantastik Roman'),
(15, 'hayvanlardan tanrılara - sapiens', 'yuval noah harari', '2019-04-07', 'kolektif kitap', 412, ' tarih'),
(16, 'Gör Beni-İki Devrin Hikayesi', 'Akilah Azra Kohen', '2019-07-08', 'Everest Yayınları', 592, 'Roman'),
(17, 'Duygusal Zeka', 'Bircan Yıldırım', '2017-08-14', 'Destek Yayınları', 296, 'Kişisel Gelişim'),
(18, 'Vazgeçebilmek', 'Guy Finley', '2019-07-01', 'Destek Yayınları', 304, 'Kişisel Gelişim'),
(19, 'Abartma Tozu', 'Şermin Yaşar', '2019-07-08', 'Taze Kitap', 160, 'Çocuk Öykü/Hikaye'),
(20, 'Benim Gözümden Dünya', 'Albert Einstein', '2019-07-01', 'Alfa Yayıncılık', 115, 'Bilim Tarihi ve Felsefesi'),
(21, 'Aklından Bir Sayı Tut', 'John Verdon', '2019-07-09', 'Koridor Yayıncılık', 480, 'Roman'),
(22, 'Savaş Sanatı', 'Sun Tzu', '2019-07-02', 'İş Bankası Kültür Yayınları', 56, 'Politika'),
(23, 'Otostopçunun Galaksi Rehberi', 'Douglas Adams', '2019-07-01', 'Alfa Yayıncılık', 228, 'Bilim Kurgu'),
(24, 'Küçük Kara Balık', 'Samed Behrengi', '2019-07-02', 'Kırmızı Kedi', 64, 'Masal & Hikaye Kitapları'),
(25, 'Romeo ve Juliet', 'William Shakespeare', '2019-07-01', 'İş Bankası Kültür Yayınları', 110, 'Tiyatro '),
(26, 'İnsan Nedir?', 'Mark Twain', '2019-07-08', 'Dedalus', 256, 'Dünya Öykü');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `members`
--

CREATE TABLE `members` (
  `id` int(11) UNSIGNED NOT NULL,
  `name` text NOT NULL,
  `surname` text NOT NULL,
  `regdate` timestamp NOT NULL DEFAULT current_timestamp(),
  `Tcno` bigint(11) UNSIGNED NOT NULL,
  `tel` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `members`
--

INSERT INTO `members` (`id`, `name`, `surname`, `regdate`, `Tcno`, `tel`) VALUES
(1, 'Ömer', 'Ulusoy', '2019-07-05 15:44:57', 11111111111, '05323233333'),
(2, 'Bahar', 'Kaymak', '2019-07-05 15:44:57', 22222222222, '05346987432'),
(3, 'Mahmut', 'Özsoy', '2019-07-05 15:55:48', 33333333333, '05321648975'),
(4, 'Aslı', 'Mutlu', '2019-07-05 15:55:48', 44444444444, '08974563214'),
(5, 'Cem', 'Tepikoğlu', '2019-07-05 15:55:48', 55555555555, '09856321465'),
(6, 'Emine', 'Yılmaz', '2019-07-05 15:55:48', 66666666666, '05321469751'),
(7, 'Mete', 'Hamzaoğlu', '2019-07-05 15:55:48', 77777777777, '05321456987'),
(8, 'umut ', 'patlıcan', '2019-07-05 15:55:48', 88888888888, '03214569871'),
(9, 'Çagatay ', 'Hacısalihoğlu', '2019-07-05 15:55:48', 99999999999, '05321456874'),
(10, 'Sercan', 'Kuşku', '2019-07-05 15:55:48', 10000000000, '05412398741'),
(11, 'Meryem', 'Başaran', '2019-07-05 15:55:48', 11000000000, '09874563214'),
(12, 'Canan', 'Aksoy', '2019-07-05 15:55:48', 12000000000, '05896321456'),
(13, 'Emel', 'Melek', '2019-07-05 15:55:48', 13000000000, '05412398745'),
(14, 'Tayfun', 'kar', '2019-07-05 15:55:48', 14000000000, '05321469874'),
(15, 'Zeynep', 'Kütük', '2019-07-05 15:55:48', 15000000000, '05678412365'),
(16, 'Mihriban', 'Sarı', '2019-07-05 15:55:48', 16000000000, '05321498745'),
(17, 'Can', 'Bozok', '2019-07-05 15:55:48', 17000000000, '05239874651'),
(18, 'Rümeysa', 'Durdu', '2019-07-05 15:55:48', 18000000000, '05321468545'),
(20, 'Merve', 'Korkmaz', '2019-07-05 15:55:48', 20000000000, '05322669887'),
(21, 'Betül', 'keskin', '2019-07-05 15:55:48', 21111111111, '05321456599'),
(22, 'mehmet', 'kuzu', '2019-07-05 15:55:48', 22222222222, '05332468555'),
(23, 'Leyla', 'Sönmez', '2019-07-05 15:55:48', 23333333333, '05324699877'),
(24, 'Kerem', 'Tunç', '2019-07-05 15:55:48', 24444444444, '05324489655'),
(25, 'Mustafa', 'Canıtez', '2019-07-05 15:55:48', 25555555555, '04875632555'),
(26, 'Dursun', 'Karadeniz', '2019-07-05 15:55:48', 26666666661, '05324567891'),
(27, 'Fadime', 'akçıl', '2019-07-05 15:55:48', 27777777777, '05897463121'),
(28, 'şerif', 'kaynak', '2019-07-06 18:39:49', 12312313212, '05264668873'),
(29, 'ömer', 'pekmez', '2019-07-10 22:03:46', 11111117856, '05467864378'),
(30, 'halil', 'söyletmez', '2019-07-14 14:59:35', 19000000000, '05321698895'),
(31, 'Mahmut', 'Kakız', '2019-07-14 16:33:47', 75648236541, '05322687899'),
(32, 'Çiğdem', 'duru', '2019-07-14 16:33:47', 14569874521, '05322222222'),
(33, 'Tarık', 'Karatay', '2019-07-14 16:39:39', 14568234572, '05796457123'),
(34, 'Mehmet Akif', 'Matbaacıoğlu', '2019-07-14 16:39:39', 20232023202, '99999999999'),
(35, 'Mehtap', 'Karaduman', '2019-07-14 16:39:39', 12365432178, '12365498732'),
(36, 'Hasan', 'Gül', '2019-07-14 16:39:39', 12345678998, '32178945632'),
(37, 'Mahmut', 'İpek', '2019-07-14 16:39:39', 65745632412, '12654832634');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `transactions`
--

CREATE TABLE `transactions` (
  `id` int(10) UNSIGNED NOT NULL,
  `memid` int(10) UNSIGNED NOT NULL,
  `bookid` int(10) UNSIGNED NOT NULL,
  `gudate` timestamp NOT NULL DEFAULT current_timestamp(),
  `gbdate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `transactions`
--

INSERT INTO `transactions` (`id`, `memid`, `bookid`, `gudate`, `gbdate`) VALUES
(6, 1, 2, '2019-07-14 14:59:55', '2019-08-08'),
(7, 32, 9, '2019-07-14 16:34:20', '2019-07-07');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `memid` (`memid`),
  ADD KEY `bookid` (`bookid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Tablo için AUTO_INCREMENT değeri `members`
--
ALTER TABLE `members`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Tablo için AUTO_INCREMENT değeri `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`memid`) REFERENCES `members` (`id`),
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`bookid`) REFERENCES `books` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
