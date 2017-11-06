-- 删表
DROP TABLE IF EXISTS student;

-- 建表
CREATE TABLE IF NOT EXISTS `student` (
  `id`          INT UNSIGNED AUTO_INCREMENT,
  `no`          VARCHAR(10) NOT NULL,
  `name`        VARCHAR(10) NOT NULL,
  `sex`         VARCHAR(10)  NOT NULL,
  `mobilephone` VARCHAR(15) NOT NULL,
  `city`        VARCHAR(10)  NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 表数据
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.001', 'Vincent', 'male', '15215140724', 'ChongQing');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.002', 'Douglass', 'male', '15215140724', 'NewYork');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.003', 'Downey', 'male', '15215140724', 'FuZhou');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.004', 'Drake', 'male', '15215140724', 'HangZhou');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.005', 'Drew', 'male', '15215140724', 'BeiJing');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.006', 'Drummond', 'male', '15215140724', 'ShangHai');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.007', 'Leonora', 'female', '15215140724', 'NanJing');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.008', 'Lucy', 'female', '15215140724', 'HeFei');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.009', 'Lily', 'female', '15215140724', 'ShenZhen');
INSERT INTO student (no, name, sex, mobilephone, city)
VALUES ('No.010', 'Tom', 'male', '15215140724', 'ChengDu');