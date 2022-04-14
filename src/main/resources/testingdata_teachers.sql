create table teachers
(
    teacher_id int auto_increment
        primary key,
    user_id    int null,
    subject_id int not null,
    seminar_id int not null,
    constraint FKb8dct7w2j1vl1r2bpstw5isc0
        foreign key (user_id) references users (user_id),
    constraint FKm9i33flfcc82kneh1x8fw7vb5
        foreign key (seminar_id) references seminar (seminar_id),
    constraint FKsahkj7ew9hfs6byrpl75br5lx
        foreign key (subject_id) references subjects (subject_id)
);

