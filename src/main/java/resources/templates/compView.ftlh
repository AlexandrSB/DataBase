<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>

    <h1 class="text-center">${elem.name}</h1>

    <form action="link_elements" method="post" id="link_elements">

        <input type="text" name="thisElement" value="${elem.id}" hidden="hidden" />

        <@se.select_element
            element_name = "elementName"
            element_id = "my_id"
            label = "Component"
            placeholder = "Component Name"
            elements_array = elements
            elements_attr = "name"
        />

        <@se.button_send
            button_name = "Add equipment"
        />

    </form>

    <#list elem.groups as g>
        <span>Группы : </span>
        <ul>
            <li>
                <a href="/element/${g.id}">${g.groupName}</a>
            </li>
        </ul>
    <#else>
        <span>Группы не найдены</span>
    </#list>

    <br />
    <span>Содержит элементы : </span>
    <#list elem.elements_source as es>
        <ul>
            <li>
                <a href="/element/view/${es.id}">${es.name}</a>
            </li>
        </ul>
    <#else>
        <span>Нет элементов</span>
    </#list>

    <br />
    <span>Элемент для : </span>
    <#list elem.elements_destination as ed>
            <ul>
                <li>
                    <a href="/element/view/${ed.id}">${ed.name}</a>
                </li>
            </ul>
        <#else>
            <span>Нет оборудования</span>
    </#list>

</@c.page>