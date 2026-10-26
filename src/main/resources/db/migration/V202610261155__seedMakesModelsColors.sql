-- =========================================================
-- MAKES
-- =========================================================

INSERT INTO make (id, name)
VALUES (1, 'Audi'),
       (2, 'BMW'),
       (3, 'Mercedes-Benz'),
       (4, 'Volkswagen'),
       (5, 'Porsche'),
       (6, 'Opel'),
       (7, 'Ford'),
       (8, 'Toyota'),
       (9, 'Honda'),
       (10, 'Mazda'),
       (11, 'Hyundai'),
       (12, 'Kia'),
       (13, 'Volvo'),
       (14, 'Skoda'),
       (15, 'SEAT'),
       (16, 'Renault'),
       (17, 'Peugeot'),
       (18, 'Citroën'),
       (19, 'Škoda'),
       (20, 'Tesla'),
       (21, 'Nissan'),
       (22, 'Land Rover'),
       (23, 'Jaguar'),
       (24, 'Fiat'),
       (25, 'Dacia'),
       (26, 'MINI'),
       (27, 'Lexus'),
       (28, 'Mitsubishi'),
       (29, 'Subaru'),
       (30, 'Suzuki');

-- =========================================================
-- MODELS
-- make_id references make.id
-- =========================================================

