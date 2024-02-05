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
            button_name = "Add owner"
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


    <form action="/addProxy" method="post" id="addProxyId">
        <@se.input_hidden
            name = "path"
            value = "/element/view/" + elem.id
        />

        <@se.input_element
            element_name = "proxy_name"
            element_id = "proxy_name_id"
            label = "Proxy name"
            placeholder = "Input proxy name"
        />

        <@se.button_send
            button_name = "Create proxy"
        />
    </form>

<a href="/proxy">Edit Proxy</a></br>


    <span>Группы : </span>
    <ul class="nav nav-tabs">
        <#list elem.groups as g>
            <li class="nav-item">
                <a href="/element/${g.id}">${g.name}</a>
            </li>
        <#else>
            <li>Группы не найдены</li>
        </#list>
    </ul>


        <!-- Nav tabs -->
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active"
                    id="home-tab"
                    data-bs-toggle="tab"
                    data-bs-target="#source"
                    type="button" role="tab"
                    aria-controls="home"
                    aria-selected="true"
            >Содержит элементы</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link"
                    id="profile-tab"
                    data-bs-toggle="tab"
                    data-bs-target="#destination"
                    type="button" role="tab"
                    aria-controls="profile"
                    aria-selected="false"
            >Элемент для</button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link"
                    id="messages-tab"
                    data-bs-toggle="tab"
                    data-bs-target="#characterisic"
                    type="button"
                    role="tab"
                    aria-controls="messages"
                    aria-selected="false"
            >Характеристки</button>
        </li>
    </ul>

        <!-- Tab panes -->
<div class="tab-content">
    <div class="tab-pane active"
         id="source"
         role="tabpanel"
         aria-labelledby="home-tab">
        <ul>
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
    <div class="tab-pane"
         id="destination"
         role="tabpanel"
         aria-labelledby="profile-tab">
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
    <div class="tab-pane"
         id="characteristic"
         role="tabpanel"
         aria-labelledby="messages-tab">
        <ul>
            <#list proxies as p>
                <li>
                    <#list p.attributeGroups as ag>
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

</@c.page>