# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  customer_id                   bigint auto_increment not null,
  name                          varchar(255),
  password                      varchar(255),
  constraint pk_customer primary key (customer_id)
);

create table employee (
  employee_id                   bigint auto_increment not null,
  role                          varchar(255),
  firstname                     varchar(255),
  lastname                      varchar(255),
  constraint pk_employee primary key (employee_id)
);

create table project (
  project_id                    bigint auto_increment not null,
  name                          varchar(255),
  description                   varchar(255),
  customer_customer_id          bigint,
  constraint pk_project primary key (project_id)
);

create table task (
  task_id                       bigint auto_increment not null,
  title                         varchar(255),
  duration                      bigint,
  description                   varchar(255),
  project_project_id            bigint,
  constraint pk_task primary key (task_id)
);

alter table project add constraint fk_project_customer_customer_id foreign key (customer_customer_id) references customer (customer_id) on delete restrict on update restrict;
create index ix_project_customer_customer_id on project (customer_customer_id);

alter table task add constraint fk_task_project_project_id foreign key (project_project_id) references project (project_id) on delete restrict on update restrict;
create index ix_task_project_project_id on task (project_project_id);


# --- !Downs

alter table project drop foreign key fk_project_customer_customer_id;
drop index ix_project_customer_customer_id on project;

alter table task drop foreign key fk_task_project_project_id;
drop index ix_task_project_project_id on task;

drop table if exists customer;

drop table if exists employee;

drop table if exists project;

drop table if exists task;

