<#import "parts/common.ftlh" as c>
<#import "parts/constructor/composite_element.ftlh" as ce>
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/forms.ftlh" as f />


<@c.page>

    <@se.header_2
        title = "Оборудование в ожидании ремонта"
    />

    <a href="/workshop">Оборудование в ремонте</a>

    <@ce.table_input
        table_head = ["id", "Инв. номер", "Модель", "Ремонт", "Ссыль"]
    >

    <#list awaiting_repairs as ar>
    <tr>
        <td>${ar.id!"none"}</td>
        <td>${ar.prefixInventoryNumber.prefix}${ar.inventoryNumber!"none"}</td>
        <td>${ar.good.name!"none"}</td>
        <td>
            <div class="row">
                <@f.form
                id = "btnRepairId"
                action = "workshop/set_repair"
                method = "post"
                >
                    <div class="form-group row justify-content-left">
                        <div class="col-sm-4">
                            <select class="form-control" id=${element_name!"default_id"}_id name=${element_name!"default_name"}>
                                <#list repair_types as rt>
                                    <option>${rt}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <input type="number" name="elem_id"  value=${ar.id} hidden="hidden" />
                            <button class="btn btn-sm btn-primary" type="submit">В ремонт</button>
                        </div>
                    </div>
                </@f.form>
            </div>
        </td>
        <td>
        <a href="#">View</a>
        </td>
    </tr>
    <#else>
    <tr>
        <td>none</td>
    </tr>
    </#list>

    </@ce.table_input>

</@c.page>
