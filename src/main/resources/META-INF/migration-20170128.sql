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

commit;


-- -------------------- BACKWARD --------------------

begin

drop table "users";

commit;