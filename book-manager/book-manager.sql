-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema book_manager
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema book_manager
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `book_manager` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `book_manager` ;

-- -----------------------------------------------------
-- Table `book_manager`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_manager`.`admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `birthday` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `book_manager`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `book_manager`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `detail` VARCHAR(255) NULL DEFAULT NULL,
  `count` INT NOT NULL,
  `photo` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO Book (name, detail, count, photo) VALUES
('Clean code', 'Sách lập trình', 100, "anh.png"),
('Ngữ văn 12', 'Sách giáo khoa', 200, "anh.png"),
('Giải tích 1', 'Sách giáo trình', 300, "anh.png"),
('Lập trình C#', 'Sách giáo trình', 100, "anh.png"),
('Học làm giàu', 'Sách self help', 200, "anh.png"),
('Cha giàu, cha nghèo', 'Sách self help', 100, "anh.png"),
('Giải tích 2', 'Sách giáo trình', 200, "anh.png"),
('Thể chất 1', 'Sách giáo trình', 300, "anh.png"),
('Triết học căn bản', 'Sách giáo trình', 100, "anh.png"),
('Tin học 12', 'Sách giáo khoa', 200, "anh.png"),
('Tuổi trẻ', 'Sách báo', 100, "anh.png"),
('Lập trình Java', 'Sách giáo trình', 200, "anh.png"),
('Giải tích 3', 'Sách giáo trình', 300, "anh.png"),
('Lập trình C', 'Sách giáo trình', 100, "anh.png"),
('Master Spring Boot', 'Sách tham khảo', 200, "anh.png"),
('Tấm Cám', 'Sách truyện', 100, "anh.png"),
('Head First', 'Sách tham khảo', 200, "anh.png"),
('Complete Java Master', 'Sách lập trình', 300, "anh.png"),
('Tôi tự học', 'Sách self help', 100, "anh.png"),
('Dế mèm phiêu lưu ký', 'Sách tự truyện', 200, "anh.png"),
('Tin học nâng cao', 'Sách giáo trình', 100, "anh.png"),
('From beginer to expect', 'Sách lập trình', 100, "anh.png"),
('Đắc nhân tâm', 'Sách self help', 200, "anh.png"),
('Toán tuổi thơ', 'Sách báo', 300, "anh.png"),
('Lập trình C#', 'Sách giáo trình', 100, "anh.png"),
('Học làm giàu', 'Sách self help', 200, "anh.png"),
('Đừng bao giờ đi ăn một mình', 'Sách self help', 100, "anh.png"),
('Giải tích 2', 'Sách giáo trình', 200, "anh.png"),
('Thể chất 1', 'Sách giáo trình', 300, "anh.png"),
('Triết học căn bản', 'Sách giáo trình', 100, "anh.png"),
('Tin học 12', 'Sách giáo khoa', 200, "anh.png"),
('Tuổi trẻ', 'Sách báo', 100, "anh.png"),
('Lập trình Java', 'Sách giáo trình', 200, "anh.png"),
('Giải tích 3', 'Sách giáo trình', 300, "anh.png"),
('Lập trình C', 'Sách giáo trình', 100, "anh.png"),
('Master Spring Boot', 'Sách tham khảo', 200, "anh.png"),
('Tấm Cám', 'Sách truyện', 100, "anh.png"),
('Head First', 'Sách tham khảo', 200, "anh.png"),
('Complete Java Master', 'Sách lập trình', 300, "anh.png"),
('Tôi tự học', 'Sách self help', 100, "anh.png"),
('Dế mèm phiêu lưu ký', 'Sách tự truyện', 200, "anh.png"),
('Tin học nâng cao', 'Sách giáo trình', 100, "anh.png");

INSERT INTO Admin (username, password, birthday) VALUES ("Quynh", 116, "2000-06-10");
