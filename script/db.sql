
CREATE TABLE IF NOT EXISTS `au_application_category` (
    `id` varchar(50) NOT NULL,
    `name` varchar(64) DEFAULT NULL,
    `code` varchar(50) DEFAULT NULL,
    `description` varchar(1024) DEFAULT NULL,
    `is_deleted` int(11) DEFAULT NULL,
    `version` int(11) DEFAULT NULL,
    `tenant_id` varchar(50) NOT NULL,
    `create_time` datetime NOT NULL DEFAULT current_timestamp(),
    `edit_time` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分类';


CREATE TABLE IF NOT EXISTS `pm_application_category` (
    `id` varchar(50) NOT NULL,
    `name` varchar(64) DEFAULT NULL,
    `code` varchar(50) DEFAULT NULL,
    `description` varchar(1024) DEFAULT NULL,
    `is_deleted` int(11) DEFAULT NULL,
    `version` int(11) DEFAULT NULL,
    `create_time` datetime NOT NULL DEFAULT current_timestamp(),
    `edit_time` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='平台应用分类';