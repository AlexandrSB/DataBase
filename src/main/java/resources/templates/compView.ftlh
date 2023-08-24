<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>

    <h1 class="text-center">${elem.name}</h1>

    <form action="link_elements" method="post" id="link_elements">

        <input type="text" name="thisElement" value="${elem.id}" hidden="hidden" />

        <@se.select_element
            element_name = "elementName"
            element_id = "element_id"
            label = "Component"
            placeholder = "Component Name"
            elements_array = elements
            elements_attr = "name"
        />

        <@se.button_send
            button_name = "Add equipment"
        />

    </form>

    <form action="add_attribute" method="post" id="add_attributes">

    <input type="text" name="thisElement" value="${elem.id}" hidden="hidden" />

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

    <span>Группы : </span>
    <ul>
        <#list elem.groups as g>
                <li>
                    <a href="/element/${g.id}">${g.groupName}</a>
                </li>
        <#else>
            <li>Группы не найдены</li>
        </#list>
    </ul>

    <br />
    <span>Содержит элементы : </span>
    <ul>
        <#list elem.elements_source as es>
                <li>
                    <a href="/element/view/${es.id}">${es.name}</a>
                </li>
        <#else>
            <li>Нет элементов</li>
        </#list>
    </ul>

    <br />
    <span>Элемент для : </span>
    <ul>
        <#list elem.elements_destination as ed>
                <li>
                    <a href="/element/view/${ed.id}">${ed.name}</a>
                </li>
        <#else>
            <li>Нет оборудования</li>
        </#list>
    </ul>

    <br />
    <span>Аттрибуты : </span>
    <ul>
        <#list attributeValues as av>
                <li>
                    <span>${av.attribute.name} ${av.name} ${av.unit.name}</span>
                </li>
        <#else>
            <li>Аттрибутов нет</li>
        </#list>
    </ul>
</@c.page>