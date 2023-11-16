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