
-- ds1

CREATE DATABASE IF NOT EXISTS user_ds DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;
use user_ds;

CREATE TABLE IF NOT EXISTS `t_user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(64) NOT NULL,
    `is_deleted` int(11) DEFAULT NULL,
    `create_time` datetime NOT NULL DEFAULT current_timestamp(),
    `edit_time` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    `create_user` bigint DEFAULT NULL,
    `edit_user` bigint DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


-- ds2

CREATE DATABASE IF NOT EXISTS article_ds DEFAULT CHARACTER SET utf8mb4 DEFAULT COLLATE utf8mb4_general_ci;
use article_ds;


CREATE TABLE IF NOT EXISTS `t_article` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(64) NOT NULL,
    `is_deleted` int(11) DEFAULT NULL,
    `create_time` datetime NOT NULL DEFAULT current_timestamp(),
    `edit_time` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    `create_user` bigint DEFAULT NULL,
    `edit_user` bigint DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';


DROP TABLE user_ds.t_user;

DROP TABLE article_ds.t_article;