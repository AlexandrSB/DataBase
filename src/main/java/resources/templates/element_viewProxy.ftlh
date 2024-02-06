<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>
<@se.header_1
        title = proxy.name
        />


    <form action="proxy_addGroup" method="post" id="proxy_add_group">
        <@se.select_element
            element_name = "attribute_groups_name"
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
            <span>${ag.name} </span>
            <a href="/proxy/${proxy.id}/${ag.id}">View</a>
        </li>
        <#list ag.attributes as agt>
            <ul>
                <li>${agt.name} -- ${agt.attributeValue.name}
                    <#if agt.attributeValue.unit.unitDictionary.name != "<none>">
                        ${agt.attributeValue.unit.unitDictionary.name}
                    </#if>
                </li>
            </ul>
        </#list>
    </ul>
    </#list>

</@c.page>