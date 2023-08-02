INSERT INTO groups(group_id, group_name, parent_id)
VALUES (0, 'Общая', null);

INSERT INTO groups(group_id, group_name, parent_id)
VALUES (1, 'Оргтехника', 0);

    INSERT INTO groups(group_id, group_name, parent_id)
    VALUES (2, 'Принтер', 1);

        INSERT INTO groups(group_id, group_name, parent_id)
        VALUES (12, 'Kyocera Ecosys', 2);

        INSERT INTO groups(group_id, group_name, parent_id)
        VALUES (13, 'Canon i-Sensys', 2);

    INSERT INTO groups(group_id, group_name, parent_id)
    VALUES (3, 'МФУ', 1);

    INSERT INTO groups(group_id, group_name, parent_id)
    VALUES (4, 'Плоттер', 1);

INSERT INTO groups(group_id, group_name, parent_id)
VALUES (5, 'Весы', 0);

INSERT INTO groups(group_id, group_name, parent_id)
VALUES (6, 'Мониторы', 0);

INSERT INTO groups(group_id, group_name, parent_id)
VALUES (7, 'Компоненты', 0);

    INSERT INTO groups(group_id, group_name, parent_id)
    VALUES (8, 'Электроника', 7);

    INSERT INTO groups(group_id, group_name, parent_id)
    VALUES (9, 'Электрика', 7);

    INSERT INTO groups(group_id, group_name, parent_id)
    VALUES (10, 'Механика', 7);

    INSERT INTO groups(group_id, group_name, parent_id)
    VALUES (11, 'Составной', 7);
