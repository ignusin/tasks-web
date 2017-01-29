-- -------------------- FORWARD --------------------

begin;

create table "users" (
	"id"		serial			not null,
	"name"		varchar(50)		not null,
	"password"	varchar(50)		not null,
	"email"		varchar(50)		not null,
	"is_admin"	boolean			not null
);

alter table "users" add constraint "pk_users" primary key ("id");

insert into "users" ("name", "password", "email", "is_admin") values ('admin', '`123qwe', 'y.gnusin@gmail.com', TRUE);
insert into "users" ("name", "password", "email", "is_admin") values ('zif', '`123qwe', 'y.gnusin@gmail.com', FALSE);


create table "projects" (
	"id"		serial			not null,
	"name"		varchar(100)	not null,
	"owner_id"	int				not null
);

alter table "projects" add constraint "pk_projects" primary key ("id");

alter table "projects" add constraint "fk_projects_to_users_owner_id" foreign key ("owner_id") references "users" ("id");


commit;


-- -------------------- BACKWARD --------------------

begin

drop table "projects"
drop table "users";

commit;
