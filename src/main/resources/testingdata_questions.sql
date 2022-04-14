create table questions
(
    question_id   int auto_increment
        primary key,
    question      json not null,
    complexity_id int  not null,
    topic_id      int  null,
    constraint FKdb5p6ukb0v76he4pq87cbymhg
        foreign key (topic_id) references topics (topic_id)
)
    collate = utf8_unicode_ci;

create index FK92ck40o07paypte6of0k6mhaa
    on questions (complexity_id);

