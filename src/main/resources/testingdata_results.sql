create table results
(
    result_id int auto_increment
        primary key,
    variants  json        null,
    result    json        null,
    user_id   int         null,
    topic_id  int         not null,
    type      varchar(10) null,
    constraint FKxtl9ahma532if6r68yvgo7ck
        foreign key (user_id) references users (user_id)
)
    collate = utf8_unicode_ci;

