<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>
    <br />
    <@se.header_1
        title = "Proxy"
        />


    <form action="addProxy" method="post" id="addProxyId">
        <@se.input_hidden
            name = "path"
            value = "/proxy"
        />

    <@se.input_element
            element_name = "proxy_name"
            element_id = "proxy_name"
            label = "Proxy name"
            placeholder = "Insert name of proxy"
        />

        <@se.button_send
            button_name = "Add proxy"
        />
    </form>

    <form action="addAttrGroup" method="post" id="addAttrGroupId">
        <@se.input_hidden
            name = "path"
            value = "/proxy"
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

    <form action="addAttr" method="post" id="addAttrId">
        <@se.input_hidden
            name = "path"
            value = "/proxy"
        />

        <@se.input_element
            element_name = "attribute_name"
            element_id = "attribute_id"
            label = "Attribute name"
            placeholder = "Insert name of attribute"
        />

        <@se.button_send
            button_name = "Add attribute"
        />
    </form>

    <form action="addUnit" method="post" id="addUnitId">
        <@se.input_hidden
            name = "path"
            value = "/proxy"
        />

        <@se.input_element
            element_name = "unit_name"
            element_id = "unit_id"
            label = "Unit name"
            placeholder = "Insert unit name"
        />

        <@se.button_send
            button_name = "Add unit"
        />
    </form>



    <form action="proxy_addAttribute" method="post" id="proxy_add_attributes">
        <@se.input_hidden
            name = "path"
            value = "/proxy"
        />

        <@se.select_element
            element_name = "proxy_name"
            element_id = "proxy_name_selected"
            label = "Proxy"
            placeholder = "Select proxy"
            elements_array = proxies
            elements_attr = "name"
        />

        <@se.select_element
            element_name = "attribute_groups_name"
            element_id = "attribute_groups_id"
            label = "Attribute groups"
            placeholder = "Insert attribute groups"
            elements_array = attr_groups
            elements_attr = "name"
        />

        <@se.select_element
            element_name = "attribute_name"
            element_id = "attribute_id"
            label = "Attribute"
            placeholder = "Insert attribute"
            elements_array = attributes
            elements_attr = "name"
        />

        <@se.input_element
            element_name = "attribute_value"
            element_id = "attribute_value"
            label = "Value"
            placeholder = "Insert attribute value"
        />

        <@se.select_element
            element_name = "unit_dic_name"
            element_id = "unit_dic_id"
            label = "Unit dict"
            placeholder = "Units"
            elements_array = unit_dic
            elements_attr = "name"
        />

        <@se.button_send
            button_name = "Add attribute"
        />

    </form>


    <br />
    <span>Прокси : </span>
    <ul>
        <#list proxies as pr>
        <li>
            <span>${pr.name}</span>
            <a href="/proxy/${pr.id}">View</a>
            <ul>
                <#list pr.attributeGroups as ag>
                    <li><i>${ag.name}</i></li>
                    <ul>
                        <#list ag.attributes as agt>
                            <li>${agt.name} -- ${agt.attributeValue.name}
                                <#if agt.attributeValue.unit.unitDictionary.name != "<none>">
                                    ${agt.attributeValue.unit.unitDictionary.name}
                                </#if>
                            </li>
                        </#list>
                    </ul>
                </#list>
            </ul>
        </li>
        <#else>
        <li>Аттрибутов нет</li>
        </#list>
    </ul>
</@c.page>