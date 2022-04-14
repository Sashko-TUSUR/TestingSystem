create table topics
(
    topic_id   int auto_increment
        primary key,
    name       varchar(25) not null,
    count      int         null,
    id_subject int         null,
    constraint FK9mfd3rbq8ug1kv12dolgkdojh
        foreign key (id_subject) references subjects (subject_id)
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.topics (name, count, id_subject) VALUES ('Интегралы', 20, 1);
INSERT INTO testingdata.topics (name, count, id_subject) VALUES ('Дифференциальные уравнени', 10, 1);
INSERT INTO testingdata.topics (name, count, id_subject) VALUES ('Матрицы', 15, 1);
INSERT INTO testingdata.topics (name, count, id_subject) VALUES ('Вектора', 5, 1);
INSERT INTO testingdata.topics (name, count, id_subject) VALUES ('Microsoft Word', 20, 2);
INSERT INTO testingdata.topics (name, count, id_subject) VALUES ('Принтер', 10, 2);
INSERT INTO testingdata.topics (name, count, id_subject) VALUES ('Клавиатура', 10, 2);