create table if not exists attribute (
    attribute_id integer not null,
    name varchar(255) not null,
    unit smallint,
    primary key (attribute_id)
);

create table if not exists attribute_integer_value (
    attr_int_id integer not null,
    value integer,
    primary key (attr_int_id)
);

create table if not exists attribute_string_value (
    attr_str_val integer not null,
    value varchar(255),
    primary key (attr_str_val)
);

create table if not exists component (
    component_id integer not null,
    description varchar(2048),
    is_composite boolean,
    is_electric boolean,
    is_electronic boolean,
    is_mechanic boolean,
    name varchar(255) not null,
    primary key (component_id)
);

create table if not exists component_attribute (
    comp_id integer not null,
    attr_id integer not null,
    primary key (attr_id, comp_id)
);

create table if not exists component_relationship (
    parent_id integer not null,
    child_id integer not null,
    primary key (parent_id, child_id)
);

create table if not exists equipment (
    equipment_id integer not null,
    firm_name varchar(128) not null,
    model varchar(128) not null,
    type varchar(128),
    gr_id integer,
    primary key (equipment_id)
);

create table if not exists equipment_component (
    equip_id integer not null,
    comp_id integer not null,
    primary key (comp_id, equip_id)
);

create table if not exists groups (
    group_id integer not null,
    group_name varchar(255),
    primary key (group_id)
);

alter table if exists attribute drop constraint if exists UK_hpwum0iq12fs4ej5d0tgy6wsn;
alter table if exists attribute add constraint UK_hpwum0iq12fs4ej5d0tgy6wsn unique (name);
alter table if exists component drop constraint if exists UK_qkg4faf5v8maop4avw1y44cxp;
alter table if exists component add constraint UK_qkg4faf5v8maop4avw1y44cxp unique (name);
alter table if exists equipment drop constraint if exists UK_brtfbdlnplo93o187lw1ffwch;
alter table if exists equipment add constraint UK_brtfbdlnplo93o187lw1ffwch unique (model);

create sequence if not exists attribute_seq start with 1 increment by 50;
create sequence if not exists component_seq start with 1 increment by 50;
create sequence if not exists equipment_group_seq start with 1 increment by 50;
create sequence if not exists equipment_seq start with 1 increment by 50;
create sequence if not exists groups_seq start with 1 increment by 50;

alter table if exists component_attribute
    add constraint FKa5ind1xk928ifei5b785k9bd
    foreign key (attr_id)
    references attribute;

alter table if exists component_attribute
    add constraint FKsx6ga5rf0qp56i5qpoqfl8tl9
    foreign key (comp_id)
    references component;

alter table if exists component_relationship
    add constraint FK5yxq9pvdd4r6kms60skpii3ge
    foreign key (child_id)
    references component;

alter table if exists component_relationship
    add constraint FKpqrutnghvfevw4khdujy6d22b
    foreign key (parent_id)
    references component;

alter table if exists equipment_component
    add constraint FKce2uhg91nxk9npcnf88501ca4
    foreign key (comp_id)
    references component;

alter table if exists equipment_component
    add constraint FK4pnhrdnj55cgb8h8r5dtleqm6
    foreign key (equip_id)
    references equipment;