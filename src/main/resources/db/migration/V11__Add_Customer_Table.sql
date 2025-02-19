create table customers (
    customer_id bigint not null primary key,
    customer_title varchar(100),
    customer_short_title varchar(15),
    manager_name varchar(50)
) inherits (base_table);

create index orders_customer_id_idx on orders(customer_id);

create view locksmith_operations_view as select o.order_id,
       o.order_date,
       o.oboz_to,
       e.full_name,
       c.customer_title,
       sum(mc.quantity * o.qty * t.time_norm) as time_norm
                   from material_cards mc
                            inner join orders o on o.order_id = mc.order_number
                            left join employees e on o.locksmith_id = e.personnel_number
                            left join customers c on c.customer_id = o.customer_id
                            inner join technologies t
                                       on (mc.order_number = t.order_id and mc.detail_number = t.detail_number)
                   where t.operation = 'Сл.'
group by o.order_id, o.order_date, e.full_name, o.oboz_to, c.customer_title;
