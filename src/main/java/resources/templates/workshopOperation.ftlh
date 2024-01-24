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
                        <form class="row g-6" action="/repair_notation/add_repair_notation" method="post">
                            <@se.input_hidden
                                name = "repair_card_id"
                                value = repair_card.id
                                />

                            <@se.input_hidden
                                name = "unit_id"
                                value = unit.id
                                />

                            <div class="col-auto">
                                <label for="inputPassword2" class="visually-hidden">Добавить операцию</label>
                                <input type="text" class="form-control" id="inputPassword2" name="repair_notation_name" placeholder="Добавить операцию" />
                            </div>
                            <div class="col-auto">
                                <button type="submit" class="btn btn-primary mb-3">Add</button>
                            </div>
                        </form>

                        <form class="row g-6" action="#" method="post">
                            <div class="col-auto">
                                <#list completed_works as cw>
                                    <div class="form-check form-switch">
                                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault" name=${cw.id}>
                                        <label class="form-check-label" for="flexSwitchCheckDefault">${cw.notation!"none"}</label>
                                    </div>
                                </#list>
                            </div>

                            <div class="col-auto">
                                <button type="submit" class="btn btn-primary mb-3">Add</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@c.page>