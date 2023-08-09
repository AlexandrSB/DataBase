-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/OBYJ94
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE IF NOT EXISTS "storage" (
    -- Склад хранения
    "id" int8   NOT NULL,
    "name" character(50)   NOT NULL,
    "quantity" int   NOT NULL,
    "description" character(800)   NULL,
    CONSTRAINT "pk_storage" PRIMARY KEY (
        "id"
     ),
    CONSTRAINT "uc_storage_name" UNIQUE (
        "name"
    )
);


CREATE TABLE IF NOT EXISTS "condition" (
    -- Описывает состояние оборудования
    -- (в ремонте, списано, донор)
    "id" int8   NOT NULL,
    "name" character(50)   NOT NULL,
    CONSTRAINT "pk_condition" PRIMARY KEY (
        "id"
     ),
    CONSTRAINT "uc_condition_name" UNIQUE (
        "name"
    )
);


CREATE TABLE IF NOT EXISTS "contragent" (
    "id" int8   NOT NULL,
    "name" character(50)   NOT NULL,
    "description" character(800)   NULL,
    CONSTRAINT "pk_contragent" PRIMARY KEY (
        "id"
     ),
    CONSTRAINT "uc_contragent_name" UNIQUE (
        "name"
    )
);


CREATE TABLE IF NOT EXISTS "goods" (
    -- Товар
    "id" int8   NOT NULL,
    "name" character(50)   NOT NULL,
    "inventory_number" character(50) NULL,
    "barcode" int  NULL,
    "description" character(800)   NULL,
    "condition_id" int8   NOT NULL,
    CONSTRAINT "pk_goods" PRIMARY KEY (
        "id"
     ),
);

CREATE TABLE IF NOT EXISTS "storage_goods" (
    "id" int8   NOT NULL,
    "goods_id" int8   NOT NULL,
    "storage_id" int8   NOT NULL,
    CONSTRAINT "pk_storage_goods" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE IF NOT EXISTS "direction" (
    -- Направление движения товара(справочник)
    "id" int8   NOT NULL,
    "type" character(50)   NOT NULL,
    CONSTRAINT "pk_direction" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE IF NOT EXISTS "goods_tracking" (
    -- Движение товара
    "id" int8   NOT NULL,
    "date" date   NOT NULL,
    "quantity" integer   NOT NULL,
    "storage_id" int8   NOT NULL,
    "contragent_id" int8   NULL,
    "direction_id" int8   NOT NULL,
    CONSTRAINT "pk_goods_tracking" PRIMARY KEY (
        "id"
     )
);

ALTER TABLE "goods" DROP CONSTRAINT IF EXISTS "fk_goods_condition_id";
ALTER TABLE "goods" ADD CONSTRAINT "fk_goods_condition_id" FOREIGN KEY("condition_id")
REFERENCES "condition" ("id");

ALTER TABLE "storage_goods" DROP CONSTRAINT IF EXISTS "fk_storage_goods_ahead_id";
ALTER TABLE "storage_goods" ADD CONSTRAINT "fk_storage_goods_ahead_id" FOREIGN KEY("goods_id")
REFERENCES "goods" ("id");

ALTER TABLE "storage_goods" DROP CONSTRAINT IF EXISTS "fk_storage_goods_back_id";
ALTER TABLE "storage_goods" ADD CONSTRAINT "fk_storage_goods_back_id" FOREIGN KEY("storage_id")
REFERENCES "storage" ("id");

ALTER TABLE "goods_tracking" DROP CONSTRAINT IF EXISTS "fk_goods_tracking_direction_id";
ALTER TABLE "goods_tracking" ADD CONSTRAINT "fk_goods_tracking_direction_id" FOREIGN KEY("direction_id")
REFERENCES "direction" ("id");

ALTER TABLE "goods_tracking" DROP CONSTRAINT IF EXISTS "fk_goods_tracking_contragent_id";
ALTER TABLE "goods_tracking" ADD CONSTRAINT "fk_goods_tracking_contragent_id" FOREIGN KEY("contragent_id")
REFERENCES "contragent" ("id");

ALTER TABLE "goods_tracking" DROP CONSTRAINT IF EXISTS "fk_goods_tracking_storage_id";
ALTER TABLE "goods_tracking" ADD CONSTRAINT "fk_goods_tracking_storage_id" FOREIGN KEY("storage_id")
REFERENCES "storage" ("id");

-- SEQUENCE: public.contragent_seq

-- DROP SEQUENCE IF EXISTS public.contragent_seq;

CREATE SEQUENCE IF NOT EXISTS public.contragent_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY contragent.id;

-- SEQUENCE: public.goods_seq

-- DROP SEQUENCE IF EXISTS public.goods_seq;

CREATE SEQUENCE IF NOT EXISTS public.goods_seq
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY goods.id;