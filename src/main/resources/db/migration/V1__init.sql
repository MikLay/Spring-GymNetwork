-- we don't know how to generate root <with-no-name> (class Root) :(
create table gyms
(
	gym_id int auto_increment
		primary key,
	country varchar(45) not null,
	town varchar(45) not null,
	area varchar(45) null,
	street varchar(45) not null,
	building int not null,
	office int null,
	fine int not null,
	post_index varchar(45) not null,
	email varchar(45) not null,
	description varchar(2500) not null
);

create table equipment
(
	equipment_id int auto_increment
		primary key,
	name varchar(45) not null,
	type varchar(45) not null,
	`condition` varchar(45) not null,
	photo_url varchar(250) not null,
	gym_id int not null,
	constraint photo_gym_id
		foreign key (gym_id) references gyms (gym_id)
			on update cascade on delete cascade
);

create index gym_id_idx
	on equipment (gym_id);

create table gym_photos
(
	photo_id int auto_increment
		primary key,
	photo_url varchar(250) not null,
	gym_id int not null,
	constraint gym_photos_gyms_gym_id_fk
		foreign key (gym_id) references gyms (gym_id)
			on update cascade on delete cascade
);

create table users
(
	user_id int auto_increment
		primary key,
	role varchar(50) not null,
	email varchar(50) not null,
	password varchar(250) not null
);

create table clients
(
	client_id int auto_increment
		primary key,
	lastname varchar(45) not null,
	firstname varchar(45) not null,
	middlename varchar(45) null,
	photo_url varchar(750) not null,
	phone varchar(45) not null,
	birth_date date not null,
	constraint clients_users_user_id_fk
		foreign key (client_id) references users (user_id)
			on update cascade on delete cascade
);

create table coaches
(
	coach_id int auto_increment
		primary key,
	lastname varchar(45) not null,
	firstname varchar(45) not null,
	middlename varchar(45) null,
	email varchar(45) not null,
	phone varchar(45) not null,
	country varchar(45) not null,
	town varchar(45) not null,
	area varchar(45) null,
	street varchar(45) not null,
	building varchar(45) not null,
	flat int null,
	sport_rang varchar(45) null,
	payment int not null,
	sex tinyint(1) not null,
	photo_url varchar(250) not null,
	constraint coaches_users_user_id_fk
		foreign key (coach_id) references users (user_id)
			on update cascade
);

create table subscriptions
(
	subscription_id int auto_increment
		primary key,
	start_date date not null,
	end_date date not null,
	workout_start_time time not null,
	client_id int null,
	workout_end_time time not null,
	price int not null,
	constraint owner_id
		foreign key (client_id) references clients (client_id)
);

create index client_id_idx
	on subscriptions (client_id);

create table timetables
(
	timetable_id int auto_increment
		primary key,
	day int not null,
	start_time time not null,
	end_time time not null,
	coach_id int not null,
	gym_id int not null,
	constraint coach
		foreign key (coach_id) references coaches (coach_id)
			on delete cascade,
	constraint gym
		foreign key (gym_id) references gyms (gym_id)
			on update cascade on delete cascade
);

create index coach_idx
	on timetables (coach_id);

create index gym_idx
	on timetables (gym_id);

create table workouts
(
	workout_id int auto_increment
		primary key,
	start_date datetime not null,
	end_time time not null,
	coach_id int null,
	client_id int not null,
	gym_id int not null,
	surcharge int not null,
	constraint client_id
		foreign key (client_id) references clients (client_id),
	constraint coach_id
		foreign key (coach_id) references coaches (coach_id),
	constraint gym_id
		foreign key (gym_id) references gyms (gym_id)
);

create index client_id_idx
	on workouts (client_id);

create index coach_id_idx
	on workouts (coach_id);

create index gym_id_idx
	on workouts (gym_id);

