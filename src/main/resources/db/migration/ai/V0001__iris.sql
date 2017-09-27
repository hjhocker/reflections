drop table if exists iris;
drop type if exists species_enum;

create type species_enum as enum ('setosa', 'versicolor', 'virginica');

create table iris (
  id bigserial,
  sepal_length numeric,
  sepal_width numeric,
  petal_length numeric,
  petal_width numeric,
  species species_enum
);

insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (1, 5.1, 3.5, 1.4, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (2, 4.9, 3, 1.4, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (3, 4.7, 3.2, 1.3, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (4, 4.6, 3.1, 1.5, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (5, 5, 3.6, 1.4, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (6, 5.4, 3.9, 1.7, 0.4, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (7, 4.6, 3.4, 1.4, 0.3, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (8, 5, 3.4, 1.5, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (9, 4.4, 2.9, 1.4, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (10, 4.9, 3.1, 1.5, 0.1, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (11, 5.4, 3.7, 1.5, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (12, 4.8, 3.4, 1.6, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (13, 4.8, 3, 1.4, 0.1, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (14, 4.3, 3, 1.1, 0.1, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (15, 5.8, 4, 1.2, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (16, 5.7, 4.4, 1.5, 0.4, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (17, 5.4, 3.9, 1.3, 0.4, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (18, 5.1, 3.5, 1.4, 0.3, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (19, 5.7, 3.8, 1.7, 0.3, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (20, 5.1, 3.8, 1.5, 0.3, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (21, 5.4, 3.4, 1.7, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (22, 5.1, 3.7, 1.5, 0.4, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (23, 4.6, 3.6, 1, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (24, 5.1, 3.3, 1.7, 0.5, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (25, 4.8, 3.4, 1.9, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (26, 5, 3, 1.6, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (27, 5, 3.4, 1.6, 0.4, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (28, 5.2, 3.5, 1.5, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (29, 5.2, 3.4, 1.4, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (30, 4.7, 3.2, 1.6, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (31, 4.8, 3.1, 1.6, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (32, 5.4, 3.4, 1.5, 0.4, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (33, 5.2, 4.1, 1.5, 0.1, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (34, 5.5, 4.2, 1.4, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (35, 4.9, 3.1, 1.5, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (36, 5, 3.2, 1.2, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (37, 5.5, 3.5, 1.3, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (38, 4.9, 3.6, 1.4, 0.1, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (39, 4.4, 3, 1.3, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (40, 5.1, 3.4, 1.5, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (41, 5, 3.5, 1.3, 0.3, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (42, 4.5, 2.3, 1.3, 0.3, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (43, 4.4, 3.2, 1.3, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (44, 5, 3.5, 1.6, 0.6, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (45, 5.1, 3.8, 1.9, 0.4, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (46, 4.8, 3, 1.4, 0.3, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (47, 5.1, 3.8, 1.6, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (48, 4.6, 3.2, 1.4, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (49, 5.3, 3.7, 1.5, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (50, 5, 3.3, 1.4, 0.2, 'setosa');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (51, 7, 3.2, 4.7, 1.4, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (52, 6.4, 3.2, 4.5, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (53, 6.9, 3.1, 4.9, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (54, 5.5, 2.3, 4, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (55, 6.5, 2.8, 4.6, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (56, 5.7, 2.8, 4.5, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (57, 6.3, 3.3, 4.7, 1.6, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (58, 4.9, 2.4, 3.3, 1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (59, 6.6, 2.9, 4.6, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (60, 5.2, 2.7, 3.9, 1.4, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (61, 5, 2, 3.5, 1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (62, 5.9, 3, 4.2, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (63, 6, 2.2, 4, 1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (64, 6.1, 2.9, 4.7, 1.4, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (65, 5.6, 2.9, 3.6, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (66, 6.7, 3.1, 4.4, 1.4, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (67, 5.6, 3, 4.5, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (68, 5.8, 2.7, 4.1, 1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (69, 6.2, 2.2, 4.5, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (70, 5.6, 2.5, 3.9, 1.1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (71, 5.9, 3.2, 4.8, 1.8, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (72, 6.1, 2.8, 4, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (73, 6.3, 2.5, 4.9, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (74, 6.1, 2.8, 4.7, 1.2, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (75, 6.4, 2.9, 4.3, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (76, 6.6, 3, 4.4, 1.4, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (77, 6.8, 2.8, 4.8, 1.4, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (78, 6.7, 3, 5, 1.7, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (79, 6, 2.9, 4.5, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (80, 5.7, 2.6, 3.5, 1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (81, 5.5, 2.4, 3.8, 1.1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (82, 5.5, 2.4, 3.7, 1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (83, 5.8, 2.7, 3.9, 1.2, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (84, 6, 2.7, 5.1, 1.6, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (85, 5.4, 3, 4.5, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (86, 6, 3.4, 4.5, 1.6, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (87, 6.7, 3.1, 4.7, 1.5, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (88, 6.3, 2.3, 4.4, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (89, 5.6, 3, 4.1, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (90, 5.5, 2.5, 4, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (91, 5.5, 2.6, 4.4, 1.2, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (92, 6.1, 3, 4.6, 1.4, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (93, 5.8, 2.6, 4, 1.2, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (94, 5, 2.3, 3.3, 1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (95, 5.6, 2.7, 4.2, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (96, 5.7, 3, 4.2, 1.2, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (97, 5.7, 2.9, 4.2, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (98, 6.2, 2.9, 4.3, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (99, 5.1, 2.5, 3, 1.1, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (100, 5.7, 2.8, 4.1, 1.3, 'versicolor');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (101, 6.3, 3.3, 6, 2.5, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (102, 5.8, 2.7, 5.1, 1.9, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (103, 7.1, 3, 5.9, 2.1, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (104, 6.3, 2.9, 5.6, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (105, 6.5, 3, 5.8, 2.2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (106, 7.6, 3, 6.6, 2.1, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (107, 4.9, 2.5, 4.5, 1.7, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (108, 7.3, 2.9, 6.3, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (109, 6.7, 2.5, 5.8, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (110, 7.2, 3.6, 6.1, 2.5, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (111, 6.5, 3.2, 5.1, 2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (112, 6.4, 2.7, 5.3, 1.9, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (113, 6.8, 3, 5.5, 2.1, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (114, 5.7, 2.5, 5, 2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (115, 5.8, 2.8, 5.1, 2.4, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (116, 6.4, 3.2, 5.3, 2.3, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (117, 6.5, 3, 5.5, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (118, 7.7, 3.8, 6.7, 2.2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (119, 7.7, 2.6, 6.9, 2.3, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (120, 6, 2.2, 5, 1.5, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (121, 6.9, 3.2, 5.7, 2.3, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (122, 5.6, 2.8, 4.9, 2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (123, 7.7, 2.8, 6.7, 2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (124, 6.3, 2.7, 4.9, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (125, 6.7, 3.3, 5.7, 2.1, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (126, 7.2, 3.2, 6, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (127, 6.2, 2.8, 4.8, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (128, 6.1, 3, 4.9, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (129, 6.4, 2.8, 5.6, 2.1, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (130, 7.2, 3, 5.8, 1.6, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (131, 7.4, 2.8, 6.1, 1.9, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (132, 7.9, 3.8, 6.4, 2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (133, 6.4, 2.8, 5.6, 2.2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (134, 6.3, 2.8, 5.1, 1.5, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (135, 6.1, 2.6, 5.6, 1.4, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (136, 7.7, 3, 6.1, 2.3, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (137, 6.3, 3.4, 5.6, 2.4, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (138, 6.4, 3.1, 5.5, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (139, 6, 3, 4.8, 1.8, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (140, 6.9, 3.1, 5.4, 2.1, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (141, 6.7, 3.1, 5.6, 2.4, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (142, 6.9, 3.1, 5.1, 2.3, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (143, 5.8, 2.7, 5.1, 1.9, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (144, 6.8, 3.2, 5.9, 2.3, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (145, 6.7, 3.3, 5.7, 2.5, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (146, 6.7, 3, 5.2, 2.3, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (147, 6.3, 2.5, 5, 1.9, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (148, 6.5, 3, 5.2, 2, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (149, 6.2, 3.4, 5.4, 2.3, 'virginica');
insert into iris (id, sepal_length, sepal_width, petal_length, petal_width, species) values (150, 5.9, 3, 5.1, 1.8, 'virginica');