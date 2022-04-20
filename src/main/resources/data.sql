INSERT INTO country (id, name, continent) VALUES (1, 'Macedonia', 'Europe');
INSERT INTO country (id, name, continent) VALUES (2, 'Russia', 'Europe');

INSERT INTO author (id, name, surname, country_id) VALUES (1, 'Marko', 'Spasenovski', 1);
INSERT INTO author (id, name, surname, country_id) VALUES (2, 'Lav', 'Tolstoj', 2);

INSERT INTO book (id, name, category, author_id, available_copies) VALUES (1, 'Markos Book', 'NOVEL', 1, 4);
INSERT INTO book (id, name, category, author_id, available_copies) VALUES (2, 'Lavs Book', 'CLASSICS', 2, 5);