-- SEQUENCE: public.attribute_seq
-- DROP SEQUENCE IF EXISTS public.attribute_seq;
CREATE SEQUENCE IF NOT EXISTS public.attribute_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.attribute_seq
    OWNER TO admin;


-- SEQUENCE: public.attribute_group_seq
-- DROP SEQUENCE IF EXISTS public.attribute_group_seq;
CREATE SEQUENCE IF NOT EXISTS public.attribute_group_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.attribute_group_seq
    OWNER TO admin;


-- SEQUENCE: public.element_seq
-- DROP SEQUENCE IF EXISTS public.element_seq;
CREATE SEQUENCE IF NOT EXISTS public.element_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.element_seq
    OWNER TO admin;


-- SEQUENCE: public.element_type_seq
-- DROP SEQUENCE IF EXISTS public.element_type_seq;
CREATE SEQUENCE IF NOT EXISTS public.element_type_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.element_type_seq
    OWNER TO admin;


-- SEQUENCE: public.elements_composite_seq
-- DROP SEQUENCE IF EXISTS public.elements_composite_seq;
CREATE SEQUENCE IF NOT EXISTS public.elements_composite_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.elements_composite_seq
    OWNER TO admin;


-- SEQUENCE: public.elements_group_seq
-- DROP SEQUENCE IF EXISTS public.elements_group_seq;
CREATE SEQUENCE IF NOT EXISTS public.elements_group_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.elements_group_seq
    OWNER TO admin;


-- SEQUENCE: public.proxy_seq
-- DROP SEQUENCE IF EXISTS public.proxy_seq;
CREATE SEQUENCE IF NOT EXISTS public.proxy_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.proxy_seq
    OWNER TO admin;


-- SEQUENCE: public.unit_seq
-- DROP SEQUENCE IF EXISTS public.unit_seq;
CREATE SEQUENCE IF NOT EXISTS public.unit_dic_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.unit_dic_seq
    OWNER TO admin;


