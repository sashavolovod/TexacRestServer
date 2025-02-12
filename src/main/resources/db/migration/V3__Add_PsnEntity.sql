create table psn_entity (
    psn_entity_id bigserial not null primary key,
    doc_number character varying(255),
    doc_date timestamp without time zone,
    order_id integer not null,
    order_number character varying(255),
    order_description character varying(255),
    customer character varying(255),
    qty integer not null,
    unit_name character varying(255),
    computer_name character varying(255)
) inherits (base_table);
