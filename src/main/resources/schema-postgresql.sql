CREATE TABLE premise(
    id serial not null primary key,
    names varchar(255) not null
);

CREATE TABLE company(
    id serial not null primary key,
    names varchar(255) not null,
    premise_id int,

    foreign key(premise_id) references premise(id)
);

CREATE TABLE company_department(
    id serial not null primary key,
    names varchar(255) not null,
    company_id int,

    foreign  key(company_id) references company(id)
);

CREATE TABLE department(
    id serial not null primary key,
    names varchar(255) not null,
    company_id int,

    foreign  key(company_id) references company(id)
);

CREATE TABLE people(
    id serial not null primary key,
    nationalid int not null,
    username text,
    email text
);

CREATE TABLE attendance(
    id serial not null primary key,
    premise_id int,
    company_id int,
    companyDepartment_id int,
    department_id int,
    people_id int,

    foreign key(premise_id) references premise(id),
    foreign key(company_id) references company(id),
    foreign key(companyDepartment_id) references companyDepartment(id),
    foreign key(department_id) references department(id),
    foreign key(people_id) references people(id)
);

CREATE TABLE time_ledger(
    id serial not null primary key,
    date_checked_in varchar(255),
    date_checked_out varchar(255),
    status boolean,
    time_checked_in varchar(255),
    time_checked_out varchar(255),
    attendance_id int,

    foreign key(attendance_id) references  attendance(id)
);