INSERT INTO model (id, make_id, name)
VALUES
    -- Audi
    (1, 1, 'A1'),
    (2, 1, 'A3'),
    (3, 1, 'A4'),
    (4, 1, 'A5'),
    (5, 1, 'A6'),
    (6, 1, 'A7'),
    (7, 1, 'A8'),
    (8, 1, 'Q3'),
    (9, 1, 'Q5'),
    (10, 1, 'Q7'),
    (11, 1, 'Q8'),
    (12, 1, 'e-tron'),

    -- BMW
    (13, 2, '1 Series'),
    (14, 2, '2 Series'),
    (15, 2, '3 Series'),
    (16, 2, '4 Series'),
    (17, 2, '5 Series'),
    (18, 2, '6 Series'),
    (19, 2, '7 Series'),
    (20, 2, '8 Series'),
    (21, 2, 'X1'),
    (22, 2, 'X3'),
    (23, 2, 'X5'),
    (24, 2, 'X6'),
    (25, 2, 'X7'),
    (26, 2, 'i3'),
    (27, 2, 'i4'),
    (28, 2, 'iX'),

    -- Mercedes-Benz
    (29, 3, 'A-Class'),
    (30, 3, 'B-Class'),
    (31, 3, 'C-Class'),
    (32, 3, 'E-Class'),
    (33, 3, 'S-Class'),
    (34, 3, 'CLA'),
    (35, 3, 'CLS'),
    (36, 3, 'GLA'),
    (37, 3, 'GLB'),
    (38, 3, 'GLC'),
    (39, 3, 'GLE'),
    (40, 3, 'GLS'),
    (41, 3, 'EQS'),
    (42, 3, 'EQE'),

    -- Volkswagen
    (43, 4, 'Polo'),
    (44, 4, 'Golf'),
    (45, 4, 'Passat'),
    (46, 4, 'Arteon'),
    (47, 4, 'T-Cross'),
    (48, 4, 'T-Roc'),
    (49, 4, 'Tiguan'),
    (50, 4, 'Touareg'),
    (51, 4, 'Touran'),
    (52, 4, 'ID.3'),
    (53, 4, 'ID.4'),
    (54, 4, 'ID.5'),

    -- Porsche
    (55, 5, '911'),
    (56, 5, '718 Cayman'),
    (57, 5, '718 Boxster'),
    (58, 5, 'Panamera'),
    (59, 5, 'Macan'),
    (60, 5, 'Cayenne'),
    (61, 5, 'Taycan'),

    -- Opel
    (62, 6, 'Corsa'),
    (63, 6, 'Astra'),
    (64, 6, 'Insignia'),
    (65, 6, 'Mokka'),
    (66, 6, 'Grandland'),
    (67, 6, 'Crossland'),

    -- Ford
    (68, 7, 'Fiesta'),
    (69, 7, 'Focus'),
    (70, 7, 'Mondeo'),
    (71, 7, 'Puma'),
    (72, 7, 'Kuga'),
    (73, 7, 'Explorer'),
    (74, 7, 'Mustang'),
    (75, 7, 'Mustang Mach-E'),

    -- Toyota
    (76, 8, 'Yaris'),
    (77, 8, 'Corolla'),
    (78, 8, 'Camry'),
    (79, 8, 'Prius'),
    (80, 8, 'C-HR'),
    (81, 8, 'RAV4'),
    (82, 8, 'Land Cruiser'),
    (83, 8, 'bZ4X'),

    -- Honda
    (84, 9, 'Civic'),
    (85, 9, 'Jazz'),
    (86, 9, 'HR-V'),
    (87, 9, 'CR-V'),
    (88, 9, 'ZR-V'),

    -- Mazda
    (89, 10, 'Mazda2'),
    (90, 10, 'Mazda3'),
    (91, 10, 'Mazda6'),
    (92, 10, 'CX-3'),
    (93, 10, 'CX-30'),
    (94, 10, 'CX-5'),
    (95, 10, 'CX-60'),

    -- Hyundai
    (96, 11, 'i10'),
    (97, 11, 'i20'),
    (98, 11, 'i30'),
    (99, 11, 'Tucson'),
    (100, 11, 'Santa Fe'),
    (101, 11, 'Kona'),
    (102, 11, 'IONIQ 5'),
    (103, 11, 'IONIQ 6'),

    -- Kia
    (104, 12, 'Picanto'),
    (105, 12, 'Ceed'),
    (106, 12, 'Sportage'),
    (107, 12, 'Sorento'),
    (108, 12, 'Niro'),
    (109, 12, 'EV6'),
    (110, 12, 'EV9'),

    -- Volvo
    (111, 13, 'S60'),
    (112, 13, 'S90'),
    (113, 13, 'V60'),
    (114, 13, 'V90'),
    (115, 13, 'XC40'),
    (116, 13, 'XC60'),
    (117, 13, 'XC90'),

    -- Skoda
    (118, 14, 'Fabia'),
    (119, 14, 'Scala'),
    (120, 14, 'Octavia'),
    (121, 14, 'Superb'),
    (122, 14, 'Kamiq'),
    (123, 14, 'Karoq'),
    (124, 14, 'Kodiaq'),
    (125, 14, 'Enyaq'),

    -- SEAT
    (126, 15, 'Ibiza'),
    (127, 15, 'Leon'),
    (128, 15, 'Arona'),
    (129, 15, 'Ateca'),
    (130, 15, 'Tarraco'),

    -- Renault
    (131, 16, 'Clio'),
    (132, 16, 'Megane'),
    (133, 16, 'Captur'),
    (134, 16, 'Austral'),
    (135, 16, 'Arkana'),
    (136, 16, 'Zoe'),

    -- Peugeot
    (137, 17, '208'),
    (138, 17, '308'),
    (139, 17, '408'),
    (140, 17, '508'),
    (141, 17, '2008'),
    (142, 17, '3008'),
    (143, 17, '5008'),

    -- Citroën
    (144, 18, 'C3'),
    (145, 18, 'C4'),
    (146, 18, 'C5 X'),
    (147, 18, 'C3 Aircross'),
    (148, 18, 'C5 Aircross'),

    -- Škoda alias entry is intentionally omitted here:
    -- "Skoda" already represents the brand at make ID 14.

    -- Tesla
    (149, 20, 'Model 3'),
    (150, 20, 'Model S'),
    (151, 20, 'Model X'),
    (152, 20, 'Model Y'),

    -- Nissan
    (153, 21, 'Micra'),
    (154, 21, 'Juke'),
    (155, 21, 'Qashqai'),
    (156, 21, 'X-Trail'),
    (157, 21, 'Leaf'),
    (158, 21, 'Ariya'),

    -- Land Rover
    (159, 22, 'Defender'),
    (160, 22, 'Discovery'),
    (161, 22, 'Discovery Sport'),
    (162, 22, 'Range Rover'),
    (163, 22, 'Range Rover Sport'),
    (164, 22, 'Range Rover Evoque'),
    (165, 22, 'Range Rover Velar'),

    -- Jaguar
    (166, 23, 'XE'),
    (167, 23, 'XF'),
    (168, 23, 'F-PACE'),
    (169, 23, 'E-PACE'),
    (170, 23, 'I-PACE'),

    -- Fiat
    (171, 24, '500'),
    (172, 24, 'Panda'),
    (173, 24, 'Tipo'),
    (174, 24, '500e'),

    -- Dacia
    (175, 25, 'Sandero'),
    (176, 25, 'Logan'),
    (177, 25, 'Duster'),
    (178, 25, 'Jogger'),
    (179, 25, 'Spring'),

    -- MINI
    (180, 26, 'Cooper'),
    (181, 26, 'Countryman'),
    (182, 26, 'Clubman'),

    -- Lexus
    (183, 27, 'IS'),
    (184, 27, 'ES'),
    (185, 27, 'NX'),
    (186, 27, 'RX'),
    (187, 27, 'UX'),
    (188, 27, 'RZ'),

    -- Mitsubishi
    (189, 28, 'Space Star'),
    (190, 28, 'ASX'),
    (191, 28, 'Eclipse Cross'),
    (192, 28, 'Outlander'),

    -- Subaru
    (193, 29, 'Impreza'),
    (194, 29, 'XV'),
    (195, 29, 'Forester'),
    (196, 29, 'Outback'),
    (197, 29, 'Solterra'),

    -- Suzuki
    (198, 30, 'Swift'),
    (199, 30, 'Vitara'),
    (200, 30, 'S-Cross'),
    (201, 30, 'Jimny');

-- =========================================================
-- COLORS
-- =========================================================

INSERT INTO color (id, name)
VALUES (1, 'Black'),
       (2, 'White'),
       (3, 'Silver'),
       (4, 'Grey'),
       (5, 'Dark Grey'),
       (6, 'Blue'),
       (7, 'Dark Blue'),
       (8, 'Light Blue'),
       (9, 'Red'),
       (10, 'Dark Red'),
       (11, 'Green'),
       (12, 'Dark Green'),
       (13, 'Brown'),
       (14, 'Beige'),
       (15, 'Gold'),
       (16, 'Yellow'),
       (17, 'Orange'),
       (18, 'Purple'),
       (19, 'Bronze'),
       (20, 'Other');
