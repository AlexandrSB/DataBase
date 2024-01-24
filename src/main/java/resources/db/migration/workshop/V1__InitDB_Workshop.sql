-- Table: public.completed_work
-- DROP TABLE IF EXISTS public.completed_work;
CREATE TABLE IF NOT EXISTS public.completed_work
(
    id bigint NOT NULL,
    notation character varying(255) COLLATE pg_catalog."default",
    consumption_of_materials_id bigint,
    repair_type character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT completed_work_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.completed_work
    OWNER to admin;


-- Table: public.consumption_of_materials
-- DROP TABLE IF EXISTS public.consumption_of_materials;
CREATE TABLE IF NOT EXISTS public.consumption_of_materials
(
    id bigint NOT NULL,
    proxy_object character varying(255) COLLATE pg_catalog."default",
    quantity_of_material integer,
    status_of_operation boolean,
    type_of_spare_part_id bigint,
    type_of_spare_part_name character varying(50) COLLATE pg_catalog."default",
    completed_work_id bigint,
    CONSTRAINT consumption_of_materials_pkey PRIMARY KEY (id),
    CONSTRAINT uk_esppkxc7bih6egf1c4gmguuo6 UNIQUE (completed_work_id),
    CONSTRAINT fk7s8cxnobiyvf01gbti6xifbdl FOREIGN KEY (completed_work_id)
        REFERENCES public.completed_work (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.consumption_of_materials
    OWNER to admin;


-- Table: public.workshop_equipment
-- DROP TABLE IF EXISTS public.workshop_equipment;
CREATE TABLE IF NOT EXISTS public.workshop_equipment
(
    id bigint NOT NULL,
    inventory_number character varying(255) COLLATE pg_catalog."default",
    model character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT workshop_equipment_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.workshop_equipment
    OWNER to admin;


-- Table: public.repair_card
-- DROP TABLE IF EXISTS public.repair_card;
CREATE TABLE IF NOT EXISTS public.repair_card
(
    id bigint NOT NULL,
    begin_repair_timestamp timestamp(6) with time zone,
    end_repair_timestamp timestamp(6) with time zone,
    repair_type smallint,
    workshop_equipment_id bigint,
    CONSTRAINT uk_ojak2jh63cc7aboagc6q4b0cj UNIQUE (workshop_equipment_id),
    CONSTRAINT repair_card_workshop_equipment_fkey FOREIGN KEY (workshop_equipment_id)
        REFERENCES public.workshop_equipment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT repair_card_pkey PRIMARY KEY (id),
    CONSTRAINT repair_card_repair_type_check CHECK (repair_type >= 0 AND repair_type <= 4)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.repair_card
    OWNER to admin;


-- Table: public.unit
-- DROP TABLE IF EXISTS public.unit;
CREATE TABLE IF NOT EXISTS public.unit
(
    id bigint NOT NULL,
    name character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT unit_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.unit
    OWNER to admin;


-- Table: public.spare_part
-- DROP TABLE IF EXISTS public.spare_part;
CREATE TABLE IF NOT EXISTS public.spare_part
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    unit_id bigint,
    CONSTRAINT spare_part_pkey PRIMARY KEY (id),
    CONSTRAINT fkdosaguj2as8v3jboivpr3bf1j FOREIGN KEY (unit_id)
        REFERENCES public.unit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.spare_part
    OWNER to admin;

-- Table: public.type_of_operation
-- DROP TABLE IF EXISTS public.type_of_operation;
CREATE TABLE IF NOT EXISTS public.type_of_operation
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    completed_work_id bigint,
    unit_id bigint,
    CONSTRAINT type_of_operation_pkey PRIMARY KEY (id),
    CONSTRAINT fkev3fp57pjke5v6jgt2uqwrpry FOREIGN KEY (completed_work_id)
        REFERENCES public.completed_work (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fko3465d4c8oglu6tduubas14es FOREIGN KEY (unit_id)
        REFERENCES public.unit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.type_of_operation
    OWNER to admin;


-- Table: public.type_of_spare_part
-- DROP TABLE IF EXISTS public.type_of_spare_part;
CREATE TABLE IF NOT EXISTS public.type_of_spare_part
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    spare_part bigint,
    CONSTRAINT type_of_spare_part_pkey PRIMARY KEY (id),
    CONSTRAINT fke4ns7fqrgn2flgyxh1jmkl05q FOREIGN KEY (spare_part)
        REFERENCES public.spare_part (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.type_of_spare_part
    OWNER to admin;


-- Table: public.workshop_module
-- DROP TABLE IF EXISTS public.workshop_module;
CREATE TABLE IF NOT EXISTS public.workshop_module
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    consumption_of_materials_id bigint,
    repair_card_id bigint,
    unit_id bigint,
    CONSTRAINT workshop_module_pkey PRIMARY KEY (id),
    CONSTRAINT fk2qh8wt0424jpgdmccn010exjh FOREIGN KEY (consumption_of_materials_id)
        REFERENCES public.consumption_of_materials (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk300dsev8edf2f65ky4lgskuj5 FOREIGN KEY (unit_id)
        REFERENCES public.unit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fko953j2t1u54vupialioqya7x2 FOREIGN KEY (repair_card_id)
        REFERENCES public.repair_card (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.workshop_module
    OWNER to admin;