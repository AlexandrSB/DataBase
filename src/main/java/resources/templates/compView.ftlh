<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>

    <@se.header_1 title = elem.name />

    <form action="link_elements" method="post" id="link_elements">

        <input type="text" name="element_source_id" value="${elem.id}" hidden="hidden" />

        <@se.select_element
            element_name = "element_destination"
            element_id = "element_id"
            label = "Component"
            placeholder = "Component Name"
            elements_array = elements
            elements_attr = "name"
        />

        <@se.select_element
            element_name = "proxy_name"
            element_id = "proxy_id"
            label = "Proxy of component"
            placeholder = "Proxy Name"
            elements_array = proxies
            elements_attr = "name"
        />

        <@se.button_send
            button_name = "Add equipment"
        />

    </form>

    <form action="add_attribute" method="post" id="add_attributes">

    <input type="text"
           name="thisElementId"
           value="${elem.id}"
           hidden="hidden"
    />

    <@se.select_element
        element_name = "proxy_name"
        element_id = "proxy_name"
        label = "Proxy select"
        placeholder = "Insert proxy name"
        elements_array = proxies_select
        elements_attr = "name"
    />

    <@se.button_send
        button_name = "Add proxy"
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
        <#list elem_destination as ed>
            <li>
                <a href="/element/view/${ed.id}">${ed.name}</a>
                <span>${(ed.proxy.name)!"none"}</span>
            </li>
        <#else>
            <li>Нет элементов</li>
        </#list>
    </ul>

    <br />
    <span>Элемент для : </span>
    <u>
        <#list elem_source as es>
            <li>
                <a href="/element/view/${es.id}">${es.name}</a>
                <span>${(es.proxy.name)!"none"}</span>
            </li>
        <#else>
            <li>Нет оборудования</li>
        </#list>
    </ul>

    <br />
    <span>Аттрибуты : </span>
    <ul>
        <#list proxies as p>
            <li>
                <#if p.firma??>
                    <span>${p.firma.firmName}</span>
                </#if>
                <#list p.attributeValues as pV>
                    <span>${pV.attribute.name} - ${pV.name} ${pV.unit.name}<#sep>; </span>
                <#else>
                    <li></li>
                </#list>
            </li>
        <#else>
            <li>Аттрибутов нет</li>
        </#list>
    </ul>
</@c.page>