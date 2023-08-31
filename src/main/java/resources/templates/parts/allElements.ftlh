<#import "parts/common.ftlh" as c />
<#import "parts/componentParts.ftlh" as cp />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page "Elements">
    <@cp.componentTable />

    <@ce.table_element
        table_head = ["Element name", "Description", "Groups"]
        table_body = elements
        />
</@c.page>
