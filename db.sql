--Banco de dados: DB


Create database db;

use db;

-- Estrutura da tabela `users`

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);
COMMIT;

-- Estrutura da tabela `posts`

DROP TABLE IF EXISTS `posts`;
CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `body` text NOT NULL,
  PRIMARY KEY (`id`),
    CONSTRAINT userId_FK FOREIGN KEY (userId)
    REFERENCES users(id)
);
