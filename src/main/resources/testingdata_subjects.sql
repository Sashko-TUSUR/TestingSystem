create table subjects
(
    subject_id int auto_increment
        primary key,
    name       varchar(25) not null
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.subjects (name) VALUES ('Математика');
INSERT INTO testingdata.subjects (name) VALUES ('Информатика');