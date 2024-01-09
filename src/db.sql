CREATE TABLE test.departments(
                            department_id uuid primary key,
                            name varchar(50)
);

CREATE TABLE test.employees(
                          employee_id uuid primary key,
                          name varchar(50),
                          age int,
                          department_id uuid,
                          Foreign Key (department_id) REFERENCES test.departments(department_id)
);
CREATE TABLE test.audit
(
    datetime   timestamp(6),
    id         uuid not null primary key,
    event      varchar(255),
    info       varchar(255),
    table_name varchar(255)
);

CREATE TABLE test.mailing_rules
(
    id         uuid not null primary key,
    email      varchar(255),
    table_name varchar(255)
);