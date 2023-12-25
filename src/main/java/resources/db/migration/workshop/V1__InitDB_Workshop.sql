-- Table: public.equipment
-- DROP TABLE IF EXISTS public.equipment;
CREATE TABLE IF NOT EXISTS public.equipment
(
    id bigint NOT NULL,
    CONSTRAINT equipment_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.equipment
    OWNER to admin;


-- Table: public.repair
-- DROP TABLE IF EXISTS public.repair;
CREATE TABLE IF NOT EXISTS public.repair
(
    id bigint NOT NULL,
    notation character varying(255) COLLATE pg_catalog."default",
    repair_type smallint,
    "timestamp" timestamp(6) without time zone,
    equipment_id bigint,
    CONSTRAINT repair_pkey PRIMARY KEY (id),
    CONSTRAINT fk8msyiq3s9v8tj5aniwer3kdcn FOREIGN KEY (equipment_id)
        REFERENCES public.equipment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT repair_repair_type_check CHECK (repair_type >= 0 AND repair_type <= 2)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.repair
    OWNER to admin;


-- Table: public.spares
-- DROP TABLE IF EXISTS public.spares;
CREATE TABLE IF NOT EXISTS public.spares
(
    id bigint NOT NULL,
    CONSTRAINT spares_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.spares
    OWNER to admin;


-- Table: public.repair_spares
-- DROP TABLE IF EXISTS public.repair_spares;
CREATE TABLE IF NOT EXISTS public.repair_spares
(
    repair_id bigint NOT NULL,
    spares_id bigint NOT NULL,
    CONSTRAINT repair_spares_pkey PRIMARY KEY (repair_id, spares_id),
    CONSTRAINT fk9xsa2wkwmc8csp33prsvoxew4 FOREIGN KEY (spares_id)
        REFERENCES public.spares (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkt7t9wovcbkrq6w28hwq3hlems FOREIGN KEY (repair_id)
        REFERENCES public.repair (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.repair_spares
    OWNER to admin;





-- SEQUENCE: public.equipment_seq
-- DROP SEQUENCE IF EXISTS public.equipment_seq;
CREATE SEQUENCE IF NOT EXISTS public.equipment_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.equipment_seq
    OWNER TO admin;


-- SEQUENCE: public.repair_seq
-- DROP SEQUENCE IF EXISTS public.repair_seq;
CREATE SEQUENCE IF NOT EXISTS public.repair_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.repair_seq
    OWNER TO admin;


-- SEQUENCE: public.spares_seq
-- DROP SEQUENCE IF EXISTS public.spares_seq;
CREATE SEQUENCE IF NOT EXISTS public.spares_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.spares_seq
    OWNER TO admin;