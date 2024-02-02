INSERT INTO elements_group(id, name, parent_id)
VALUES (0, 'Общая', null);


INSERT INTO elements_group(id, name, parent_id)
VALUES (1, 'Оргтехника', 0);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (2, 'Принтеры и МФУ', 1);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (12, 'Kyocera Ecosys', 2);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (13, 'Canon i-Sensys', 2);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (4, 'Плоттер', 1);


INSERT INTO elements_group(id, name, parent_id)
VALUES (6, 'Компьютеры', 0);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (14, 'Мониторы', 6);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (15, '27"', 14);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (16, '24"', 14);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (17, '23"', 14);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (18, '22"', 14);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (19, '19"', 14);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (20, '17"', 14);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (21, '14"', 14);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (22, '10"', 14);


INSERT INTO elements_group(id, name, parent_id)
VALUES (7, 'Компоненты', 0);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (8, 'Электроника', 7);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (9, 'Электрика', 7);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (10, 'Механика', 7);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (11, 'Составной', 7);


INSERT INTO elements_group(id, name, parent_id)
VALUES (31, 'ИБП', 0);


INSERT INTO elements_group(id, name, parent_id)
VALUES (32, 'Торговое оборудование', 0);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (33, 'Запайщики', 32);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (34, 'Горячие столы', 32);

    INSERT INTO elements_group(id, name, parent_id)
    VALUES (5, 'Весы', 32);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (24, 'Mettler Toledo', 5);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (25, 'Macca-K', 5);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (26, 'Aclas', 5);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (27, 'DP Falcon', 5);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (28, 'Digi', 5);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (29, 'Cas', 5);

        INSERT INTO elements_group(id, name, parent_id)
        VALUES (30, 'Mertech', 5);
