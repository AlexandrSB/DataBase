<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>
    <#assign path = "/proxy/${proxy.id}/${attr_group.id}">
    <#include "parts/navbar/navbar_proxy_breadcramb.ftlh" />

    <@se.header_1
        title = proxy.name
        />

    <@se.header_2
        title = attr_group.attributeGroupDictionary.name
        />

    <form action="/addAttrName" method="post" id="addAttrId">
        <@se.input_hidden
            name = "path"
            value = path
        />

        <@se.input_hidden
            name = "attr_group_dic_id"
            value = attr_group.attributeGroupDictionary.id
        />

        <@se.input_element
            element_name = "attribute_name"
            element_id = "attribute_id"
            label = "Attribute name"
            placeholder = "Insert name of attribute"
        />

        <@se.button_send
            button_name = "Add attribute name"
        />
    </form>

    <form action="/addAttribute" method="post" id="proxy_add_group">
        <@se.input_hidden
            name = "path"
            value = path
        />

        <@se.input_hidden
            name = "attr_group_id"
            value = attr_group.id
        />

        <@se.select_element
            element_name = "attr_name"
            element_id = "attribute_id"
            label = "Attribute"
            placeholder = "Insert attribute"
            elements_array = attr_dic
            elements_attr = "name"
        />

        <@se.button_send
            button_name = "Add attribute"
        />
    </form>



<#list  attr_group.attributes as agt>
        <ul>
            <li>${agt.attributeDictionary.name}
                <#if agt.attributeValue??>
                -- ${agt.attributeValue.attributeValueDictionary.name}
                    <#if agt.unit?? &&
                    agt.unit.unitDictionary.name != "<none>">
                        ${agt.unit.unitDictionary.name}
                    </#if>
                </#if>
                <a href="/proxy/${proxy.id}/${attr_group.id}/${agt.id}">View</a>
            </li>
        </ul>
    </#list>
</@c.page>
