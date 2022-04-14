create table `groups`
(
    group_id int auto_increment
        primary key,
    number   int not null
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.`groups` (number) VALUES (598);