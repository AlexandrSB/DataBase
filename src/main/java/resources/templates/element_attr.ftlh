<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>
    <#assign path = "/proxy/${proxy.id}/${attr_group.id}/${attr.id}">
    <#include "parts/navbar/navbar_proxy_breadcramb.ftlh" />

    <@se.header_1
        title = proxy.name
        />

    <@se.header_2
        title = attr_group.attributeGroupDictionary.name
        />

    <@se.header_3
        title = attr.attributeDictionary.name
        />


    <form action="/addAttrValueName" method="post" id="addAttrId">
        <@se.input_hidden
            name = "path"
            value = path
        />

        <@se.input_hidden
            name = "attr_dic_id"
            value = attr.attributeDictionary.id
        />

        <@se.input_element
            element_name = "attr_value_name"
            element_id = "attribute_value_id"
            label = "Attribute value name"
            placeholder = "Insert name of attribute value"
        />

        <@se.button_send
            button_name = "Add attribute value name"
        />
    </form>

    <form action="/addAttributeValue" method="post" id="proxy_add_group">
        <@se.input_hidden
            name = "path"
            value = path
        />

        <@se.input_hidden
            name = "attr_id"
            value = attr.id
        />

        <@se.select_element
            element_name = "attr_value_name"
            element_id = "attribute_id"
            label = "Attribute value"
            placeholder = "Insert attribute value"
            elements_array = attr_value_dic
            elements_attr = "name"
        />

        <@se.button_send
            button_name = "Add attribute value"
        />
    </form>

    <form action="/addUnitName" method="post" id="addUnitNameId">
        <@se.input_hidden
            name = "path"
            value = path
        />

        <@se.input_hidden
            name = "attr_dic_id"
            value = attr.attributeDictionary.id
        />

        <@se.input_element
            element_name = "unit_name"
            element_id = "unit_name_id"
            label = "Unit name"
            placeholder = "Insert name of Unit"
        />

        <@se.button_send
            button_name = "Add Unit name"
        />
    </form>

    <#if attr.attributeValue??>
    <form action="/addUnit" method="post" id="add_unit_id">
        <@se.input_hidden
            name = "path"
            value = path
        />

        <@se.input_hidden
            name = "attr_id"
            value = attr.id
        />

        <@se.select_element
            element_name = "unit_dic_name"
            element_id = "unit_dic_id"
            label = "Unit"
            placeholder = "Insert unit"
            elements_array = unit_dic
            elements_attr = "name"
        />

        <@se.button_send
            button_name = "Add attribute value"
        />
    </form>
    </#if>


    ${attr.attributeDictionary.name}
    <#if attr.attributeValue??>
        -- ${attr.attributeValue.attributeValueDictionary.name}
        <#if attr.unit?? &&
            attr.unit.unitDictionary.name != "<none>">
                ${attr.unit.unitDictionary.name}
        </#if>
    </#if>

</@c.page>