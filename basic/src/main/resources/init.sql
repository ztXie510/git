-- 创建数据库
CREATE DATABASE IF NOT EXISTS ffms_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE ffms_db;

-- 创建用户
CREATE USER IF NOT EXISTS 'springuser'@'%' IDENTIFIED BY 'springpass';
GRANT ALL PRIVILEGES ON ffms_db.* TO 'springuser'@'%';
FLUSH PRIVILEGES;

-- 设置字符集
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- 导入表结构
-- 注意：这里的表结构会通过JPA自动创建，如果需要自定义，请修改application.properties中的ddl-auto

SET FOREIGN_KEY_CHECKS = 1;