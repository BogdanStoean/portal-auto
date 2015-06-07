INSERT INTO USERS (user_id, password, email, first_name, last_name, login_ip_address, created_date, active)
VALUES (3, '7c222fb2927d828af22f592134e8932480637c0d', 'admin@portal_auto.ro', 'admin', 'admin', '192.168.80.102', now(), true);
INSERT INTO USERS (user_id, password, email, first_name, last_name, login_ip_address, created_date, active)
VALUES (4, '7c222fb2927d828af22f592134e8932480637c0d', 'superuser@portal_auto.ro', 'Prosop', 'Titi', '192.168.80.25', now(), true);

insert into sensor (sensor_id, name, type,alert_message) VALUES (1,'ulei','Percentage','Trebuie sa adaugi apa de parbriz');
insert into sensor (sensor_id, name, type,alert_message) VALUES (2,'apa de parbriz','Percentage','Trebuie sa adaugi apa de parbriz');
insert into sensor (sensor_id, name, type,alert_message) VALUES (3,'antigel','Percentage','Atentie, adauga antigel');
insert into sensor (sensor_id, name, type,alert_message) VALUES (4,'placute frane','Status','Placutele de frane sunt pe duca');
insert into sensor (sensor_id, name, type,alert_message) VALUES (5,'disc frana','Status','Discurile de frane sunt pe duca');
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
VALUES (2, now(), now(), true, 'parse_384e83d526570a43',
        'Ford Fiesta', 3);

INSERT INTO car(
  car_id, created_date, last_modified_date, active, deviceuuid,
  name, user_id)
VALUES (3, now(), now(), true, '1126',
        'Ford KA', 3);

insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (1,1,2,'10');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (2,1,3,'30');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (3,1,4,'25');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (4,1,5,'30');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (5,1,6,'20');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (6,1,7,'30');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (7,1,8,'20');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (8,1,9,'ALERT');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (9,1,10,'ALERT');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (10,1,11,'ALERT');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (11,1,12,'ALERT');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (12,1,13,'ALERT');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (13,1,14,'ALERT');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (14,1,15,'ALERT');
insert into car_sensor_critical_value (car_sensor_critical_value_id,car_car_id,sensor_sensor_id,value)
VALUES (15,1,16,'150000');

insert into document (document_id, activation_date, expiration_date, name,user_id) VALUES (1,now(),now(),'vigneta',3);


ALTER SEQUENCE user_id_seq RESTART WITH 100;
ALTER SEQUENCE sensor_id_seq RESTART WITH 100;
ALTER SEQUENCE car_sensor_critical_value_seq RESTART WITH 100;
ALTER SEQUENCE car_id_seq RESTART WITH 100;
ALTER SEQUENCE car_history_id_seq RESTART WITH 100;
ALTER SEQUENCE DOCUMENT_id_seq RESTART WITH 100;
