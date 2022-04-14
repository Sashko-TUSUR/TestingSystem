create table user_role
(
    user_id int null,
    role_id int null,
    constraint FKj345gk1bovqvfame88rcx7yyx
        foreign key (user_id) references users (user_id),
    constraint FKt7e7djp752sqn6w22i6ocqy6q
        foreign key (role_id) references roles (role_id)
)
    collate = utf8_unicode_ci;

INSERT INTO testingdata.user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO testingdata.user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO testingdata.user_role (user_id, role_id) VALUES (3, 2);