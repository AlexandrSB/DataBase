-- ************************* SqlDBM: PostgreSQL *************************
-- ****** Generated by SqlDBM: Workshop, v46 by Finn1435@rambler.ru *****

-- ************************************** barcode

CREATE TABLE IF NOT EXISTS "public".elements_group
(
    id                bigint NOT NULL UNIQUE,
    name                    character varying(100) NOT NULL UNIQUE,
    parent_id               bigint NULL,
    CONSTRAINT PK_groups PRIMARY KEY ( id ),
    CONSTRAINT FK_10_1 FOREIGN KEY ( parent_id )
        REFERENCES "public".elements_group ( id )
);

    CREATE INDEX IF NOT EXISTS FK_Index_parentID ON "public".elements_group
    (
        parent_id
    );


CREATE TABLE IF NOT EXISTS "public".element_type
(
    id                      bigint NOT NULL UNIQUE,
    type                    character varying(50) NOT NULL,
    group_id                bigint,
    CONSTRAINT PK_element_type_id PRIMARY KEY ( id ),
    CONSTRAINT FK_12 FOREIGN KEY ( group_id )
        REFERENCES "public".elements_group ( id )
);


CREATE TABLE IF NOT EXISTS "public".element
(
    id                      bigint NOT NULL UNIQUE,
    name                    character varying(250) NOT NULL UNIQUE,
    description             character varying(5000) NULL,
    parent_id               bigint NULL,
    category                smallint,
    element_type_id         bigint NOT NULL,
    CONSTRAINT PK_component PRIMARY KEY ( id ),
    CONSTRAINT unique_component_name_constraint UNIQUE ( name ),
    CONSTRAINT FK_parent_id FOREIGN KEY ( parent_id )
        REFERENCES "public".element ( id ),
    CONSTRAINT FK_element_type_id FOREIGN KEY ( element_type_id )
        REFERENCES "public".element_type ( id )
);

    CREATE INDEX IF NOT EXISTS FK_2 ON "public".element
    (
        parent_id
    );


CREATE TABLE IF NOT EXISTS "public".element_groups
(
    element_id              bigint NULL UNIQUE,
    group_id                bigint NULL,
    CONSTRAINT PK_element_groups PRIMARY KEY ( element_id, group_id ),
    CONSTRAINT FK_11 FOREIGN KEY ( element_id )
        REFERENCES "public".element ( id ),
    CONSTRAINT FK_12 FOREIGN KEY ( group_id )
        REFERENCES "public".elements_group ( id )
);

    CREATE INDEX IF NOT EXISTS FK_Index_elementID
        ON element_groups
    (
        element_id
    );

    CREATE INDEX IF NOT EXISTS FK_Index_groupID
        ON "public".element_groups
    (
        group_id
    );


