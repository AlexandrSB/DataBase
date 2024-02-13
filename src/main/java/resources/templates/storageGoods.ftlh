<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as f/>

<@c.page>

    <@se.header_1
        title = "Товары"
    />

    <a href="/storage/parcel">Расходники</a>
    <a href="/storage/equipment">Оборудование</a>

    <@f.form_button
        id = "form_equipment_id"
        action = "exportEquipment"
        method = "post"
        button_name = "Export Equipment"
        >
    </@f.form_button>

    <@ce.table_link_element
            table_head = ["id", "Name", "View"]
            table_body = goods
            table_columns = ["id", "name"]
            link = "/storage/goods/"
            link_link = "id"
            link_name = "view"
    />

</@c.page>