create table template
(
    template_id  int auto_increment
        primary key,
    user_id      int         not null,
    topic_id     int         not null,
    closing_date datetime    not null,
    settings     json        not null,
    type         varchar(10) not null,
    opening_date datetime    not null,
    constraint FKdjl177n13c7qmsoxp434nkml0
        foreign key (user_id) references users (user_id),
    constraint FKhmgwhl71qn3pfpjtb0ot9caq4
        foreign key (topic_id) references topics (topic_id)
);

