-- 创建库
create database if not exists interface_api;

-- 切换库
use interface_api;

-- 土味情话表
create table if not exists love_words
(
    id           bigint auto_increment comment 'id' primary key,
    loveWord varchar(512)                           not null comment '情话'
    ) comment '情话' collate = utf8mb4_unicode_ci engine MYISAM;

-- 诗词表
create table if not exists poem_words
(
    id           bigint auto_increment comment 'id' primary key,
    loveWord varchar(512)                           not null comment '诗词'
) comment '诗词' collate = utf8mb4_unicode_ci engine MYISAM;

-- 神回复表
create table if not exists god_words
(
    id           bigint auto_increment comment 'id' primary key,
    godWord varchar(512)                           not null comment '神回复'
) comment '神回复' collate = utf8mb4_unicode_ci engine MYISAM;

-- 舔狗表
create table if not exists dog_words
(
    id           bigint auto_increment comment 'id' primary key,
    dogWord varchar(512)                           not null comment '舔狗日记'
) comment '舔狗日记' collate = utf8mb4_unicode_ci engine MYISAM;
-- 毒鸡汤表
create table if not exists bad_words
(
    id           bigint auto_increment comment 'id' primary key,
    badWord varchar(512)                           not null comment '毒鸡汤'
) comment '毒鸡汤' collate = utf8mb4_unicode_ci engine MYISAM;
