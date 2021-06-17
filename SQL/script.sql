create sequence seq_driver;

alter sequence seq_driver owner to db_master;

create table orders
(
    id         serial  not null
        constraint orders_pk
            primary key,
    identifier varchar not null,
    status     varchar not null
);

alter table orders
    owner to db_master;

create unique index orders_identifier_uindex
    on orders (identifier);

create table cities
(
    id   serial  not null
        constraint cities_pk
            primary key,
    city varchar not null
);

alter table cities
    owner to db_master;

create unique index cities_id_uindex
    on cities (id);

create unique index cities_city_uindex
    on cities (city);

create table distance
(
    from_id  integer not null
        constraint distance_cities_id_fk
            references cities,
    to_id    integer not null
        constraint distance_cities_id_fk_2
            references cities,
    distance integer not null
);

alter table distance
    owner to db_master;

create table trucks
(
    id        serial  not null
        constraint trucks_pk
            primary key,
    number    varchar not null,
    capacity  integer not null,
    condition varchar not null,
    city_id   integer not null
        constraint trucks_cities_id_fk
            references cities,
    order_id  integer
);

alter table trucks
    owner to db_master;

create unique index trucks_id_uindex
    on trucks (id);

create unique index trucks_number_uindex
    on trucks (number);

create table users
(
    id        serial  not null
        constraint users_pk
            primary key,
    name      varchar not null,
    surname   varchar not null,
    email     varchar not null,
    password  varchar not null,
    user_role varchar not null
);

alter table users
    owner to db_master;

create table drivers
(
    id              serial  not null
        constraint drivers_pk
            primary key,
    privatenumber   varchar not null,
    status          varchar not null,
    city_id         integer
        constraint drivers_cities_id_fk
            references cities,
    truck_id        integer
        constraint drivers_trucks_id_fk
            references trucks
            on delete set null,
    user_id         integer
        constraint drivers_users_id_fk
            references users
            on delete set null,
    "currentDriver" boolean
);

alter table drivers
    owner to db_master;

create unique index drivers_id_uindex
    on drivers (id);

create table workshift
(
    id           serial  not null
        constraint workshift_pk
            primary key,
    driver_id    integer not null
        constraint workshift_drivers_id_fk
            references drivers
            on delete cascade,
    "shiftStart" timestamp,
    "shiftEnd"   timestamp
);

alter table workshift
    owner to db_master;

create table waypoints
(
    id       serial  not null
        constraint waypoints_pk
            primary key,
    order_id integer not null
        constraint waypoints_orders_id_fk
            references orders
            on delete cascade,
    city_id  integer not null
        constraint waypoints_cities_id_fk
            references cities,
    passed   varchar not null,
    queue    integer not null
);

alter table waypoints
    owner to db_master;

create table cargos
(
    "cargoNumber"      varchar not null,
    "cargoName"        varchar not null,
    weight             integer not null,
    status             varchar not null,
    order_id           integer not null
        constraint cargos_orders_id_fk
            references orders
            on delete cascade,
    "startWayPoint_id" integer not null
        constraint cargos_waypoints_id_fk
            references waypoints,
    "endWayPoint_id"   integer not null
        constraint cargos_waypoints_id_fk_2
            references waypoints,
    id                 serial  not null
        constraint cargos_pk
            primary key
);

alter table cargos
    owner to db_master;

create unique index cargo_cargonumber_uindex
    on cargos ("cargoNumber");


