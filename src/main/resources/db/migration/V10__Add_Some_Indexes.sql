create index material_cards_order_number_detail_number_idx on material_cards(order_number, detail_number);
create index technologies_order_id_detail_number_idx on technologies(order_id, detail_number);
create index technologies_operation_idx on technologies(operation);
create index orders_id_oboz_to_idx on orders (order_id, oboz_to);
