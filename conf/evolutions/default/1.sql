# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table furniture (
  id                            integer not null,
  furniture_name                varchar(255),
  furniture_acquisition_date    varchar(255),
  furniture_cost                varchar(255),
  furniture_barcode             varchar(255),
  occupying_dept                varchar(255),
  occupant                      varchar(255),
  building_no                   varchar(255),
  floor_no                      varchar(255),
  room                          varchar(255),
  space_type                    varchar(255),
  space_code                    varchar(255),
  task                          varchar(255),
  status                        varchar(255),
  date_to_carry_out_the_task    varchar(255),
  completed_date                varchar(255),
  destination_dept              varchar(255),
  destination_dept_occupant     varchar(255),
  destination_building_no       varchar(255),
  destination_floor_no          varchar(255),
  destination_room              varchar(255),
  destination_space_type        varchar(255),
  destination_space_code        varchar(255),
  sold_agent                    varchar(255),
  bought_agent                  varchar(255),
  repair_details                varchar(255),
  key                           varchar(255),
  constraint pk_furniture primary key (id)
);
create sequence furniture_seq;

create table login (
  email                         varchar(255) not null,
  first_name                    varchar(255),
  last_name                     varchar(255),
  password                      varchar(255),
  confirm_password              varchar(255),
  constraint pk_login primary key (email)
);

create table office (
  id                            integer not null,
  occupying_dept                varchar(255),
  occupant                      varchar(255),
  occupying_building_no         varchar(255),
  occupying_floor_no            varchar(255),
  occupying_room                varchar(255),
  occupying_space_type          varchar(255),
  occupying_space_code          varchar(255),
  destined_dept                 varchar(255),
  destined_occupant             varchar(255),
  destined_building_no          varchar(255),
  destined_floor_no             varchar(255),
  destined_room                 varchar(255),
  destined_space_type           varchar(255),
  destined_space_code           varchar(255),
  todo                          varchar(255),
  status                        varchar(255),
  date_to_carry_out_the_task    varchar(255),
  completed_date                varchar(255),
  maintenance_call              varchar(255),
  call_status                   varchar(255),
  reference_details             varchar(255),
  constraint pk_office primary key (id)
);
create sequence office_seq;


# --- !Downs

drop table if exists furniture;
drop sequence if exists furniture_seq;

drop table if exists login;

drop table if exists office;
drop sequence if exists office_seq;

