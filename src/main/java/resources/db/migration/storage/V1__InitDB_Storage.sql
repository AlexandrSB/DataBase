-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/OBYJ94
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.

CREATE TABLE IF NOT EXISTS "storage" (
    -- Склад хранения
    "id" int8   NOT NULL,
    "name" character(50)   NOT NULL,
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
    "fixed_card_id" int8   NULL,
    "barcode_id" int8   NULL,
    CONSTRAINT "pk_goods" PRIMARY KEY (
        "id"
     ),
    CONSTRAINT "uc_goods_name" UNIQUE (
        "name"
    )
);

CREATE TABLE IF NOT EXISTS "direction" (
    -- Направление движения товара(справочник)
    "id" int8   NOT NULL,
    "type" character(50)   NOT NULL,
    CONSTRAINT "pk_direction" PRIMARY KEY (
        "id"
     ),
    CONSTRAINT "uc_direction_type" UNIQUE (
        "type"
    )
);

CREATE TABLE IF NOT EXISTS "goods_tracking" (
    -- Движение товара
    "id" int8   NOT NULL,
    "date" date   NOT NULL,
    "direction_id" int8   NOT NULL,
    "contragent_id" int8   NOT NULL,
    "storage_id" int8   NOT NULL,
    CONSTRAINT "pk_goods_tracking" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE IF NOT EXISTS "storage_goods" (
    -- Хранение товара на складе
    "id" int8   NOT NULL,
    "goods_id" int8   NOT NULL,
    "storage_id" int8   NOT NULL,
    CONSTRAINT "pk_storage_goods" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE IF NOT EXISTS "equipment" (
    -- Оборудование
    "id" int8   NOT NULL,
    "inventory_number" character(50)   NULL,
    "condition_id" int8   NOT NULL,
    CONSTRAINT "pk_equipment" PRIMARY KEY (
        "id"
     ),
    CONSTRAINT "uc_equipment_inventory_number" UNIQUE (
        "inventory_number"
    )
);

CREATE TABLE IF NOT EXISTS "fixed_card" (
    -- карта ремонта
    "id" int   NOT NULL,
    "fixed_date" date   NOT NULL,
    "equip_id" int8   NOT NULL,
    "notice" character(800)   NULL,
    CONSTRAINT "pk_fixed_card" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE IF NOT EXISTS "party" (
    -- партия товара
    "id" int8   NOT NULL,
    "goods_tracking_id" int8   NOT NULL,
    "goods_id" int8   NOT NULL,
    CONSTRAINT "pk_party" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE IF NOT EXISTS "dimension_goods" (
    --
    "id" int8 NOT NULL,
    "dimension_id" int8 NOT NULL, --FK >- dimension.id
    "goods_id" int8 NOT NULL, --FK >- goods.id
    CONSTRAINT "pk_dimension_goods" PRIMARY KEY (
        "id"
     )
);


CREATE TABLE IF NOT EXISTS "dimension" (
    --
    -- справочник количественного учета
    "id" int8 NOT NULL, --PK
    "parent_id" int8 NOT NULL, --FK >- dimension.id
    "dimension" character(50),
    CONSTRAINT "pk_dimension" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE IF NOT EXISTS "quantity" (
    --
    -- количество
    "id" int8 NOT NULL, --PK
    "quantity" int8,
    "dimension_id" int8 NOT NULL, --FK - dimension.id
    CONSTRAINT "pk_quantity" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE IF NOT EXISTS "barcode" (
    --
    -- штрих-коды
    "id" int8 NOT NULL, --PK
    "barcode" int8,
    CONSTRAINT "pk_barcode" PRIMARY KEY (
        "id"
     )
);


ALTER TABLE "goods" DROP CONSTRAINT IF EXISTS "fk_goods_fixed_card_id";
ALTER TABLE "goods" ADD CONSTRAINT "fk_goods_fixed_card_id" FOREIGN KEY("fixed_card_id")
REFERENCES "fixed_card" ("id");

ALTER TABLE "goods" DROP CONSTRAINT IF EXISTS "fk_goods_barcode";
ALTER TABLE "goods" ADD CONSTRAINT "fk_goods_barcode" FOREIGN KEY("barcode_id")
REFERENCES "barcode" ("id");

ALTER TABLE "goods_tracking" DROP CONSTRAINT IF EXISTS "fk_goods_tracking_direction_id";
ALTER TABLE "goods_tracking" ADD CONSTRAINT "fk_goods_tracking_direction_id" FOREIGN KEY("direction_id")
REFERENCES "direction" ("id");

ALTER TABLE "goods_tracking" DROP CONSTRAINT IF EXISTS "fk_goods_tracking_contragent_id";
ALTER TABLE "goods_tracking" ADD CONSTRAINT "fk_goods_tracking_contragent_id" FOREIGN KEY("contragent_id")
REFERENCES "contragent" ("id");

ALTER TABLE "goods_tracking" DROP CONSTRAINT IF EXISTS "fk_goods_tracking_storage_id";
ALTER TABLE "goods_tracking" ADD CONSTRAINT "fk_goods_tracking_storage_id" FOREIGN KEY("storage_id")
REFERENCES "storage" ("id");

ALTER TABLE "storage_goods" DROP CONSTRAINT IF EXISTS "fk_storage_goods_goods_id";
ALTER TABLE "storage_goods" ADD CONSTRAINT "fk_storage_goods_goods_id" FOREIGN KEY("goods_id")
REFERENCES "goods" ("id");

ALTER TABLE "storage_goods" DROP CONSTRAINT IF EXISTS "fk_storage_goods_storage_id";
ALTER TABLE "storage_goods" ADD CONSTRAINT "fk_storage_goods_storage_id" FOREIGN KEY("storage_id")
REFERENCES "storage" ("id");

ALTER TABLE "equipment" DROP CONSTRAINT IF EXISTS "fk_equipment_id";
ALTER TABLE "equipment" ADD CONSTRAINT "fk_equipment_id" FOREIGN KEY("id")
REFERENCES "goods" ("id");

ALTER TABLE "equipment" DROP CONSTRAINT IF EXISTS "fk_equipment_condition_id";
ALTER TABLE "equipment" ADD CONSTRAINT "fk_equipment_condition_id" FOREIGN KEY("condition_id")
REFERENCES "condition" ("id");

ALTER TABLE "party" DROP CONSTRAINT IF EXISTS "fk_party_goods_tracking_id";
ALTER TABLE "party" ADD CONSTRAINT "fk_party_goods_tracking_id" FOREIGN KEY("goods_tracking_id")
REFERENCES "goods_tracking" ("id");

ALTER TABLE "party" DROP CONSTRAINT IF EXISTS "fk_party_goods_id";
ALTER TABLE "party" ADD CONSTRAINT "fk_party_goods_id" FOREIGN KEY("goods_id")
REFERENCES "goods" ("id");

ALTER TABLE "dimension" DROP CONSTRAINT IF EXISTS "fk_dimension_dimension_id";
ALTER TABLE "dimension" ADD CONSTRAINT "fk_dimension_dimension_id" FOREIGN KEY("parent_id")
REFERENCES "dimension" ("id");

ALTER TABLE "quantity" DROP CONSTRAINT IF EXISTS "fk_dimension_dimension_id";
ALTER TABLE "quantity" ADD CONSTRAINT "fk_quantity_dimension" FOREIGN KEY("dimension_id")
REFERENCES "dimension" ("id");


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