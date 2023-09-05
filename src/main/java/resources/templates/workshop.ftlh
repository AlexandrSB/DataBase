<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page>
<@se.header_1
        title = "Workshop"
        />

<form action="/storage/workshop/add_workshop" method="post" id="add_workshop_id">

    <@se.input_element
        element_name = "workshop_name"
        element_id = "workshop_name_id"
        label = "Name"
        placeholder = "Input workshop name"
    />

    <@se.description />

    <@se.button_send
        button_name = "Add workshop"
    />

</form>

<@ce.table_element
        table_head = ["Name", "Description"]
        table_body = workshops
        table_columns = ["name", "description"]
        />

        </@c.page>
