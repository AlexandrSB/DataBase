<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>
    <br />

    <form action="addProxy" method="post" id="addProxy">

    <@se.select_element
        element_name = "firma"
        element_id = "firma"
        label = "Firma"
        placeholder = "Select firm"
        elements_array = firms
        elements_attr = "firmName"
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

    <form action="proxy_addAttribute" method="post" id="proxy_add_attributes">

    <@se.select_element
        element_name = "proxy_name"
        element_id = "proxy_name_selected"
        label = "Proxy"
        placeholder = "Select proxy"
        elements_array = proxies
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
        element_name = "unit_name"
        element_id = "unit_id"
        label = "Unit"
        placeholder = "Units"
        elements_array = units
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
            <ul>
                <#list pr.attributeValues as av>
                    <span>${av.attribute.name} - ${av.name}${av.workshopUnit.name}; </span>
                </#list>
            </ul>
        </li>
        <#else>
        <li>Аттрибутов нет</li>
        </#list>
    </ul>
</@c.page>