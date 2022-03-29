

CREATE TABLE IF NOT EXISTS `pm_application` (
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



CREATE TABLE IF NOT EXISTS `pm_app_func` (
    `id` varchar(50) NOT NULL,
    `application_id` varchar(50) DEFAULT NULL,
    `name` varchar(64) NOT NULL,
    `func_code` varchar(30) NOT NULL,
    `func_url` varchar(512) NOT NULL,
    `description` varchar(1024) DEFAULT NULL,
    `sort_number` tinyint(4) DEFAULT NULL,
    `is_deleted` int(11) DEFAULT NULL,
    `version` int(11) DEFAULT NULL,
    `create_time` datetime NOT NULL DEFAULT current_timestamp(),
    `edit_time` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    `create_user` varchar(50) DEFAULT NULL,
    `edit_user` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='平台应用功能';