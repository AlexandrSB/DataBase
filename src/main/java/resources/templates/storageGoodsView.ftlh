<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as f>

<@c.page>

    <@se.header_1
        title = "Вид товара"
    />


    <@ce.table_input
        table_head = ["id", "Инв. номер", "Модель", "Состояние", "Поставить в ремонт"]
    >

        <#list goods_view as gv>
            <tr>
                <td>${gv.id!"none"}</td>
                <td>${gv.inventoryNumber!"none"}</td>
                <td>${gv.good.name!"none"}</td>
                <td>${gv.condition.name!"none"}</td>
                <td>
                    <div>
                        <@f.form
                            id = "btnRepairId"
                            action = "in_repair"
                            method = "post"
                        >
                            <input type="number" name="elem_id"  value=${gv.id} hidden="hidden" />
                            <button class="btn btn-sm btn-primary" type="submit">В ремонт</button>
                        </@f.form>
                    </div>
                </td>
            </tr>
        <#else>
            <tr>
                <td>none</td>
            </tr>
        </#list>

    </@ce.table_input>
</@c.page>
