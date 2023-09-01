<#import "parts/common.ftlh" as c>
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />


<@c.page>

    <@se.header_1
        title = "Склад"
    />

    <form action="add_storage" method="post" id="equip">

        <@se.input_element
            element_name = "storage_name"
            element_id = "storage_id"
            label = "Storage"
            placeholder = "Input storages name"
        />

        <@se.description />

        <@se.button_send
            button_name = "Add storage"
        />

    </form>


    <@ce.table_element
        table_head = ["Name", "Description"]
        table_body = storages
        table_columns = ["name", "description"]
    />
</@c.page>