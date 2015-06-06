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
