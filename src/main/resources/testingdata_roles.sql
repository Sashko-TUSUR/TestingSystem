create table roles
(
    role_id int auto_increment
        primary key,
    role    varchar(150) null
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.roles (role) VALUES ('ROLE_STUDENT');
INSERT INTO testingdata.roles (role) VALUES ('ROLE_TEACHER');
INSERT INTO testingdata.roles (role) VALUES ('ROLE_ADMIN');