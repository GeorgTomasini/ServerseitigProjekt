# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table project (
  project_id                    bigint auto_increment not null,
  name                          varchar(255),
  description                   varchar(255),
  user_user_id                  bigint,
  constraint pk_project primary key (project_id)
);

create table task (
  task_id                       bigint auto_increment not null,
  title                         varchar(255),
  duration                      integer,
  description                   varchar(255),
  project_project_id            bigint,
  constraint ck_task_duration check (duration in (0,1,2)),
  constraint pk_task primary key (task_id)
);

create table user (
  user_id                       bigint auto_increment not null,
  email                         varchar(255),
  passoword                     varchar(255),
  role                          varchar(255),
  firstname                     varchar(255),
  lastname                      varchar(255),
  constraint pk_user primary key (user_id)
);

alter table project add constraint fk_project_user_user_id foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_project_user_user_id on project (user_user_id);

alter table task add constraint fk_task_project_project_id foreign key (project_project_id) references project (project_id) on delete restrict on update restrict;
create index ix_task_project_project_id on task (project_project_id);


# --- !Downs

alter table project drop foreign key fk_project_user_user_id;
drop index ix_project_user_user_id on project;

alter table task drop foreign key fk_task_project_project_id;
drop index ix_task_project_project_id on task;

drop table if exists project;

drop table if exists task;

drop table if exists user;

