<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as f>

<@c.page>

    <@se.header_1
        title = "Ремонт комплектующих"
        />

    <@se.header_2
        title = workshop_module.name
        />

    <@se.header_3
        title = "Вид ремонта: " + repair_card.repairType
        />

    <#if elements_destination[0][1]?has_content>
        <ul>
            <#list elements_destination as ed>
                <li>
                    <a href="/workshop/repair_card/${repair_card.id}/${ed[1].id}">Ремонт модуля -- ${ed[1].name!"none"}</a>
                </li>
            <#else>
                <li>
                    <span>none</span>
                </li>
            </#list>
        </ul>
    </#if>

    <div>
        <div id="accordion">
            <div class="card">
                <div class="card-header" id="headingOne">
                    <h5 class="mb-0">
                        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                            Выполненные работы
                        </button>
                    </h5>
                </div>

                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                        <form class="row g-6" action="/repair_notation/add_operation" method="post">
                            <@se.input_hidden
                                name = "repair_card_id"
                                value = repair_card.id
                                />

                            <@se.input_hidden
                                name = "unit_id"
                                value = unit.id
                                />

                            <div class="row justify-content-start">
                                <div class="col-3">
                                    <label for="input_repair_notation_id" class="visually-hidden">Добавить операцию</label>
                                    <input type="text" class="form-control" id="input_repair_notation_id" name="repair_notation_name" placeholder="Добавить операцию" />
                                </div>

                                <#if elements_proxy?has_content>
                                    <div class="col-3">
                                        <select class="form-control" id="proxy_id" name="proxy_name">
                                            <option>&ltnone&gt</option>
                                            <#if elements_proxy??>
                                                <#list elements_proxy as e>
                                                    <#if e??>
                                                        <option>${e.name}</option>
                                                    </#if>
                                                <#else>
                                                    <option>&ltnone&gt</option>
                                                </#list>
                                            </#if>
                                        </select>
                                    </div>
                                </#if>

                                <#if operation_type?has_content>
                                    <div class="col-3">
                                        <select class="form-control" id="operation_type_name" name="operation_type_name">
                                            <#if operation_type??>
                                                <#list operation_type as ot>
                                                    <#if ot??>
                                                        <option>${ot}</option>
                                                    </#if>
                                                <#else>
                                                    <option>&ltnone&gt</option>
                                                </#list>
                                            </#if>
                                        </select>
                                    </div>
                                </#if>

                                <div class="col-2">
                                    <button type="submit" class="btn btn-primary mb-3">Add</button>
                                </div>

                            </div>
                        </form>

                        <form class="row g-6" action="/repair_notation/check_operation" method="post">
                            <@se.input_hidden
                                name = "repair_card_id"
                                value = repair_card.id
                                />

                            <@se.input_hidden
                                name = "unit_id"
                                value = unit.id
                                />

                            <div class="row col-auto">
                                <#list completed_works as cw>
                                    <div class="form-check form-switch">
<!--                                     <!-- //TODO my_checkboxes разделить на "выполненные работы" и "количество запчастей" -->
                                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault" name="my_checkboxes" value=${cw.id}>
                                        <label class="form-check-label" for="flexSwitchCheckDefault">${cw.notation!"none"}</label>
                                    </div>
                                    <div class="col-auto">
                                        <input type="text" class="form-control" id="quantity" name="my_checkboxes" placeholder="Количество" value="0"/>
                                    </div>
                                </#list>
                            </div>

                            <div class="col-sm-2">
                                <button type="submit" class="btn btn-primary mb-3">Write</button>
                            </div>
                        </form>

                        <ul>
                            <#if elements_proxy??>
                                <#list elements_proxy as p>
                                    <#if p??>
                                        <li>proxy: ${p}</li>
                                    </#if>
                                <#else>
                                    <li>&ltnone&gt</li>
                                </#list>
                            </#if>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <div>
            <@ce.table_input
                table_head = ["Operation type", "Spare part", "Quantity"]
                >
            <#list consumption_of_materials as com>
                <tr>
                    <td>
                        <span>${com[1].notation!"none"}</span>
                    </td>
                    <td>
                        <#assign type_of_spare_part=com[1].typeOfSparePart>
                        <span>${com[1].typeOfSparePart!"none"}</span>
                    </td>
                    <td>
                        <span>${com[0].quantityOfMaterial!"none"}</span>
                    </td>
                </tr>
            </#list>

            </@ce.table_input>
        </div>

    </div>
</@c.page>