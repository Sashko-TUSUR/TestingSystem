create table seminar
(
    seminar_id int auto_increment
        primary key,
    number     int not null,
    constraint seminar_number_uindex
        unique (number)
);

