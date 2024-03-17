<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as f>

<@c.page>

    <@se.header_1
        title = "Оборудование"
    />
    <a href="/storage/goods">Товары</a>

<form action="/storage/equipment/add_equipment" method="post" id="equip">

    <@se.select_list_element
        element_name = "goods_name"
        label = "Goods name"
        >
        <#list goods_name as gn>
            <option>${gn}</option>
        <#else>
            <option>&ltnone&gt</option>
        </#list>
    </@se.select_list_element>

    <@se.select_element
            element_name = "condition_name"
            element_id = "condition_id"
            label = "Condition"
            placeholder = "Insert condition of element"
            elements_array = conditions
            elements_attr = "name"
            />

    <div class="form-group row justify-content-center">
        <div class="col-sm-2">
            <label for="inventory_number" class="col-form-label">Inventory number : </label>
        </div>
        <div class="col-sm-1">
                <select class="form-control" id="inv_number_prefix_name_id" name="inv_number_prefix">
                    <#list inv_number_prefix as inp>
                        <#if inp??>
                            <option>${inp.prefix}</option>
                        </#if>
                    <#else>
                        <option>&ltnone&gt</option>
                    </#list>
                </select>
        </div>

        <div class="col-sm-5">
            <div class="input-group">
                <input type="text"
                       name="inventory_number"
                       class="form-control"
                       placeholder="Inventory number"
                       aria-label="Inventory number"
                       aria-describedby="basic-addon1"/>
            </div>
        </div>
    </div>

    <@se.input_element
            element_name = "barcode"
            element_id = "barcode_id"
            label = "Barcode"
            placeholder = "Input barcode"
            />

    <@se.description />

    <@se.button_send
            button_name = "Add Equipment"
            />

</form>


<@ce.table_input
        table_head = ["id", "Инв. номер", "Модель", "Состояние", "Поставить в ремонт"]
    >

        <#list goods_equipment as ge>
            <tr>
                <td>${ge.id!"none"}</td>
                <td>${ge.inventoryNumber!"none"}</td>
                <td>${ge.good.name!"none"}</td>
                <td>${ge.condition.name!"none"}</td>
                <td>
                    <div>
                        <@f.form
                            id = "btnRepairId"
                            action = "/storage/goods/in_repair"
                            method = "post"
                        >
                            <input type="number" name="elem_id"  value=${ge.id} hidden="hidden" />
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
