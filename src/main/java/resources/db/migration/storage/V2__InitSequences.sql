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

-- SEQUENCE: public.equipment_seq
-- DROP SEQUENCE IF EXISTS public.good_seq;
CREATE SEQUENCE IF NOT EXISTS public.equipment_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.equipment_seq
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

-- SEQUENCE: public.quantity_account_seq
-- DROP SEQUENCE IF EXISTS public.quantity_account_seq;
CREATE SEQUENCE IF NOT EXISTS public.quantity_account_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.quantity_account_seq
    OWNER TO admin;


-- SEQUENCE: public.parcel_seq
-- DROP SEQUENCE IF EXISTS public.parcel_seq;
CREATE SEQUENCE IF NOT EXISTS public.parcel_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

-- SEQUENCE: public.goods_tracking_date_seq
-- DROP SEQUENCE IF EXISTS public.goods_tracking_date_seq;
CREATE SEQUENCE IF NOT EXISTS public.goods_tracking_date_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.goods_tracking_date_seq
    OWNER TO admin;

-- SEQUENCE: public.prefix_inventory_number_seq
-- DROP SEQUENCE IF EXISTS public.prefix_inventory_number_seq;
CREATE SEQUENCE IF NOT EXISTS public.prefix_inventory_number_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.prefix_inventory_number_seq
    OWNER TO admin;
