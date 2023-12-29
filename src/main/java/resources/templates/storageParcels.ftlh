<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page>

    <@se.header_1
        title = "Расходники"
    />

    <@se.select_list_element
        element_name = "element_name"
        label = "Parcels"
    >
        <#list parcelsWithGoods as p>
            <option>${p}</option>
        <#else>
            <option>&ltnone&gt</option>
        </#list>
    </@se.select_list_element>

    <@ce.table_input
        table_head = ["id", "name", "view"]
    >

        <tr>
            <#list parcelsWithGoods as p>
                <td><span>${p.id!"none"}</span></td>
                <td><span>${p.good.name!"none"}</span></td>
            <#else>
                <td><span>&ltnone&gt</span></td>
                <td><span>&ltnone&gt</span></td>
            </#list>
        </tr>

    </@ce.table_input>

</@c.page>