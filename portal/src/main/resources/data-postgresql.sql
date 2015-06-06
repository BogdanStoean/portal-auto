INSERT INTO USERS (user_id, password, email, first_name, last_name, login_ip_address, created_date, active)
VALUES (3, '7c222fb2927d828af22f592134e8932480637c0d', 'admin@portal_auto.ro', 'admin', 'admin', '192.168.80.102', now(), true);
INSERT INTO USERS (user_id, password, email, first_name, last_name, login_ip_address, created_date, active)
VALUES (4, '7c222fb2927d828af22f592134e8932480637c0d', 'superuser@portal_auto.ro', 'Prosop', 'Titi', '192.168.80.25', now(), true);

insert into sensor (sensor_id, name, type) VALUES (1,'senzori','String');
insert into sensor (sensor_id, name, type) VALUES (2,'apa de parbriz','String');
insert into sensor (sensor_id, name, type) VALUES (3,'antigel','String');
insert into sensor (sensor_id, name, type) VALUES (4,'placute frane','String');
insert into sensor (sensor_id, name, type) VALUES (5,'disc frana','String');
insert into sensor (sensor_id, name, type) VALUES (6,'carburant','String');
insert into sensor (sensor_id, name, type) VALUES (7,'cauciucuri uzura','String');
insert into sensor (sensor_id, name, type) VALUES (8,'gradul de uzura la bateriei','String');


insert into sensor (sensor_id, name, type) VALUES (9,'abs','Status');
insert into sensor (sensor_id, name, type) VALUES (10,'motor','Status');
insert into sensor (sensor_id, name, type) VALUES (11,'servo directie','Status');
insert into sensor (sensor_id, name, type) VALUES (12,'senzori ploaie','Status');
insert into sensor (sensor_id, name, type) VALUES (13,'pozitie','Status');
insert into sensor (sensor_id, name, type) VALUES (14,'faruri','Status');
insert into sensor (sensor_id, name, type) VALUES (15,'parcare','Status');


insert into car(car_id,active, deviceuuid, name, user_id) VALUES (1,TRUE ,'384e83d526570a43' ,'lucian',3);

INSERT INTO car(
  car_id, created_date, last_modified_date, active, deviceuuid,
  name, user_id)
VALUES (2, now(), now(), true, '112',
        'Ford Fiesta', 3);

INSERT INTO car(
  car_id, created_date, last_modified_date, active, deviceuuid,
  name, user_id)
VALUES (3, now(), now(), true, '112',
        'Ford KA', 3);

ALTER SEQUENCE user_id_seq RESTART WITH 100;
ALTER SEQUENCE sensor_id_seq RESTART WITH 100;
ALTER SEQUENCE car_sensor_critical_value_seq RESTART WITH 100;
ALTER SEQUENCE car_id_seq RESTART WITH 100;
ALTER SEQUENCE car_history_id_seq RESTART WITH 100;