CREATE TABLE IF NOT EXISTS public.proxy
(
    id                      bigint NOT NULL,
    name                    character varying(250) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT PK_proxy PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS "public".elements_composite
(
    id                      bigint NOT NULL,
    element_source          bigint NOT NULL,
    element_destination     bigint NOT NULL,
    proxy_id                bigint NULL,
    CONSTRAINT PK_elements_composite PRIMARY KEY ( id ),
    CONSTRAINT FK_element_source FOREIGN KEY ( element_source )
        REFERENCES "public"."element" ( id ),
    CONSTRAINT FK_element_destination FOREIGN KEY ( element_destination )
        REFERENCES "public"."element" ( id ),
    CONSTRAINT FK_element_composite_proxy FOREIGN KEY ( proxy_id )
        REFERENCES "public"."proxy" ( id )
);

    CREATE INDEX IF NOT EXISTS FK_Index_element_source
        ON "public".elements_composite
    (
        element_source
    );

    CREATE INDEX IF NOT EXISTS FK_Index_element_destination
        ON "public".elements_composite
    (
        element_destination
    );


CREATE TABLE IF NOT EXISTS public.element_proxy
(
    element_id              bigint NOT NULL,
    proxy_id                bigint NOT NULL,
    CONSTRAINT PK_element_proxy PRIMARY KEY (element_id, proxy_id),
    CONSTRAINT FK_element FOREIGN KEY (element_id)
        REFERENCES public.element (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_proxy FOREIGN KEY (proxy_id)
        REFERENCES public.proxy (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);


CREATE TABLE IF NOT EXISTS "public".attr_group_dic
(
    id                      bigint NOT NULL UNIQUE,
    name                    character varying(250)
        COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT attr_group_dic_pkey PRIMARY KEY ( id )
);


CREATE TABLE IF NOT EXISTS "public".attribute_group
(
    id                      bigint NOT NULL,
    attr_group_dic_id       bigint NOT NULL,
    proxy_id                bigint NOT NULL,
    CONSTRAINT PK_attribute_group PRIMARY KEY ( id ),
    CONSTRAINT FK_attr_group_attr_group_dic FOREIGN KEY ( attr_group_dic_id )
        REFERENCES "public".attr_group_dic ( id ),
    CONSTRAINT FK_proxy FOREIGN KEY ( proxy_id )
        REFERENCES "public".proxy ( id )
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
    CREATE INDEX IF NOT EXISTS FK_Index_attributeID
        ON "public".attribute_group
    (
        id
    );


CREATE TABLE IF NOT EXISTS "public".attr_dic
(
    id                      bigint NOT NULL UNIQUE,
    name                    character varying(250),
    attr_group_dic_id       bigint NOT NULL,
    CONSTRAINT attr_dic_pkey PRIMARY KEY ( id ),
    CONSTRAINT FK_attr_attr_group_dic FOREIGN KEY ( attr_group_dic_id )
        REFERENCES "public".attr_group_dic ( id )
);


CREATE TABLE IF NOT EXISTS "public".attribute
(
    id                      bigint NOT NULL,
    attr_dic_id             bigint NOT NULL,
    attr_group_id           bigint,
    CONSTRAINT PK_attribute PRIMARY KEY ( id ),
    CONSTRAINT FK_attr_attr_dic FOREIGN KEY ( attr_dic_id )
        REFERENCES "public".attr_dic ( id ),
    CONSTRAINT attr_group_FK FOREIGN KEY ( attr_group_id )
        REFERENCES "public".attribute_group ( id )
);
    CREATE INDEX IF NOT EXISTS FK_Index_attributeID
        ON "public".attribute
    (
        id
    );


CREATE TABLE IF NOT EXISTS "public".attr_value_dic
(
    id                      bigint NOT NULL UNIQUE,
    name                    character varying(250),
    attr_dic_id             bigint NOT NULL,
    CONSTRAINT attr_value_dic_pkey PRIMARY KEY ( id ),
    CONSTRAINT FK_attr_value_attr_dic FOREIGN KEY ( attr_dic_id )
        REFERENCES "public".attr_dic ( id )
);


CREATE TABLE IF NOT EXISTS "public".attribute_value
(
    id                      bigint NOT NULL UNIQUE,
    attr_value_dic_id       bigint NOT NULL,
    CONSTRAINT attr_value_pkey PRIMARY KEY ( id ),
    CONSTRAINT FK_attribute_value FOREIGN KEY ( id )
        REFERENCES "public".attribute ( id ),
    CONSTRAINT FK_attr_value_attr_value_dic FOREIGN KEY ( attr_value_dic_id )
        REFERENCES "public".attr_value_dic ( id )
);


CREATE TABLE IF NOT EXISTS "public".unit_dic
(
    id                      bigint NOT NULL UNIQUE,
    name                    character varying(250),
    attr_dic_id             bigint NOT NULL,
    CONSTRAINT unit_dic_pkey PRIMARY KEY ( id ),
    CONSTRAINT FK_unit_dic_attr_dic FOREIGN KEY ( attr_dic_id )
        REFERENCES "public".attr_dic ( id )
);


CREATE TABLE IF NOT EXISTS "public".unit
(
    id                      bigint NOT NULL UNIQUE,
    unit_dic_id             bigint NOT NULL,
    CONSTRAINT unit_pkey PRIMARY KEY ( id ),
    CONSTRAINT FK_unit_attr_value FOREIGN KEY ( id )
        REFERENCES "public".attribute ( id ),
    CONSTRAINT FK_unit_unit_dic FOREIGN KEY ( unit_dic_id )
        REFERENCES "public".unit_dic ( id )
);


-- View: public.get_groups_with_recursion
-- DROP VIEW public.get_groups_with_recursion;
CREATE OR REPLACE VIEW public.get_groups_with_recursion
 AS
 WITH RECURSIVE temp_table AS (
         SELECT g.id,
            g.parent_id,
            g.name,
            1 AS level,
            '/'::text || g.name::text AS path,
            ARRAY[row_number() OVER (ORDER BY g.name)] AS path_sort
           FROM elements_group g
          WHERE g.parent_id IS NULL
        UNION ALL
         SELECT g.id,
            g.parent_id,
            g.name,
            t_1.level + 1 AS level,
            (t_1.path || '/'::text) || g.name::text AS path,
            t_1.path_sort || row_number() OVER (PARTITION BY g.parent_id ORDER BY g.name) AS path_sort
           FROM temp_table t_1,
            elements_group g
          WHERE g.parent_id = t_1.id
        )
 SELECT t.id,
    lpad(''::text, (t.level - 1) * 8) || t.name::text AS name,
    t.level, t.parent_id
   FROM temp_table t
  ORDER BY t.path_sort;

ALTER TABLE public.get_groups_with_recursion
    OWNER TO admin;