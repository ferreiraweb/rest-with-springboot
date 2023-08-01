

-- Copiando estrutura para tabela rest_with_spring_boot_erudio.car
CREATE TABLE IF NOT EXISTS `car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand` varchar(10) NOT NULL,
  `model` varchar(20) NOT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando estrutura para tabela rest_with_spring_boot_erudio.person
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `fist_name` varchar(80) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `last_name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


