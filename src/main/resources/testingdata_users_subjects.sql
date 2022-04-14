create table users_subjects
(
    user_id    int null,
    subject_id int null,
    constraint FK9tmns3it52rhjqw5hux4h6wij
        foreign key (subject_id) references subjects (subject_id),
    constraint FKsn0dpj3fv7qro51mhbo743cck
        foreign key (user_id) references users (user_id)
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.users_subjects (user_id, subject_id) VALUES (2, 1);
INSERT INTO testingdata.users_subjects (user_id, subject_id) VALUES (2, 2);
INSERT INTO testingdata.users_subjects (user_id, subject_id) VALUES (3, 1);