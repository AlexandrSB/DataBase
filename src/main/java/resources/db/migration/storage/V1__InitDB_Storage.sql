-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/OBYJ94
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE "equipment" (
    -- Оборудование
    "id" int8   NOT NULL,
    "inventory_number" int8   NOT NULL,
    "description" character(800)   NULL,
    "goods_id" UUID   NOT NULL,
    "completed_work_id" int8   NOT NULL,
    "condition_id" int8   NOT NULL,
    CONSTRAINT "pk_equipment" PRIMARY KEY (
        "id"
     ),
    CONSTRAINT "uc_equipment_inventory_number" UNIQUE (
        "inventory_number"
    )
);

CREATE TABLE "storage" (
    -- Склад хранения
    "storage_id" int8   NOT NULL,
    "name" character(50)   NOT NULL,
    "quantity" int   NOT NULL,
    "delivery_date" date   NOT NULL,
    "issue_date" date   NOT NULL,
    "description" character(800)   NULL,
    CONSTRAINT "pk_storage" PRIMARY KEY (
        "storage_id"
     ),
    CONSTRAINT "uc_storage_name" UNIQUE (
        "name"
    )
);

CREATE TABLE "condition" (
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

CREATE TABLE "contragent" (
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

CREATE TABLE "goods" (
    -- Товар?
    "id" UUID   NOT NULL,
    "name" int8   NOT NULL,
    "description" character(800)   NOT NULL,
    "data" date   NOT NULL,
    "type" int8   NOT NULL,
    "barcode" int   NOT NULL,
    CONSTRAINT "pk_goods" PRIMARY KEY (
        "id"
     ),
    CONSTRAINT "uc_goods_name" UNIQUE (
        "name"
    )
);

CREATE TABLE "goods_storage" (
    "id" UUID   NOT NULL,
    "goods_id" UUID   NOT NULL,
    "storage_id" int8   NOT NULL,
    CONSTRAINT "pk_goods_storage" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "completed_work" (
    -- Дата выполненния ремонта
    "id" int8   NOT NULL,
    "description" character(800)   NOT NULL,
    "data" date   NOT NULL,
    CONSTRAINT "pk_completed_work" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "contragent_goods" (
    "id" int8   NOT NULL,
    "goods_id" UUID   NOT NULL,
    "contragent_id" int8   NOT NULL,
    CONSTRAINT "pk_contragent_goods" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "type_of_goods" (
    "id" int8   NOT NULL,
    "type" character(50)   NOT NULL,
    CONSTRAINT "pk_type_of_goods" PRIMARY KEY (
        "id"
     )
);

CREATE TABLE "documents" (
    "id" UUID   NOT NULL,
    "type" character(50)   NOT NULL,
    "goods_storage_id" UUID   NOT NULL,
    "contragent_storage" int8   NOT NULL,
    CONSTRAINT "pk_documents" PRIMARY KEY (
        "id"
     )
);

ALTER TABLE "equipment" ADD CONSTRAINT "fk_equipment_goods_id" FOREIGN KEY("goods_id")
REFERENCES "goods" ("id");

ALTER TABLE "equipment" ADD CONSTRAINT "fk_equipment_completed_work_id" FOREIGN KEY("completed_work_id")
REFERENCES "completed_work" ("id");

ALTER TABLE "equipment" ADD CONSTRAINT "fk_equipment_condition_id" FOREIGN KEY("condition_id")
REFERENCES "condition" ("id");

ALTER TABLE "goods" ADD CONSTRAINT "fk_goods_type" FOREIGN KEY("type")
REFERENCES "type_of_goods" ("id");

ALTER TABLE "goods_storage" ADD CONSTRAINT "fk_goods_storage_goods_id" FOREIGN KEY("goods_id")
REFERENCES "goods" ("id");

ALTER TABLE "goods_storage" ADD CONSTRAINT "fk_goods_storage_storage_id" FOREIGN KEY("storage_id")
REFERENCES "storage" ("storage_id");

ALTER TABLE "contragent_goods" ADD CONSTRAINT "fk_contragent_goods_goods_id" FOREIGN KEY("goods_id")
REFERENCES "goods" ("id");

ALTER TABLE "contragent_goods" ADD CONSTRAINT "fk_contragent_goods_contragent_id" FOREIGN KEY("contragent_id")
REFERENCES "contragent" ("id");

ALTER TABLE "documents" ADD CONSTRAINT "fk_documents_goods_storage_id" FOREIGN KEY("goods_storage_id")
REFERENCES "goods_storage" ("id");

ALTER TABLE "documents" ADD CONSTRAINT "fk_documents_contragent_storage" FOREIGN KEY("contragent_storage")
REFERENCES "contragent_goods" ("id");