/*
INSERT INTO item_types
(type_name, charge_by, unit_price, valid_from, valid_until)
VALUES('block', 'unit', 0, to_date('01.01.2022','dd.mm.yyyy'), to_date('01.01.2100','dd.mm.yyyy'));

INSERT INTO item_types
(type_name, charge_by, unit_price, valid_from, valid_until)
VALUES('scara', 'unit', 0, to_date('01.01.2022','dd.mm.yyyy'), to_date('01.01.2100','dd.mm.yyyy'));

INSERT INTO item_types
(type_name, charge_by, unit_price, valid_from, valid_until)
VALUES('etaj', 'unit', 0, to_date('01.01.2022','dd.mm.yyyy'), to_date('01.01.2100','dd.mm.yyyy'));

INSERT INTO item_types
(type_name, charge_by, unit_price, valid_from, valid_until)
VALUES('apartament', 'metriPatrati', 2.21, to_date('01.01.2022','dd.mm.yyyy'), to_date('01.01.2100','dd.mm.yyyy'));

INSERT INTO item_types
(type_name, charge_by, unit_price, valid_from, valid_until)
VALUES('debara', 'unit', 70, to_date('01.01.2022','dd.mm.yyyy'), to_date('01.01.2100','dd.mm.yyyy'));

INSERT INTO item_types
(type_name, charge_by, unit_price, valid_from, valid_until)
VALUES('parcare', 'unit', 50, to_date('01.01.2022','dd.mm.yyyy'), to_date('01.01.2100','dd.mm.yyyy'));



INSERT INTO items
(item_type, is_billable, item_props,label)
VALUES('block', 'N'::bpchar, '{"unit":"1"}','Bucuria10');
*/