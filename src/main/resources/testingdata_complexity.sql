create table complexity
(
    complexity_id int auto_increment
        primary key,
    name          varchar(25) not null
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.complexity (name) VALUES ('Легкий');
INSERT INTO testingdata.complexity (name) VALUES ('Средний');
INSERT INTO testingdata.complexity (name) VALUES ('Сложный');