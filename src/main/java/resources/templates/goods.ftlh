<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page>

    <@se.header_1
        title = "Товары"
    />

    <form action="/storage/goods/add_goods" method="post" id="equip">

        <@se.select_element
            element_name = "element_name"
            element_id = "element_name_id"
            label = "Element"
            placeholder = "Insert element name"
            elements_array = elements
            elements_attr = "name"
        />

        <@se.select_element
            element_name = "condition_name"
            element_id = "condition_id"
            label = "Condition"
            placeholder = "Insert condition of element"
            elements_array = conditions
            elements_attr = "name"
        />

        <@se.input_element
            element_name = "inventory_number"
            element_id = "inventory_number_id"
            label = "Inventory number"
            placeholder = "Input inventory number"
        />

        <@se.input_element
            element_name = "barcode"
            element_id = "barcode_id"
            label = "Barcode"
            placeholder = "Input barcode"
        />

        <@se.description />

        <@se.button_send
            button_name = "Add good"
        />

    </form>


    <@ce.table_element
            table_head = ["id", "Name", "Condition", "Type"]
            table_body = mapOfGoods
            table_columns = ["id", "name", "condition", "type"]
    />

</@c.page>