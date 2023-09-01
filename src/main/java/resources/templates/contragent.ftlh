<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page>
    <@se.header_1
        title = "Contragent"
    />

    <form action="/storage/contragent/add_contragent" method="post" id="contrnt">

        <@se.input_element
            element_name = "contragent_name"
            element_id = "contragent_name_id"
            label = "Name"
            placeholder = "Input contragents name"
        />

        <@se.description />

        <@se.button_send
            button_name = "Add contragent"
        />

    </form>

    <@ce.table_element
        table_head = ["Name", "Description"]
        table_body = contragents
        table_columns = ["name", "description"]
    />

</@c.page>
