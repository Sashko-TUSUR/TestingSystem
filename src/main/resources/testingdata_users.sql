create table users
(
    user_id     int auto_increment
        primary key,
    user_name   varchar(150) not null,
    password    varchar(255) not null,
    name        varchar(150) not null,
    last_name   varchar(200) not null,
    middle_name varchar(50)  not null
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.users (user_name, password, name, last_name, middle_name) VALUES ('admin', '$2y$12$IzIerRZu5HXG9G57Q.A/neLHEwin3iwNLd0w2UV9tdyn1NCsFev3K', 'Admin', 'admin', 'admin');
INSERT INTO testingdata.users (user_name, password, name, last_name, middle_name) VALUES ('student', '$2y$12$.S.x02X4vPXUHUniF.AgiOcjJ921ZwVwnK8WC/gZy1jog20uhXxbG', 'Student', 'student', 'student');
INSERT INTO testingdata.users (user_name, password, name, last_name, middle_name) VALUES ('teacher', '$2y$12$IohfW.zQBy1azg5fPW5XMeJLFLgaX1XvTELDgaU.TbVDKtyWaDYvi', 'Teacher', 'teacher', 'teacher');