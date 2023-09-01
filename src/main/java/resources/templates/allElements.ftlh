<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page "Elements">

    <@ce.table_link_element
        table_head = ["Element name", "Description", "Type", "Link"]
        table_body = elements
        table_columns = ["name", "description", "elementType"]
        link = "/element/view/"
        link_link = "id"
        link_name = "view"
    />

</@c.page>
