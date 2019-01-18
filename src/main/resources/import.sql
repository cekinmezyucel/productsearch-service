--brands
INSERT INTO brand VALUES (101, current_timestamp, 'SYSTEM', 0, 'Samsung');
INSERT INTO brand VALUES (102, current_timestamp, 'SYSTEM', 0, 'Apple');

--samsung models
INSERT INTO model VALUES (101, current_timestamp, 'SYSTEM', 0, 'Galaxy S7', 101);
INSERT INTO model VALUES (102, current_timestamp, 'SYSTEM', 0, 'Galaxy S8+', 101);
INSERT INTO model VALUES (103, current_timestamp, 'SYSTEM', 0, 'Galaxy S8', 101);
INSERT INTO model VALUES (104, current_timestamp, 'SYSTEM', 0, 'Galaxy S9', 101);
INSERT INTO model VALUES (105, current_timestamp, 'SYSTEM', 0, 'Galaxy S Plus I9001', 101);
INSERT INTO model VALUES (106, current_timestamp, 'SYSTEM', 0, 'Galaxy S Advance I9070', 101);
INSERT INTO model VALUES (107, current_timestamp, 'SYSTEM', 0, 'Galaxy S3 Slim', 101);

--apple models
INSERT INTO model VALUES (108, current_timestamp, 'SYSTEM', 0, 'iPhone 3G', 102);
INSERT INTO model VALUES (109, current_timestamp, 'SYSTEM', 0, 'iPhone 3GS', 102);
INSERT INTO model VALUES (110, current_timestamp, 'SYSTEM', 0, 'iPhone 4', 102);
INSERT INTO model VALUES (111, current_timestamp, 'SYSTEM', 0, 'iPhone 4S', 102);
INSERT INTO model VALUES (112, current_timestamp, 'SYSTEM', 0, 'iPhone 5', 102);
INSERT INTO model VALUES (113, current_timestamp, 'SYSTEM', 0, 'iPhone 5c', 102);
INSERT INTO model VALUES (114, current_timestamp, 'SYSTEM', 0, 'iPhone 5s', 102);
INSERT INTO model VALUES (115, current_timestamp, 'SYSTEM', 0, 'iPhone X', 102);

COMMIT;