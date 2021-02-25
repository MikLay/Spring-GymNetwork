create table roles
(
    role_id int auto_increment
        primary key,
    name    varchar(255) null
);

INSERT INTO gym_network.roles (role_id, name) VALUES (1, 'ROLE_USER');
INSERT INTO gym_network.roles (role_id, name) VALUES (2, 'ROLE_ADMIN');


create table users
(
    id bigint auto_increment
        primary key,
    account_verified bit not null,
    email varchar(255) null,
    first_name varchar(255) null,
    last_name varchar(255) null,
    password varchar(255) null,
    token varchar(255) null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email)
);

create table user_roles
(
    id bigint not null,
    role_id int not null,
    primary key (id, role_id),
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (role_id),
    constraint FKnmt12ry8d6a20i1un4cj253k6
        foreign key (id) references users (id)
);

create table secure_tokens
(
    id bigint auto_increment
        primary key,
    expire_at datetime(6) not null,
    time_stamp datetime(6) null,
    token varchar(255) null,
    user_id bigint null,
    constraint UK_dlvilc17p76edkguw5kd16xl5
        unique (token),
    constraint FKbmjsiygarm7ug34j7icgorpxl
        foreign key (user_id) references users (id)
);