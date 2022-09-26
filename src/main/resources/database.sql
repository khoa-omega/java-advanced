-- Drop the database if it already exists
DROP DATABASE IF EXISTS department_manager;
-- Create database
CREATE DATABASE IF NOT EXISTS department_manager;
USE department_manager;

-- Create table department
DROP TABLE IF EXISTS department;
CREATE TABLE IF NOT EXISTS department (
	id 						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`name` 					VARCHAR(50) NOT NULL UNIQUE KEY,
    total_members			INT	UNSIGNED NOT NULL,
    `type`					ENUM('D', 'T', 'S', 'P') NOT NULL,
    created_date			DATETIME DEFAULT NOW()
);

-- create table: account
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`(
	id						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username				VARCHAR(50) NOT NULL UNIQUE KEY,
	`password` 				VARCHAR(800) NOT NULL,
    first_name				NVARCHAR(50) NOT NULL,
    last_name				NVARCHAR(50) NOT NULL,
    `role` 					ENUM('ADMIN', 'EMPLOYEE', 'MANAGER') NOT NULL DEFAULT 'EMPLOYEE',
    department_id 			INT UNSIGNED NOT NULL,
    FOREIGN KEY(department_id) REFERENCES department(id)
);

-- =============================================
-- INSERT DATA 
-- =============================================
-- Add data department
INSERT INTO department(	`name`	, total_members, 	`type`, 		created_date) 
VALUES
						('Marketing'	, 		1,		'D', 			'2020-03-05'),
						('Sale'			, 		2,		'T', 			'2020-03-05'),
						('Bảo vệ'		, 		3,		'S', 			'2020-03-07'),
						('Nhân sự'		, 		4,		'P', 			'2020-03-08'),
						('Kỹ thuật'		, 		5,		'D', 			'2020-03-10'),
						('Tài chính'	, 		6,		'S', 			NOW()		),
						('Phó giám đốc'	, 		7,		'P', 			NOW()		),
						('Giám đốc'		, 		8,		'T', 			'2020-04-07'),
						('Thư kí'		, 		9,		'P', 			'2020-04-07'),
						('Bán hàng'		, 		1,		'D', 			'2020-04-09');
                    
-- Add data account
-- Password: 123456
INSERT INTO `Account`(	username		,						`password`									,	first_name	,	last_name	,		`role`		,	department_id	)
VALUES 				(	'dangblack'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Hai Dang'	,		'ADMIN'		,		'5'			),
					(	'quanganh'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Quang Anh'	,		'MANAGER'	,		'1'			),
                    (	'vanchien'		,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Van Chien'	,		'ADMIN'		,		'1'			),
                    (	'cocoduongqua'	,	'$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Co Co'		,		'EMPLOYEE'	,		'1'			),
                    (	'doccocaubai'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Doc Co'	,		'ADMIN'		,		'2'			),
                    (	'khabanh'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan'		,	'Kha Bang'	,		'EMPLOYEE'	,		'2'			),
                    (	'huanhoahong'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Van Huan'	,		'ADMIN'		,		'2'			),
                    (	'tungnui'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Nguyen'	,	'Tung Nui'	,		'MANAGER'	,		'8'			),
                    (	'duongghuu'		,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Phan'		,	'Duong Huu'	,		'ADMIN'		,		'9'			),
                    (	'vtiaccademy'	,   '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi'	,	'Tran'		,	'Academy'	,		'MANAGER'	,		'10'		);