
-- Table: public.workshop_unit
-- DROP TABLE IF EXISTS public.workshop_unit;
CREATE TABLE IF NOT EXISTS public.workshop_unit
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT workshop_unit_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.workshop_unit
    OWNER to admin;


-- Table: public.spare_part
-- DROP TABLE IF EXISTS public.spare_part;
CREATE TABLE IF NOT EXISTS public.spare_part
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    workshop_unit_id bigint,
    CONSTRAINT spare_part_pkey PRIMARY KEY (id),
    CONSTRAINT fkdosaguj2as8v3jboivpr3bf1j FOREIGN KEY (workshop_unit_id)
        REFERENCES public.workshop_unit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.spare_part
    OWNER to admin;


-- Table: public.type_of_spare_part
-- DROP TABLE IF EXISTS public.type_of_spare_part;
CREATE TABLE IF NOT EXISTS public.type_of_spare_part
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    spare_part_id bigint,
    CONSTRAINT type_of_spare_part_pkey PRIMARY KEY (id),
    CONSTRAINT fke4ns7fqrgn2flgyxh1jmkl05q FOREIGN KEY (spare_part_id)
        REFERENCES public.spare_part (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.type_of_spare_part
    OWNER to admin;


-- Table: public.completed_work
-- DROP TABLE IF EXISTS public.completed_work;
CREATE TABLE IF NOT EXISTS public.completed_work
(
    id bigint NOT NULL,
    notation character varying(255) COLLATE pg_catalog."default",
    spare_part_id bigint,
    repair_type character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT completed_work_pkey PRIMARY KEY (id),
    CONSTRAINT fk5bt0087bqlft5c91urjg7u0o9 FOREIGN KEY (spare_part_id)
        REFERENCES public.spare_part (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.completed_work
    OWNER to admin;


-- Table: public.workshop_equipment
-- DROP TABLE IF EXISTS public.workshop_equipment;
CREATE TABLE IF NOT EXISTS public.workshop_equipment
(
    id bigint                   NOT NULL,
    name                        character varying(255)
        COLLATE pg_catalog."default",
    CONSTRAINT equipment_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.workshop_equipment
    OWNER to admin;


-- Table: public.workshop_proxy
-- DROP TABLE IF EXISTS public.workshop_proxy;
CREATE TABLE IF NOT EXISTS public.workshop_proxy
(
    id bigint NOT NULL,
    name                        character varying(255)
        COLLATE pg_catalog."default",
    equipment_id                bigint,
    CONSTRAINT proxy_pkey PRIMARY KEY (id),
    CONSTRAINT proxy_equipment_fkey FOREIGN KEY (equipment_id)
        REFERENCES public.workshop_equipment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.workshop_proxy
    OWNER to admin;



-- Table: public.workshop_equipment
-- DROP TABLE IF EXISTS public.workshop_equipment;
CREATE TABLE IF NOT EXISTS public.workshop_element
(
    id bigint NOT NULL,
    prefix_inventory_number     character varying(12),
    inventory_number            character varying(50)
        COLLATE pg_catalog."default",
    proxy_id                    bigint,
    equipment_id                bigint,
    CONSTRAINT workshop_equipment_pkey PRIMARY KEY (id),
    CONSTRAINT workshop_equipment_equipment_fkey FOREIGN KEY (equipment_id)
        REFERENCES public.workshop_equipment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT workshop_equipment_proxy_equipment_fkey FOREIGN KEY (proxy_id)
        REFERENCES public.workshop_proxy (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.workshop_element
    OWNER to admin;


-- Table: public.repair_card_of_equipment
-- DROP TABLE IF EXISTS public.repair_card_of_equipment;
CREATE TABLE IF NOT EXISTS public.repair_card_of_equipment
(
    id                      uuid NOT NULL,
    equipment_name          character varying (255),
    begin_repair_timestamp  timestamp(6) with time zone,
    end_repair_timestamp    timestamp(6) with time zone,
    repair_type             smallint,
    workshop_element_id bigint,
    CONSTRAINT repair_card_of_equipment_pkey PRIMARY KEY (id),
    CONSTRAINT fkat107puy91fjk7vn42srmoffg FOREIGN KEY (workshop_element_id)
        REFERENCES public.workshop_element (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT repair_card_of_equipment_repair_type_check CHECK (repair_type >= 0 AND repair_type <= 4)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.repair_card_of_equipment
    OWNER to admin;


-- Table: public.workshop_module
-- DROP TABLE IF EXISTS public.workshop_module;
CREATE TABLE IF NOT EXISTS public.workshop_module
(
    id uuid NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    workshop_element_id bigint,
    workshop_unit_id bigint,
    CONSTRAINT workshop_module_pkey PRIMARY KEY (id),
    CONSTRAINT fk8icbrhomuq1odnfc13dpg9lg6 FOREIGN KEY (workshop_element_id)
            REFERENCES public.workshop_element (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION,
    CONSTRAINT fkth7wd6uclr811wbg0al43i49h FOREIGN KEY (workshop_unit_id)
        REFERENCES public.workshop_unit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.workshop_module
    OWNER to admin;


-- Table: public.repair_card_of_module
-- DROP TABLE IF EXISTS public.repair_card_of_module;
CREATE TABLE IF NOT EXISTS public.repair_card_of_module
(
    id uuid NOT NULL,
    repair_card_of_equipment_id uuid,
    workshop_module_id uuid,
    CONSTRAINT repair_card_of_module_pkey PRIMARY KEY (id),
    CONSTRAINT fkdca1yvw5ao8s9ob08k31so169 FOREIGN KEY (repair_card_of_equipment_id)
        REFERENCES public.repair_card_of_equipment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkiasb1evm6toko9f6tqqsne5si FOREIGN KEY (workshop_module_id)
        REFERENCES public.workshop_module (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.repair_card_of_module
    OWNER to admin;


-- Table: public.consumption_of_material
-- DROP TABLE IF EXISTS public.consumption_of_material;
CREATE TABLE IF NOT EXISTS public.consumption_of_material
(
    id bigint                       NOT NULL,
    quantity_of_material            integer,
    type_of_spare_part_id           bigint,
    completed_work_id               bigint,
    repair_card_of_module_id        uuid,
    workshop_module_id              uuid,
    CONSTRAINT consumption_of_material_pkey PRIMARY KEY (id),
    CONSTRAINT fk67eueksxfhwp6ektn4gtrnk6d FOREIGN KEY (completed_work_id)
        REFERENCES public.completed_work (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk83rcs2b8rp28e3035s4vbi1qn FOREIGN KEY (repair_card_of_module_id)
        REFERENCES public.repair_card_of_module (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkc9utymm7inal6b3bh4q3nrw1p FOREIGN KEY (workshop_module_id)
        REFERENCES public.workshop_module (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT consumption_of_material_type_of_spare_part FOREIGN KEY (type_of_spare_part_id)
        REFERENCES public.type_of_spare_part (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.consumption_of_material
    OWNER to admin;


-- Table: public.type_of_operation
-- DROP TABLE IF EXISTS public.type_of_operation;
CREATE TABLE IF NOT EXISTS public.type_of_operation
(
    id bigint NOT NULL,
    operation_type smallint,
    completed_work_id bigint,
    unit_id bigint,
    CONSTRAINT type_of_operation_pkey PRIMARY KEY (id),
    CONSTRAINT fkev3fp57pjke5v6jgt2uqwrpry FOREIGN KEY (completed_work_id)
        REFERENCES public.completed_work (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fki3mu3cpnpo50o9jc4kj2fcd62 FOREIGN KEY (unit_id)
        REFERENCES public.workshop_unit (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT type_of_operation_operation_type_check CHECK (operation_type >= 0 AND operation_type <= 3)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.type_of_operation
    OWNER to admin;

