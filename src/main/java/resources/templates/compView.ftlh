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

    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" data-toggle="tab" href="#elements_source">Содержит элементы</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#elements_destination">Элемент для</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#characteristics">Характеристики</a>
        </li>
    </ul>
    <div class="tab-content">
        <div class="tab-pane fade show active" id="element_source">
            <ul class="nav nav-tabs">
                <#list elem_destination as ed>
                    <li class="nav-item">
                        <a href="/element/view/${ed[2]!}">${ed[3]!}</a>
                        <span>${(ed[5])!"none"}</span>
                    </li>
                <#else>
                    <li>Нет элементов</li>
                </#list>
            </ul>
        </div>
        <div class="tab-pane fade" id="element_destination">
            <ul>
                <#list elem_source as es>
                    <li>
                        <a href="/element/view/${es[2]!}">${es[3]!}</a>
                        <span>${(es[5])!"none"}</span>
                    </li>
                <#else>
                    <li>Нет оборудования</li>
                </#list>
            </ul>
        </div>
        <div class="tab-pane fade" id="charackteristics">
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
        </div>
    </div>

    <span>Группы : </span>
    <ul class="nav nav-tabs">
        <#list elem.groups as g>
            <li class="nav-item">
                <a href="/element/${g.id}">${g.groupName}</a>
            </li>
        <#else>
            <li>Группы не найдены</li>
        </#list>
    </ul>

</@c.page>