create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM
    collate = utf8_unicode_ci;

INSERT INTO testingdata.hibernate_sequence (next_val) VALUES (15);
INSERT INTO testingdata.hibernate_sequence (next_val) VALUES (15);
INSERT INTO testingdata.hibernate_sequence (next_val) VALUES (15);
INSERT INTO testingdata.hibernate_sequence (next_val) VALUES (15);
INSERT INTO testingdata.hibernate_sequence (next_val) VALUES (15);
INSERT INTO testingdata.hibernate_sequence (next_val) VALUES (15);
INSERT INTO testingdata.hibernate_sequence (next_val) VALUES (15);