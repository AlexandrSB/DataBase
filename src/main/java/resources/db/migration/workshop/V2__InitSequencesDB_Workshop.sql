-- SEQUENCE: public.completed_work_seq
-- DROP SEQUENCE IF EXISTS public.completed_work_seq;
CREATE SEQUENCE IF NOT EXISTS public.completed_work_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.completed_work_seq
    OWNER TO admin;


-- SEQUENCE: public.consumption_of_materials_seq
-- DROP SEQUENCE IF EXISTS public.consumption_of_materials_seq;
CREATE SEQUENCE IF NOT EXISTS public.consumption_of_material_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.consumption_of_material_seq
    OWNER TO admin;


-- SEQUENCE: public.spare_part_seq
-- DROP SEQUENCE IF EXISTS public.spare_part_seq;
CREATE SEQUENCE IF NOT EXISTS public.spare_part_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.spare_part_seq
    OWNER TO admin;


-- SEQUENCE: public.type_of_operation_seq
-- DROP SEQUENCE IF EXISTS public.type_of_operation_seq;
CREATE SEQUENCE IF NOT EXISTS public.type_of_operation_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.type_of_operation_seq
    OWNER TO admin;


-- SEQUENCE: public.type_of_spare_part_seq
-- DROP SEQUENCE IF EXISTS public.type_of_spare_part_seq;
CREATE SEQUENCE IF NOT EXISTS public.type_of_spare_part_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.type_of_spare_part_seq
    OWNER TO admin;


-- SEQUENCE: public.unit_seq
-- DROP SEQUENCE IF EXISTS public.unit_seq;
CREATE SEQUENCE IF NOT EXISTS public.workshop_unit_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.workshop_unit_seq
    OWNER TO admin;


-- SEQUENCE: public.workshop_equipment_seq
-- DROP SEQUENCE IF EXISTS public.workshop_equipment_seq;
CREATE SEQUENCE IF NOT EXISTS public.workshop_equipment_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.workshop_equipment_seq
    OWNER TO admin;


-- SEQUENCE: public.workshop_module_seq
-- DROP SEQUENCE IF EXISTS public.workshop_module_seq;
CREATE SEQUENCE IF NOT EXISTS public.workshop_module_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
ALTER SEQUENCE public.workshop_module_seq
    OWNER TO admin;