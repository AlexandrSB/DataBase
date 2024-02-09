<#import "parts/common.ftlh" as c>
<#import "parts/constructor/composite_element.ftlh" as ce>
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/forms.ftlh" as f />


<@c.page>

    <div>
        <@se.header_2
            title = "Оборудование в ремонте"
        />

        <div class="row">
            <@ce.card_element_2
                title_1 = "Ремонт"
                title_2 = "Оборудование в ремонте"
                href_1 = "/workshop/repair"
                href_1_name = "Ремонт"
            >
                <#list in_repairs as ir>
                    <p>${ir.workshopElement.inventoryNumber} -- name
                        <a href="/workshop/repair_card/${ir.id}">card</a>
                    </p>
                <#else>
                    <p>&ltnone&gt</p>
                </#list>

            <form action="workshop/take_elements" method="post" id="tacke_elements_id">

                <@se.input_hidden
                    name = "path"
                    value = "/workshop"
                />

            <button class="btn btn-primary" type="submit">Take element</button>
            </form>

            </@ce.card_element_2>

            <@ce.card_element_2
                title_1 = "Диагностика"
                title_2 = "Оборудование на диагностике"
                href_1 = "/workshop/diagnostics"
                href_1_name = "Диагностика"
            >

                <#list in_diagnostics as id>
                    <p>${id["inventoryNumber"]} -- ${id["good"].name}</p>
                <#else>
                    <p>&ltnone&gt</p>
                </#list>

            </@ce.card_element_2>

            <@ce.card_element_2
                title_1 = "Чистка"
                title_2 = "Оборудование на чистке"
                href_1 = "/workshop/clearing"
                href_1_name = "Чистка"
            >

                <#list in_clearing as ic>
                    <p>${ic["inventoryNumber"]} -- ${ic["good"].name}</p>
                <#else>
                    <p>&ltnone&gt</p>
                </#list>

            </@ce.card_element_2>

        </div>

        <div>
            <@se.header_2
                title = "Оборудование в ожидании ремонта"
            />

            <@ce.table_input
                table_head = ["id", "Инв. номер", "Модель", "Ремонт", "Диагностика", "Чистка", "Ссыль"]
            >

                <#list awaiting_repairs as ar>
                    <tr>
                        <td>${ar.id!"none"}</td>
                        <td>${ar.inventoryNumber!"none"}</td>
                        <td>${ar.good.name!"none"}</td>
                        <td>
                            <div class="row">
                                <@f.form
                                id = "btnRepairId"
                                action = "workshop/set_repair"
                                method = "post"
                                >
                                    <div class="col">
                                        <@se.select_list_element
                                        element_name = "repair_type"
                                        label = "Тип ремонта"
                                        >
                                            <#list repair_types as rt>
                                                <option>${rt}</option>
                                            </#list>

                                        </@se.select_list_element>
                                    </div>
                                    <input type="number" name="elem_id"  value=${ar.id} hidden="hidden" />
                                    <button class="btn btn-sm btn-primary" type="submit">В ремонт</button>
                                </@f.form>
                            </div>
                        </td>
                        <td>
                            <div>
                                <@f.form
                                    id = "btnRepairId"
                                    action = "workshop/set_diagnostic"
                                    method = "post"
                                >
                                    <input type="number" name="elem_id"  value=${ar.id} hidden="hidden" />
                                    <button class="btn btn-sm btn-primary" type="submit">На диагностику</button>
                                </@f.form>
                            </div>
                        </td>
                        <td>
                            <div>
                                <@f.form
                                id = "btnRepairId"
                                action = "workshop/set_clearing"
                                method = "post"
                                >
                                    <input type="number" name="elem_id"  value=${ar.id} hidden="hidden" />
                                    <button class="btn btn-sm btn-primary" type="submit">В чистку</button>
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
        </div>
    </div>

</@c.page>
