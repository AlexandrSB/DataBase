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

    <br />
    <span>Прокси : </span>

    <@cp.proxies_table />

</@c.page>