-- Table: public.contragent

-- DROP TABLE IF EXISTS public.contragent;

CREATE TABLE IF NOT EXISTS public.contragent
(
    id bigint NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT contragent_pkey PRIMARY KEY (id)
);

-- Table: public.equipment

-- DROP TABLE IF EXISTS public.equipment;

CREATE TABLE IF NOT EXISTS public.equipment
(
    id bigint NOT NULL,
    inventory_number character varying(15) COLLATE pg_catalog."default",
    CONSTRAINT equipment_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.condition
(
    id bigint NOT NULL,
    name character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT condition_pkey PRIMARY KEY (id)
);

-- Table: public.good

-- DROP TABLE IF EXISTS public.good;

CREATE TABLE IF NOT EXISTS public.good
(
    id bigint NOT NULL,
    name character varying(50) COLLATE pg_catalog."default",
    proxy_id bigint NULL,
    external_equip_id bigint NOT NULL,
    condition_id bigint NOT NULL,
    CONSTRAINT good_pkey PRIMARY KEY (id),
    CONSTRAINT FK_condition_good FOREIGN KEY ( condition_id)
        REFERENCES "public".condition ( id ) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table: public.good_equip

-- DROP TABLE IF EXISTS public.good_equip;

CREATE TABLE IF NOT EXISTS public.good_equip
(
    equipment_id bigint,
    good_id bigint NOT NULL,
    CONSTRAINT good_equip_pkey PRIMARY KEY (good_id),
    CONSTRAINT uk_e1wljic2wnfdjk740gsupj5xa UNIQUE (equipment_id),
    CONSTRAINT fk6d47h4u69brjwaqpc6r3bes37 FOREIGN KEY (good_id)
        REFERENCES public.good (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkfv8mtvlykh7mba3luni11y7ok FOREIGN KEY (equipment_id)
        REFERENCES public.equipment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table: public.goods_tracking_date

-- DROP TABLE IF EXISTS public.goods_tracking_date;

CREATE TABLE IF NOT EXISTS public.goods_tracking_date
(
    id bigint NOT NULL,
    created_on timestamp(6) with time zone,
    CONSTRAINT goods_tracking_date_pkey PRIMARY KEY (id)
);

-- Table: public.storage

-- DROP TABLE IF EXISTS public.storage;

CREATE TABLE IF NOT EXISTS public.storage
(
    id bigint NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT storage_pkey PRIMARY KEY (id)
);

-- Table: public.workshop
-- DROP TABLE IF EXISTS public.workshop;

CREATE TABLE IF NOT EXISTS public.workshop
(
    id bigint NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(50) COLLATE pg_catalog."default",
    notice character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT workshop_pkey PRIMARY KEY (id)
);

-- Table: public.goods_tracking_from_contragent
-- DROP TABLE IF EXISTS public.goods_tracking_from_contragent;

CREATE TABLE IF NOT EXISTS public.goods_tracking_from_contragent
(
    id bigint NOT NULL,
    type_of_goods_movement character varying(50) COLLATE pg_catalog."default",
    contragent_id bigint,
    goods_tracking_date_id bigint,
    storage_id bigint,
    CONSTRAINT goods_tracking_from_contragent_pkey PRIMARY KEY (id),
    CONSTRAINT fk1nrqu2ldyl6woultao81w71rn FOREIGN KEY (storage_id)
        REFERENCES public.storage (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk6xeqr62ikb88wrbxiywf9cxg5 FOREIGN KEY (contragent_id)
        REFERENCES public.contragent (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkrjhsoxbxlc6frvg4no4pikvoa FOREIGN KEY (goods_tracking_date_id)
        REFERENCES public.goods_tracking_date (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT goods_tracking_from_contragent_type_of_goods_movement_check
        CHECK (type_of_goods_movement::text = ANY (ARRAY['ARRIVAL'::character varying, 'EXPENSE'::character varying]::text[]))
);

-- Table: public.goods_tracking_from_storage

-- DROP TABLE IF EXISTS public.goods_tracking_from_storage;

CREATE TABLE IF NOT EXISTS public.goods_tracking_from_storage
(
    id bigint NOT NULL,
    type_of_goods_movement character varying(50) COLLATE pg_catalog."default",
    goods_tracking_date_id bigint,
    storage_id bigint,
    workshop_id bigint,
    CONSTRAINT goods_tracking_from_storage_pkey PRIMARY KEY (id),
    CONSTRAINT fk6rjg6huhr90h3sfto7yr25i8n FOREIGN KEY (goods_tracking_date_id)
        REFERENCES public.goods_tracking_date (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkd1ttbvemfw3oe0t89o5e3ofnu FOREIGN KEY (workshop_id)
        REFERENCES public.workshop (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkg3p284y64j9n89f51wg4146w2 FOREIGN KEY (storage_id)
        REFERENCES public.storage (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT goods_tracking_from_storage_type_of_goods_movement_check
        CHECK (type_of_goods_movement::text = ANY (ARRAY['ARRIVAL'::character varying, 'EXPENSE'::character varying]::text[]))
);

-- Table: public.quantity_account

-- DROP TABLE IF EXISTS public.quantity_account;

CREATE TABLE IF NOT EXISTS public.quantity_account
(
    id bigint NOT NULL,
    quantity integer,
    CONSTRAINT quantity_account_pkey PRIMARY KEY (id)
);

-- Table: public.party

-- DROP TABLE IF EXISTS public.party;

CREATE TABLE IF NOT EXISTS public.party
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    goods_tracking_from_contragent_id bigint,
    goods_tracking_from_storage_id bigint,
    quantity_id bigint,
    CONSTRAINT party_pkey PRIMARY KEY (id),
    CONSTRAINT fkojaxlphr18snidg9m2aaxsxik FOREIGN KEY (quantity_id)
        REFERENCES public.quantity_account (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkabvi5brfdm2koepxnj96ppm4u FOREIGN KEY (goods_tracking_from_storage_id)
        REFERENCES public.goods_tracking_from_storage (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fks80bbx2j7wvegopgixw5sp37n FOREIGN KEY (goods_tracking_from_contragent_id)
        REFERENCES public.goods_tracking_from_contragent (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table: public.good_party_from_contragent

-- DROP TABLE IF EXISTS public.good_party_from_contragent;

CREATE TABLE IF NOT EXISTS public.goods_party
(
    good_id bigint NOT NULL,
    party_id bigint NOT NULL,
    CONSTRAINT good_party_from_contragent_pkey PRIMARY KEY (good_id, party_id),
    CONSTRAINT fk5fkus1m8whmmflxnt6y5emi5a FOREIGN KEY (party_id)
        REFERENCES public.party (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkiqbiuaqvapdabsorcosvpes9f FOREIGN KEY (good_id)
        REFERENCES public.good (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


-- Table: public.quantity

-- DROP TABLE IF EXISTS public.quantity;

CREATE TABLE IF NOT EXISTS public.quantity
(
    id bigint NOT NULL,
    dimension character varying(25) COLLATE pg_catalog."default",
    quantity_in_one integer,
    quantity_account_id bigint,
    CONSTRAINT quantity_pkey PRIMARY KEY (id),
    CONSTRAINT fk3rddwdsco18o8srt7ljybymyt FOREIGN KEY (quantity_account_id)
        REFERENCES public.quantity_account (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Constraint: fk6d47h4u69brjwaqpc6r3bes37

-- ALTER TABLE IF EXISTS public.good_equip DROP CONSTRAINT IF EXISTS fk6d47h4u69brjwaqpc6r3bes37;

--ALTER TABLE IF EXISTS public.good_equip
--    ADD CONSTRAINT fk6d47h4u69brjwaqpc6r3bes37 FOREIGN KEY (good_id)
--    REFERENCES public.good (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkfv8mtvlykh7mba3luni11y7ok
--
---- ALTER TABLE IF EXISTS public.good_equip DROP CONSTRAINT IF EXISTS fkfv8mtvlykh7mba3luni11y7ok;
--
--ALTER TABLE IF EXISTS public.good_equip
--    ADD CONSTRAINT fkfv8mtvlykh7mba3luni11y7ok FOREIGN KEY (equipment_id)
--    REFERENCES public.equipment (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: uk_e1wljic2wnfdjk740gsupj5xa
--
---- ALTER TABLE IF EXISTS public.good_equip DROP CONSTRAINT IF EXISTS uk_e1wljic2wnfdjk740gsupj5xa;
--
--ALTER TABLE IF EXISTS public.good_equip
--    ADD CONSTRAINT uk_e1wljic2wnfdjk740gsupj5xa UNIQUE (equipment_id);
--
---- Constraint: fk1nrqu2ldyl6woultao81w71rn
--
---- ALTER TABLE IF EXISTS public.goods_tracking_from_contragent DROP CONSTRAINT IF EXISTS fk1nrqu2ldyl6woultao81w71rn;
--
--ALTER TABLE IF EXISTS public.goods_tracking_from_contragent
--    ADD CONSTRAINT fk1nrqu2ldyl6woultao81w71rn FOREIGN KEY (storage_id)
--    REFERENCES public.storage (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fk6xeqr62ikb88wrbxiywf9cxg5
--
---- ALTER TABLE IF EXISTS public.goods_tracking_from_contragent DROP CONSTRAINT IF EXISTS fk6xeqr62ikb88wrbxiywf9cxg5;
--
--ALTER TABLE IF EXISTS public.goods_tracking_from_contragent
--    ADD CONSTRAINT fk6xeqr62ikb88wrbxiywf9cxg5 FOREIGN KEY (contragent_id)
--    REFERENCES public.contragent (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkrjhsoxbxlc6frvg4no4pikvoa
--
---- ALTER TABLE IF EXISTS public.goods_tracking_from_contragent DROP CONSTRAINT IF EXISTS fkrjhsoxbxlc6frvg4no4pikvoa;
--
--ALTER TABLE IF EXISTS public.goods_tracking_from_contragent
--    ADD CONSTRAINT fkrjhsoxbxlc6frvg4no4pikvoa FOREIGN KEY (goods_tracking_date_id)
--    REFERENCES public.goods_tracking_date (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: goods_tracking_from_contragent_type_of_goods_movement_check
--
---- ALTER TABLE IF EXISTS public.goods_tracking_from_contragent DROP CONSTRAINT IF EXISTS goods_tracking_from_contragent_type_of_goods_movement_check;
--
--ALTER TABLE IF EXISTS public.goods_tracking_from_contragent
--    ADD CONSTRAINT goods_tracking_from_contragent_type_of_goods_movement_check
--    CHECK (type_of_goods_movement::text = ANY (ARRAY['ARRIVAL'::character varying, 'EXPENSE'::character varying]::text[]));
--
---- Constraint: fk6rjg6huhr90h3sfto7yr25i8n
--
---- ALTER TABLE IF EXISTS public.goods_tracking_from_storage DROP CONSTRAINT IF EXISTS fk6rjg6huhr90h3sfto7yr25i8n;
--
--ALTER TABLE IF EXISTS public.goods_tracking_from_storage
--    ADD CONSTRAINT fk6rjg6huhr90h3sfto7yr25i8n FOREIGN KEY (goods_tracking_date_id)
--    REFERENCES public.goods_tracking_date (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkd1ttbvemfw3oe0t89o5e3ofnu
--
---- ALTER TABLE IF EXISTS public.goods_tracking_from_storage DROP CONSTRAINT IF EXISTS fkd1ttbvemfw3oe0t89o5e3ofnu;
--
--ALTER TABLE IF EXISTS public.goods_tracking_from_storage
--    ADD CONSTRAINT fkd1ttbvemfw3oe0t89o5e3ofnu FOREIGN KEY (workshop_id)
--    REFERENCES public.workshop (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkg3p284y64j9n89f51wg4146w2
--
---- ALTER TABLE IF EXISTS public.goods_tracking_from_storage DROP CONSTRAINT IF EXISTS fkg3p284y64j9n89f51wg4146w2;
--
--ALTER TABLE IF EXISTS public.goods_tracking_from_storage
--    ADD CONSTRAINT fkg3p284y64j9n89f51wg4146w2 FOREIGN KEY (storage_id)
--    REFERENCES public.storage (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fk2xonxu7qjnq98exrsyh8s2chs
--
---- ALTER TABLE IF EXISTS public.party_from_contragent DROP CONSTRAINT IF EXISTS fk2xonxu7qjnq98exrsyh8s2chs;
--
--ALTER TABLE IF EXISTS public.party_from_contragent
--    ADD CONSTRAINT fk2xonxu7qjnq98exrsyh8s2chs FOREIGN KEY (quantity_account)
--    REFERENCES public.quantity_account (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkcmm8nkb2em4pjxnfg33iu8xxf
--
---- ALTER TABLE IF EXISTS public.party_from_contragent DROP CONSTRAINT IF EXISTS fkcmm8nkb2em4pjxnfg33iu8xxf;
--
--ALTER TABLE IF EXISTS public.party_from_contragent
--    ADD CONSTRAINT fkcmm8nkb2em4pjxnfg33iu8xxf FOREIGN KEY (id)
--    REFERENCES public.goods_tracking_from_contragent (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkno7sec1378smteqtgilfcjgnj
--
---- ALTER TABLE IF EXISTS public.party_from_contragent DROP CONSTRAINT IF EXISTS fkno7sec1378smteqtgilfcjgnj;
--
--ALTER TABLE IF EXISTS public.party_from_contragent
--    ADD CONSTRAINT fkno7sec1378smteqtgilfcjgnj FOREIGN KEY (good_id)
--    REFERENCES public.good (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkilxo49xq77yssgfnttkqhh9l5
--
---- ALTER TABLE IF EXISTS public.party_from_storage DROP CONSTRAINT IF EXISTS fkilxo49xq77yssgfnttkqhh9l5;
--
--ALTER TABLE IF EXISTS public.party_from_storage
--    ADD CONSTRAINT fkilxo49xq77yssgfnttkqhh9l5 FOREIGN KEY (good_id)
--    REFERENCES public.good (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkim5pwh35c0361xwhaqgoi1qok
--
---- ALTER TABLE IF EXISTS public.party_from_storage DROP CONSTRAINT IF EXISTS fkim5pwh35c0361xwhaqgoi1qok;
--
--ALTER TABLE IF EXISTS public.party_from_storage
--    ADD CONSTRAINT fkim5pwh35c0361xwhaqgoi1qok FOREIGN KEY (id)
--    REFERENCES public.goods_tracking_from_storage (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: fkmcwlkcag4tuk8npjkvkg63vfh
--
---- ALTER TABLE IF EXISTS public.party_from_storage DROP CONSTRAINT IF EXISTS fkmcwlkcag4tuk8npjkvkg63vfh;
--
--ALTER TABLE IF EXISTS public.party_from_storage
--    ADD CONSTRAINT fkmcwlkcag4tuk8npjkvkg63vfh FOREIGN KEY (quantity_account)
--    REFERENCES public.quantity_account (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;
--
---- Constraint: party_from_storage_type_of_goods_movement_check
--
---- ALTER TABLE IF EXISTS public.party_from_storage DROP CONSTRAINT IF EXISTS party_from_storage_type_of_goods_movement_check;
--
--ALTER TABLE IF EXISTS public.party_from_storage
--    ADD CONSTRAINT party_from_storage_type_of_goods_movement_check CHECK (type_of_goods_movement::text = ANY (ARRAY['ARRIVAL'::character varying, 'EXPENSE'::character varying]::text[]));
--
---- Constraint: fk3rddwdsco18o8srt7ljybymyt
--
---- ALTER TABLE IF EXISTS public.quantity DROP CONSTRAINT IF EXISTS fk3rddwdsco18o8srt7ljybymyt;
--
--ALTER TABLE IF EXISTS public.quantity
--    ADD CONSTRAINT fk3rddwdsco18o8srt7ljybymyt FOREIGN KEY (quantity_account_id)
--    REFERENCES public.quantity_account (id) MATCH SIMPLE
--    ON UPDATE NO ACTION
--    ON DELETE NO ACTION;




-- SEQUENCE: public.contragent_seq

-- DROP SEQUENCE IF EXISTS public.contragent_seq;

CREATE SEQUENCE IF NOT EXISTS public.contragent_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.contragent_seq
    OWNER TO admin;

-- SEQUENCE: public.good_seq

-- DROP SEQUENCE IF EXISTS public.good_seq;

CREATE SEQUENCE IF NOT EXISTS public.good_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.good_seq
    OWNER TO admin;


-- SEQUENCE: public.goods_tracking_from_contragent_seq

-- DROP SEQUENCE IF EXISTS public.goods_tracking_from_contragent_seq;

CREATE SEQUENCE IF NOT EXISTS public.goods_tracking_from_contragent_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.goods_tracking_from_contragent_seq
    OWNER TO admin;

-- SEQUENCE: public.goods_tracking_from_storage_seq

-- DROP SEQUENCE IF EXISTS public.goods_tracking_from_storage_seq;

CREATE SEQUENCE IF NOT EXISTS public.goods_tracking_from_storage_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.goods_tracking_from_storage_seq
    OWNER TO admin;


-- SEQUENCE: public.party_seq

-- DROP SEQUENCE IF EXISTS public.party_seq;

CREATE SEQUENCE IF NOT EXISTS public.party_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.party_seq
    OWNER TO admin;

-- SEQUENCE: public.storage_seq

-- DROP SEQUENCE IF EXISTS public.storage_seq;

CREATE SEQUENCE IF NOT EXISTS public.storage_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.storage_seq
    OWNER TO admin;

-- SEQUENCE: public.workshop_seq

-- DROP SEQUENCE IF EXISTS public.workshop_seq;

CREATE SEQUENCE IF NOT EXISTS public.workshop_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.workshop_seq
    OWNER TO admin;