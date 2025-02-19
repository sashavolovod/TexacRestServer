create table tooling_categories(
    tooling_category_id bigserial primary key,
    category_template varchar(32),
    category_name varchar(64)
);

INSERT INTO tooling_categories (category_template, category_name) VALUES
('1333', 'Штампы'),
('1420', 'Штампы'),
('1425', 'Штампы'),
('1502', 'Штампы'),
('1513', 'Штампы'),
('1541', 'Штампы'),
('1563', 'Штампы'),
('1601', 'Штампы'),
('1605', 'Штампы'),
('1621', 'Штампы'),
('1622', 'Штампы'),
('1652', 'Штампы'),
('1701', 'Штампы'),
('1723', 'Штампы'),
('1741', 'Штампы'),
('1771', 'Штампы'),
('1781', 'Штампы'),
('4910', 'Штампы'),
('2101', 'Штампы'),
('1907', 'Штампы'),
('1424', 'Штампы'),
('1440', 'Штампы'),
('1449', 'Штампы'),
('1470', 'Штампы'),
('1501', 'Штампы'),
('1544', 'Штампы'),
('1602', 'Штампы'),
('1614', 'Штампы'),
('1620', 'Штампы'),
('1700', 'Штампы'),
('1722', 'Штампы'),
('1740', 'Штампы'),
('1750', 'Штампы'),
('1770', 'Штампы'),
('1780', 'Штампы'),
('21.266', 'Штампы'),
('21.166', 'Штампы'),
('15055', 'Штампы'),
('0454', 'Штампы'),
('60.3505', 'Штампы'),
('60.3504', 'Штампы'),
('1850', 'Пресс-формы (пластик)'),
('1880', 'Пресс-формы (пластик)'),
('3915', 'Пресс-формы (пластик)'),
('ЕУЛБ', 'Пресс-формы (пластик)'),
('ПФ 295', 'Пресс-формы (пластик)'),
('Ф-295', 'Пресс-формы (пластик)'),
('0543', 'Пресс-формы (алюминий)'),
('ИСГК', 'Пресс-формы (алюминий)'),
('0500', 'Пресс-формы (алюминий)'),
('19-022', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('0543-4120', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('19-023', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('19-020', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('0543-4121', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('19-021', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('0543-4129', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('0543-4124', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('0543-4123', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('0543-4122', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('21-037', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('21-039', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('21-038', 'Пресс-формы на GEFEST 6.0 / 6.1'),
('РО', 'Приспособления'),
('1199', 'Приспособления'),
('8450', 'Приспособления');

drop view locksmith_operations_view;

create view locksmith_operations_view as
    select
        o.order_id,
        o.order_date,
        o.oboz_to,
        tc.category_name,
       e.full_name as locksmith_name,
       c.customer_title,
       sum(mc.quantity * o.qty * t.time_norm) as time_norm
from material_cards mc
         inner join orders o on o.order_id = mc.order_number
         left join tooling_categories tc on o.oboz_to like tc.category_template || '%'
         left join employees e on o.locksmith_id = e.personnel_number
         left join customers c on c.customer_id = o.customer_id
         inner join technologies t
                    on (mc.order_number = t.order_id and mc.detail_number = t.detail_number)
where t.operation = 'Сл.'
group by o.order_id, o.order_date, o.oboz_to, e.full_name, tc.category_name, c.customer_title;
