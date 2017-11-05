CREATE TABLE employee (
	employee_id bigserial primary key,
	first_name varchar,
	last_name VARCHAR,
	manager_id bigint references employee (employee_id)
);
