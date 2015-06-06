INSERT INTO USERS (user_id, password, email, first_name, last_name, login_ip_address, created_date, active)
VALUES (3, '7c222fb2927d828af22f592134e8932480637c0d', 'admin@portal_auto.ro', 'admin', 'admin', '192.168.80.102', now(), true);
INSERT INTO USERS (user_id, password, email, first_name, last_name, login_ip_address, created_date, active)
VALUES (4, '7c222fb2927d828af22f592134e8932480637c0d', 'superuser@portal_auto.ro', 'Prosop', 'Titi', '192.168.80.25', now(), true);

insert into sensor (sensor_id, name, type,alert_message) VALUES (2,'apa de parbriz','Percentage','Trebuie sa adaugi apa de parbriz');
insert into sensor (sensor_id, name, type,alert_message) VALUES (3,'antigel','Percentage','Atentie, adauga antigel');
insert into sensor (sensor_id, name, type,alert_message) VALUES (4,'placute frane','Percentage','Placutele de frane sunt pe duca');
insert into sensor (sensor_id, name, type,alert_message) VALUES (5,'disc frana','Percentage','Discurile de frane sunt pe duca');
insert into sensor (sensor_id, name, type,alert_message) VALUES (6,'carburant','Liters','Trebuie sa faci plinul in curand');
insert into sensor (sensor_id, name, type,alert_message) VALUES (7,'cauciucuri uzura','Percentage','Cauciucurile necesita inlocuire');
insert into sensor (sensor_id, name, type,alert_message) VALUES (8,'gradul de uzura la bateriei','Percentage','Bateria o sa te lase in curand');
insert into sensor (sensor_id, name, type,alert_message) VALUES (9,'abs','Status','ABS-ul are nevoie de verificare');
insert into sensor (sensor_id, name, type,alert_message) VALUES (10,'motor','Status','Motorul are nevoie de verificare');
insert into sensor (sensor_id, name, type,alert_message) VALUES (11,'servo directie','Status','Servo-directia are probleme');
insert into sensor (sensor_id, name, type,alert_message) VALUES (12,'senzori ploaie','Status','Senzorii de ploaie nu mai functioneaza');
insert into sensor (sensor_id, name, type,alert_message) VALUES (13,'pozitie','Status','Senzorii de positie au probleme');
insert into sensor (sensor_id, name, type,alert_message) VALUES (14,'faruri','Status','Senzorii de faruri au probleme');
insert into sensor (sensor_id, name, type,alert_message) VALUES (15,'parcare','Status','Senzorii de faruri au probleme');
insert into sensor (sensor_id, name, type,alert_message) VALUES (16,'KM','Number','Meh?!?');


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