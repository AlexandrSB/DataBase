<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as f>

<@c.page>
    <#assign path = "/workshop/repair_card/${repair_card.id}/${unit.id}"/>

    <@se.header_1
        title = "Ремонт: " + repair_card.equipmentName
        />

    <@se.header_2
        title = "Модуль: " + workshop_module.name
        />

    <@se.header_3
        title = "Вид ремонта: " + repair_card.repairType
        />

    <a href="/workshop/repair_card/${repair_card.id}">Карта ремонта</a>

    <!-- Список модулей для ремонта -->
    <#if elements_destination[0][1]?has_content>
        <#list elements_destination as ed>
        <#if ed[1].category == "МОДУЛЬ">
            <ul>
                <li>
                    <a href="/workshop/repair_card/${repair_card.id}/${ed[1].id}">Ремонт модуля -- ${ed[1].name!"none"}</a>
                </li>
            </ul>
        </#if>
        </#list>
    </#if>

    <div>
        <div id="accordion">
            <div class="card">
                <div class="card-header" id="headingOne">
                    <h5 class="mb-0">
                        <button class="btn btn-link" data-toggle="collapse"
                                data-target="#collapseOne" aria-expanded="true"
                                aria-controls="collapseOne">
                            Выполненные работы
                        </button>
                    </h5>
                </div>

                <div id="collapseOne" class="collapse show"
                     aria-labelledby="headingOne" data-parent="#accordion">
                    <div class="card-body">
                    <!-- Форма для ввода операции-->
                        <form class="row g-6" action="/repair_notation/add_operation" method="post">
                            <@se.input_hidden
                                name = "repair_card_id"
                                value = repair_card.id
                                />

                            <@se.input_hidden
                                name = "unit_id"
                                value = unit.id
                                />

                            <@se.input_hidden
                                name = "path"
                                value = path
                            />

                            <div class="row justify-content-start">
                                <!-- Поле ввода операции -->
                                <div class="col-3">
                                    <label for="input_repair_notation_id"
                                           class="visually-hidden">
                                        Добавить операцию
                                    </label>
                                    <input type="text" class="form-control"
                                           id="input_repair_notation_id"
                                           name="repair_notation_name"
                                           placeholder="Добавить операцию"
                                    />
                                </div>

                                <!-- Список выбора заменяемых компонентов -->
                                <#if elements_composite?has_content>
                                    <div class="col-3">
                                        <select class="form-control"
                                                id="element_id"
                                                name="element_name">
                                            <option>&ltnone&gt</option>
                                                <#list elements_composite as e>
                                                    <#if e?? && e.category != "МОДУЛЬ">
                                                        <option>${e.name}</option>
                                                    </#if>
                                                <#else>
                                                    <option>&ltnone&gt</option>
                                                </#list>
                                        </select>
                                    </div>
                                </#if>

                                <!-- Список выбора типа операции -->
                                <#if operation_type?has_content>
                                    <div class="col-3">
                                        <select class="form-control"
                                                id="operation_type_name"
                                                name="operation_type_name">
                                            <#list operation_type as ot>
                                                <option>${ot}</option>
                                            <#else>
                                                <option>&ltnone&gt</option>
                                            </#list>
                                        </select>
                                    </div>
                                </#if>

                                <div class="col-2">
                                    <button type="submit" class="btn btn-primary mb-3">Add</button>
                                </div>

                            </div>
                        </form>

                        <!-- Форма выбора выполняемых работ -->
                        <#if completed_works?has_content>
                        <div class="container">
                        <#list completed_works as cw>
                            <form class="row g-6" action="/repair_notation/check_operation" method="post">
                                <div class="row justify-content-start">
                                    <@se.input_hidden
                                        name = "repair_card_id"
                                        value = repair_card.id
                                        />

                                    <@se.input_hidden
                                        name = "unit_id"
                                        value = unit.id
                                        />

                                    <@se.input_hidden
                                        name = "path"
                                        value = path
                                        />

                                    <div class="row g-1">
                                        <div class="col-3 ">
                                            <div class="form-check form-switch">
                                            <!-- Чекбокс выполнения работы -->
                                                <input class="form-check-input"
                                                       type="checkbox"
                                                       id="flexSwitchCheckDefault"
                                                       name="completed_work_id"
                                                       value=${cw.id}
                                                />
                                                <label
                                                        class="form-check-label"
                                                        for="flexSwitchCheckDefault">
                                                    ${cw.notation!"none"}
                                                </label>
                                            </div>
                                        </div>

                                        <!-- Поле выбора запчасти -->
                                        <#if cw.sparePart??>
                                        <#if elements_composite?has_content>
                                        <div class="col-4">
                                            <select class="form-control"
                                                    id="spare_type_${cw.sparePart.id}"
                                                    name="spare_type_name">
                                                <#list elements_composite as e>
                                                    <#list e.proxies as p>
                                                        <#if p?? && cw.sparePart.name == e.name>
                                                            <option>${p.name}</option>
                                                        </#if>
                                                    </#list>
                                                <#else>
                                                    <option>&ltnone&gt</option>
                                                </#list>
                                            </select>
                                        </div>
                                        </#if>

                                        <!-- Счетчик -->
                                        <div class="col-1">
                                            <input type="number" min="1" class="form-control"
                                                   id="quantity_${cw.sparePart.id}" name="quantity_of_spare"
                                                   value="1"/>
                                        </div>
                                        </#if>

                                        <div class="col-2">
                                            <button type="submit" class="btn btn-primary mb-3">Write</button>
                                        </div>

                                    </div>
                                </div>
                            </form>
                            </#list>
                        </div>
                        </#if>

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
                        <#if com[0].typeOfSparePart?has_content>
                            <span>${com[0].typeOfSparePart.name!"none"}</span>
                        </#if>
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