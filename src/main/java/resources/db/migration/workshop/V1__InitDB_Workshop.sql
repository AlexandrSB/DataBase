-- Table: public.model
-- DROP TABLE IF EXISTS public.model;
CREATE TABLE IF NOT EXISTS public.model
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT model_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.model
    OWNER to admin;


-- Table: public.equipment
-- DROP TABLE IF EXISTS public.equipment;
CREATE TABLE IF NOT EXISTS public.equipment
(
    id bigint NOT NULL,
    inventory_number character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    model_id bigint,
    CONSTRAINT equipment_pkey PRIMARY KEY (id),
    CONSTRAINT fkgfycjdthonudivh0bqj65ewcp FOREIGN KEY (model_id)
        REFERENCES public.model (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.equipment
    OWNER to admin;


-- Table: public.repair_notation
-- DROP TABLE IF EXISTS public.repair_notation;
CREATE TABLE IF NOT EXISTS public.repair_notation
(
    id bigint NOT NULL,
    notation character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT repair_notation_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.repair_notation
    OWNER to admin;


-- Table: public.model_repair_notation
-- DROP TABLE IF EXISTS public.model_repair_notation;
CREATE TABLE IF NOT EXISTS public.model_repair_notation
(
    repair_notation_id bigint NOT NULL,
    model_id bigint NOT NULL,
    CONSTRAINT model_repair_notation_pkey PRIMARY KEY (repair_notation_id, model_id),
    CONSTRAINT fk5jdtn8n8wcmkg79ifdxwpeeic FOREIGN KEY (model_id)
        REFERENCES public.model (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fknwi1g6umyesayxxpwp63nywqc FOREIGN KEY (repair_notation_id)
        REFERENCES public.repair_notation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.model_repair_notation
    OWNER to admin;


-- Table: public.repair
-- DROP TABLE IF EXISTS public.repair;
CREATE TABLE IF NOT EXISTS public.repair
(
    id bigint NOT NULL,
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
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT spares_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.spares
    OWNER to admin;


-- Table: public.number_of_spares_parts
-- DROP TABLE IF EXISTS public.number_of_spares_parts;
CREATE TABLE IF NOT EXISTS public.number_of_spares_parts
(
    id bigint NOT NULL,
    counter integer,
    repairs_id bigint,
    spares_id bigint,
    CONSTRAINT number_of_spares_parts_pkey PRIMARY KEY (id),
    CONSTRAINT fk81lyrqsvscnm7cp56nloo5t7m FOREIGN KEY (repairs_id)
        REFERENCES public.repair (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkqg9io40nu7rxmrbpdg4w36sgr FOREIGN KEY (spares_id)
        REFERENCES public.spares (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.number_of_spares_parts
    OWNER to admin;


-- Table: public.repair_repair_notation
-- DROP TABLE IF EXISTS public.repair_repair_notation;
CREATE TABLE IF NOT EXISTS public.repair_repair_notation
(
    repair_notation_id bigint NOT NULL,
    repair_id bigint NOT NULL,
    CONSTRAINT repair_repair_notation_pkey PRIMARY KEY (repair_notation_id, repair_id),
    CONSTRAINT fk86qtkxa9hdah5hurqi0172ed2 FOREIGN KEY (repair_id)
        REFERENCES public.repair (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkcmfvbcoxq06we4e3mrgns07xy FOREIGN KEY (repair_notation_id)
        REFERENCES public.repair_notation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.repair_repair_notation
    OWNER to admin;




-- SEQUENCE: public.repair_notation_seq
-- DROP SEQUENCE IF EXISTS public.repair_notation_seq;
CREATE SEQUENCE IF NOT EXISTS public.repair_notation_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.repair_notation_seq
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