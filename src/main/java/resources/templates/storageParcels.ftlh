<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page>

    <@se.header_1
        title = "Расходники"
    />



    <@ce.table_input
        table_head = ["id", "name", "category"]
    >

        <#list goods_not_equipment as g>
            <tr>
                <td><span>${g.id!"none"}</span></td>
                <td><span>${g.name!"none"}</span></td>
                <td><span>${g.category!"none"}</span></td>
            </tr>
        <#else>
            <tr>
                <td><span>&ltnone&gt</span></td>
                <td><span>&ltnone&gt</span></td>
                <td><span>&ltnone&gt</span></td>
            </tr>
        </#list>

    </@ce.table_input>

</@c.page>