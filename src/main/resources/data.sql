INSERT INTO country (id, name, continent) VALUES (1, 'Macedonia', 'Europe');
INSERT INTO country (id, name, continent) VALUES (2, 'Russia', 'Europe');

INSERT INTO author (id, name, surname, country_id) VALUES (1, 'Olivera', 'Nikolova', 1);
INSERT INTO author (id, name, surname, country_id) VALUES (2, 'Test', 'Author 1', 2);
INSERT INTO author (id, name, surname, country_id) VALUES (3, 'Test', 'Author 2', 2);

INSERT INTO book (id, name, category, author_id, available_copies) VALUES (1, 'Devojkite na Marko', 'DRAMA', 1, 4);
INSERT INTO book (id, name, category, author_id, available_copies) VALUES (2, 'Test Book 1', 'CLASSICS', 2, 5);
INSERT INTO book (id, name, category, author_id, available_copies) VALUES (3, 'Test Book 2', 'THRILLER', 3, 23);
INSERT INTO book (id, name, category, author_id, available_copies) VALUES (4, 'Test Book 3', 'HISTORY', 3, 54);
INSERT INTO book (id, name, category, author_id, available_copies) VALUES (5, 'Test Book 4', 'BIOGRAPHY', 2, 8);
INSERT INTO book (id, name, category, author_id, available_copies) VALUES (6, 'Test Book 5', 'NOVEL', 2, 6);
INSERT INTO book (id, name, category, author_id, available_copies) VALUES (7, 'Test Book 6', 'FANTASY', 2, 9);