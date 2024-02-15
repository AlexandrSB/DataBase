<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/componentParts.ftlh" as cp />

<@c.page>
    <#assign path = "/proxy">

    <@se.header_1
        title = "Proxy"
        />


    <form action="addProxy" method="post" id="addProxyId">
        <@se.input_hidden
            name = "path"
            value = path
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

    <form action="addAttrGroupName" method="post" id="addAttrGroupId">
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

    <form action="addAttrName" method="post" id="addAttrId">
        <@se.input_hidden
            name = "path"
            value = path
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
            value = path
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

    <br />
    <span>Прокси : </span>
    <@cp.proxies_table />

</@c.page>