
CREATE DATABASE IF NOT EXISTS mybatis_plus DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;


CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);


INSERT INTO user (id, name, age, email) VALUES
(1, 'Jone', 18, 'test1@baomidou.com'),
(2, 'Jack', 20, 'test2@baomidou.com'),
(3, 'Tom', 28, 'test3@baomidou.com'),
(4, 'Sandy', 21, 'test4@baomidou.com'),
(5, 'Billie', 24, 'test5@baomidou.com');





CREATE TABLE IF NOT EXISTS `application` (
    `id` varchar(50) NOT NULL,
    `name` varchar(64) NOT NULL,
    `short_name` varchar(64) DEFAULT NULL,
    `app_code` varchar(32) NOT NULL,
    `logo` varchar(1024) DEFAULT NULL,
    `deploy_type` varchar(16) DEFAULT NULL,
    `app_type` varchar(16) NOT NULL,
    `category_id` varchar(50) DEFAULT NULL,
    `app_dev_name` varchar(64) DEFAULT NULL,
    `sort_number` int(11) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `is_using` int(11) DEFAULT NULL,
    `token_valid_mode` varchar(16) DEFAULT NULL,
    `token_chg_mode` varchar(16) DEFAULT NULL,
    `url` varchar(1024) DEFAULT NULL,
    `app_id` varchar(64) DEFAULT NULL,
    `app_secret` varchar(64) DEFAULT NULL,
    `app_version` varchar(32) DEFAULT NULL,
    `is_deleted` int(11) DEFAULT NULL,
    `version` int(11) DEFAULT NULL,
    `create_time` datetime NOT NULL DEFAULT current_timestamp(),
    `edit_time` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    `create_user` varchar(50) DEFAULT NULL,
    `edit_user` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='平台应用表';
