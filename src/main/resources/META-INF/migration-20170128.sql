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


create table "tasks" (
	"id"				serial			not null,
	"parent_id"			int				null,
	"name"				varchar(200)	not null,
	"description"		text			not null,
	"owner_id"			int				not null,
	"assigned_to_id"	int				not null,
	"finished"			boolean			not null,
	"created_at"		timestamp 		not null,
	"finished_at"		timestamp 		null
);

alter table "tasks" add constraint "pk_tasks" primary key ("id");

alter table "tasks" add constraint "fk_tasks_to_tasks_parent_id" foreign key ("parent_id") references "tasks" ("id");

alter table "tasks" add constraint "fk_tasks_to_users_owner_id" foreign key ("owner_id") references "users" ("id");

alter table "tasks" add constraint "fk_tasks_to_users_assigned_to_id" foreign key ("assigned_to_id") references "users" ("id");


create table "root_tasks" (
	"id"				serial			not null,
	"project_id"		int				not null,
	"task_id"			int				not null
);

alter table "root_tasks" add constraint "pk_root_tasks" primary key ("id");

alter table "root_tasks" add constraint "fk_root_tasks_to_projects_project_id" foreign key ("project_id") references "projects" ("id");

alter table "root_tasks" add constraint "fk_root_tasks_to_tasks_task_id" foreign key ("task_id") references "tasks" ("id");


commit;


-- -------------------- BACKWARD --------------------

begin

drop table "root_tasks";
drop table "tasks";
drop table "projects"
drop table "users";

commit;
