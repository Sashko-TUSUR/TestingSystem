create table users_complexity
(
    user_id       int not null,
    complexity_id int not null,
    constraint FK71smes2ihhvx2skjxscikxfm
        foreign key (user_id) references users (user_id),
    constraint FKi3vn0ob7dspq8amx8wukhprik
        foreign key (complexity_id) references complexity (complexity_id)
);

