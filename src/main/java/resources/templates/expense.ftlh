<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page>

    <@se.header_1
        title = "Расход товара"
    />

    <@se.select_element
        element_name = "good_name"
        element_id = "good_name_id"
        label = "Good"
        placeholder = "Insert good name"
        elements_array = goods_names!["none"]
        elements_attr = ""
    />

    <@se.select_element
        element_name = "proxy_name"
        element_id = "proxy_name_id"
        label = "Characteristik"
        placeholder = "Choise characteristik"
        elements_array = proxies!["none"]
        elements_attr = "name"
    />

    <@se.select_element
        element_name = "storage_name"
        element_id = "storage_name_id"
        label = "Storage"
        placeholder = "Insert storage name"
        elements_array = storages!["none"]
        elements_attr = "name"
    />

    <@se.select_element
        element_name = "workshop_name"
        element_id = "workshop_name_id"
        label = "Workshop"
        placeholder = "Insert workshop name"
        elements_array = workshops!["none"]
        elements_attr = "name"
    />

    <div class="row p-3">
        <#list goods_names as g>
            <@ce.card_element_1
                title_1 = g
                title_2 = g
                text = ["This is a goods card"]
                href_1 = "#"
                href_1_name = "Persistent"
            />
        <#else>
            none
        </#list>
    </div>

</@c.page>
