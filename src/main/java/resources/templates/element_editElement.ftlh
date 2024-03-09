<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>
    <#assign path = "/element/edit/${elem.id}" />
    <a href="/element/view/${elem.id}">View Element</a>

    <@se.header_1 title = "Edit ${elem.name}" />

    <@se.header_3 title = "Element characteristik" />

    <form action="changeElementName" method="post"
          id="changeElemId">

        <@se.input_hidden
            name = "path"
            value = path
        />

        <@se.input_hidden
            name = "element_id"
            value = elem.id
        />

        <@se.input_element
            element_name = "element_name"
            element_id = "element_name_id"
            label = "Element name"
            placeholder = "Insert name of Element"
        />

        <@se.button_send
            button_name = "Change element name"
        />
    </form>

    <form action="changeElementCategory" method="post" id="change_element_category_id">
    <@se.input_hidden
        name = "path"
        value = path
    />

    <@se.input_hidden
        name = "element_id"
        value = elem.id
    />

    <@se.select_element
        element_name = "element_category"
        element_id = "element_category_id"
        label = "Category"
        placeholder = "Insert element category"
        elements_array = element_category
        elements_attr = ""
    />

    <@se.button_send
        button_name = "Change Element category"
    />
    </form>

    <form action="changeElementType" method="post" id="changeProxyNameId">
    <@se.input_hidden
        name = "path"
        value = path
    />

    <@se.input_hidden
        name = "element_id"
        value = elem.id
    />

    <@se.select_element
        element_name = "element_type"
        element_id = "element_type_id"
        label = "Type"
        placeholder = "Insert element type"
        elements_array = element_type
        elements_attr = "type"
    />

    <@se.button_send
        button_name = "Change Element type"
    />
    </form>

    <form action="changeElementDescription" method="post" id="changeProxyDescription">
    <@se.input_hidden
        name = "path"
        value = path
    />

    <@se.input_hidden
        name = "element_id"
        value = elem.id
    />

    <@se.description />

    <@se.button_send
        button_name = "Change description"
    />
    </form>


    <@se.header_3 title = "Proxy characteristik" />

    <form action="link_elements" method="post" id="link_elements">

        <@se.input_hidden
            name = "path"
            value = path
        />

        <input type="text"
               name="element_source_id"
               value="${elem.id}"
               hidden="hidden" />

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

        <@se.input_hidden
            name = "path"
            value = path
        />

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
            value = path
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

    <a href="/proxy">Edit Proxy</a><br/>

    <b>${elem.name}</b><br/>
    <span>Category: ${elem.category}</span><br/>
    <span>Type: ${elem.elementType.type}</span><br/>
    <span>Description: ${elem.description}</span><br/>

</@c.page>