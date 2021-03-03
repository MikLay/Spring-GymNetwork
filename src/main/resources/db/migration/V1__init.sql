create table roles
(
    role_id int auto_increment
        primary key,
    name    varchar(255) null
);

INSERT INTO gym_network.roles (role_id, name) VALUES (1, 'ROLE_USER');
INSERT INTO gym_network.roles (role_id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO gym_network.roles (role_id, name) VALUES (3, 'ROLE_COACH');
INSERT INTO gym_network.roles (role_id, name) VALUES (4, 'ROLE_MANAGER');
INSERT INTO gym_network.roles (role_id, name) VALUES (5, 'ROLE_CLIENT');


create table gyms
(
    id bigint auto_increment
        primary key,
    city varchar(255) null,
    country varchar(255) null,
    flat varchar(255) null,
    house varchar(255) null,
    street varchar(255) null,
    email varchar(255) null,
    phone varchar(255) null
);

create table equipment
(
    id bigint auto_increment
        primary key,
    equipment_condition varchar(255) null,
    name varchar(255) null,
    type varchar(255) null,
    gym_id bigint null,
    constraint FK8gr8y0dgofxp7vsrqjgp9a3jl
        foreign key (gym_id) references gyms (id)
);

create table users
(
    id bigint auto_increment
        primary key,
    account_verified bit not null,
    birth_date datetime(6) null,
    email varchar(255) null,
    first_name varchar(255) null,
    image longblob null,
    last_name varchar(255) null,
    password varchar(255) null,
    phone_number varchar(255) null,
    registration_date datetime(6) null,
    sex varchar(255) null,
    token varchar(255) null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email)
);

create table clients
(
    id bigint not null
        primary key,
    constraint FK1hgwdp9vl25xl9i7s354sifey
        foreign key (id) references users (id)
);

create table coaches
(
    city varchar(255) null,
    country varchar(255) null,
    flat varchar(255) null,
    house varchar(255) null,
    street varchar(255) null,
    payment bigint null,
    rang varchar(255) null,
    id bigint not null
        primary key,
    constraint FKbyei1g9vs5d057vur8psubw3x
        foreign key (id) references users (id)
);

create table manager
(
    id bigint not null
        primary key,
    constraint FKmqwhyh7lyvaoxegkx6nwj5u43
        foreign key (id) references users (id)
);

create table manager_gym
(
    manager_id bigint not null,
    gym_id bigint not null,
    constraint FK6ikiyfiw7usa6wx4uu1shum3p
        foreign key (gym_id) references gyms (id),
    constraint FKr7e0mcr0h1y2t8iby6kum84es
        foreign key (manager_id) references manager (id)
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
    constraint FKjee0y5bc9uy34jy86boygrjhl
        foreign key (user_id) references users (id)
);

create table subscriptions
(
    id bigint auto_increment
        primary key,
    end_day date null,
    end_time time null,
    price bigint null,
    start_day date null,
    start_time time null,
    client_id bigint null,
    constraint FKevklhfw4ajv4e8j1cl3c8mceh
        foreign key (client_id) references clients (id)
);

create table timetable
(
    id bigint auto_increment
        primary key,
    end_time datetime(6) null,
    start_time datetime(6) null,
    coach_id bigint null,
    gym_id bigint null,
    constraint FKc5uuhjii5xeiac1sp3dbe02jm
        foreign key (gym_id) references gyms (id),
    constraint FKqnjr12job944jt2r3to5xfmdp
        foreign key (coach_id) references coaches (id)
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

create table workouts
(
    id bigint auto_increment
        primary key,
    date date null,
    end_time time null,
    start_time time null,
    surcharge int not null,
    client_id bigint null,
    coach_id bigint null,
    gym_id bigint null,
    constraint FK5k4qtecoodyigr0fxew9y4tmg
        foreign key (coach_id) references coaches (id),
    constraint FKi2r9v4var1p9ggmtq4idfnip8
        foreign key (gym_id) references gyms (id),
    constraint FKjo0p8gr9gk1u4wir5mpmdk0t3
        foreign key (client_id) references clients (id)
);