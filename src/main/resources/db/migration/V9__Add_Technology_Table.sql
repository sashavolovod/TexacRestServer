CREATE TABLE technologies (
    technology_id bigint not null primary key,
    order_id INTEGER NOT NULL,           -- NППЗаказа
    detail_number INTEGER NOT NULL,      -- NППДетали
    operation_number INTEGER NOT NULL,   -- NОперации
    operation VARCHAR(21) NOT NULL,      -- Операция
    operation_content TEXT,              -- СодержаниеОперации
    time_norm REAL,                      -- НормаВремени
    need_program BOOLEAN,                -- NeedProgram
    optic_program BOOLEAN,               -- OpticProg
    optic_program_date TIMESTAMP         -- OptigProgDate
) inherits (base_table);

create index order_date_idx on orders(order_date);
create index order_execution_order_id_idx on order_execution(order_id);
create index employees_personnel_number_idx on employees(personnel_number);