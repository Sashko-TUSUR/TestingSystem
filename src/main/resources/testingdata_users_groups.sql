create table users_groups
(
    user_id  int null,
    group_id int null,
    constraint FKg6fu0mfuj9eqfd9aro1nc40nn
        foreign key (user_id) references users (user_id),
    constraint FKggimqo8cv8s5p5wcjmlioodyw
        foreign key (group_id) references `groups` (group_id)
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.users_groups (user_id, group_id) VALUES (2, 1);