<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as fm>


<@c.page>

    <@se.header_1
        title = "Приход товара"
    />

    <@ce.table_input
        table_head = ["Name", "Condition"]
    >
        <#list goods as goods>
            <tr>
                <td>${goods.name}</td>
                <td>${goods.condition.name}</td>
            </tr>
        </#list>
    </@ce.table_input>

    <@se.select_element
        element_name = "storage_name"
        element_id = "storage_name_id"
        label = "Storage"
        placeholder = "Insert storage name"
        elements_array = storages
        elements_attr = "name"
    />

    <@se.select_element
        element_name = "contragent_name"
        element_id = "contragent_name_id"
        label = "Contragent"
        placeholder = "Insert contragent name"
        elements_array = contragents
        elements_attr = "name"
    />

</@c.page>