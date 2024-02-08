<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>
    <#assign path = "/proxy/${proxy.id}">
    <#include "parts/navbar/navbar_proxy_breadcramb.ftlh" />

    <@se.header_1
        title = proxy.name
        />


    <form action="/addAttrGroupName" method="post" id="addAttrGroupId">
        <@se.input_hidden
            name = "path"
            value = path
        />

        <@se.input_element
            element_name = "attribute_group_name"
            element_id = "attribute_group_id"
            label = "Attribute group name"
            placeholder = "Insert name of attribute group"
        />

        <@se.button_send
            button_name = "Add attribute group"
        />
    </form>

    <form action="/addAttributeGroup" method="post" id="proxy_add_group">
        <@se.input_hidden
            name = "path"
            value = "/proxy/${proxy.id}"
        />

        <@se.input_hidden
            name = "proxy_id"
            value = "${proxy.id}"
        />

        <@se.select_element
            element_name = "attribute_group_name"
            element_id = "attribute_groups_id"
            label = "Attribute groups"
            placeholder = "Insert attribute groups"
            elements_array = attr_groups
            elements_attr = "name"
        />

        <@se.button_send
            button_name = "Add Group"
        />
    </form>


<#list proxy.attributeGroups as ag>
    <ul>
        <li>
            <span>${ag.attributeGroupDictionary.name} </span>
            <a href="/proxy/${proxy.id}/${ag.id}">View</a>
        </li>
        <#list ag.attributes as agt>
            <ul>
                <li>${agt.attributeDictionary.name}
                    <#if agt.attributeValue??>
                        -- ${agt.attributeValue.attributeValueDictionary.name}
                        <#if agt.unit?? &&
                                agt.unit.unitDictionary.name != "<none>">
                            ${agt.unit.unitDictionary.name}
                        </#if>
                    </#if>
                </li>
            </ul>
        </#list>
    </ul>
    </#list>

</@c.page>