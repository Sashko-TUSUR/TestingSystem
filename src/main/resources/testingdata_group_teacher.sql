create table group_teacher
(
    teacher_id int not null,
    group_id   int not null,
    constraint FK2x8ab78qcr0vi7f1yr1fr69ki
        foreign key (group_id) references `groups` (group_id),
    constraint FKglv3i20f9cx15em1wpj3x7jdp
        foreign key (teacher_id) references teachers (teacher_id)
);

