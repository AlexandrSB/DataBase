<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as f>

<@c.page>

    <@se.header_1
        title = "Карточка ремонта"
    />

    <@se.header_2
        title = equipment.inventoryNumber + " [" + equipment.good.name + "]"
    />

    <#list elem_destination as ed>
        <a href="/workshop/repair_card/${equipment.inventoryNumber}/${ed[2].id}">Ремонт модуля -- ${ed[2].name!"none"}</a>
    </#list>


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
                            name = "equipment_id"
                            value = equipment.id
                            />

                            <div class="col-auto">
                                <label for="inputPassword2" class="visually-hidden">Добавить операцию</label>
                                <input type="text" class="form-control" id="inputPassword2" name="repair_notation_name" placeholder="Добавить операцию" />
                            </div>
                            <div class="col-auto">
                                <button type="submit" class="btn btn-primary mb-3">Add</button>
                            </div>
                        </form>

                        <#list repair_notation as rn>
                            <div class="form-check form-switch">
                                <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault">
                                <label class="form-check-label" for="flexSwitchCheckDefault">${rn.notation!"none"}</label>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
            <#if elem_destination?has_content>
            <#list elem_destination as ed>
                <div class="card">
                    <div class="card-header" id="headingTwo">
                        <h5 class="mb-0">
                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                                <span>${ed[1].name!"none"}</span>
                            </button>
                        </h5>
                    </div>

                    <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo" data-parent="#accordion">
                        <div class="card-body">
                            <form class="row g-6" action="/repair_notation/add_repair_notation" method="post">
                                <@se.input_hidden
                                name = "equipment_id"
                                value = equipment.id
                                />

                                <div class="col-auto">
                                    <label for="inputPassword2" class="visually-hidden">Добавить операцию</label>
                                    <input type="text" class="form-control" id="inputPassword2" name="repair_notation_name" placeholder="Добавить операцию" />
                                </div>
                                <div class="col-auto">
                                    <button type="submit" class="btn btn-primary mb-3">Add</button>
                                </div>
                            </form>

                            <#list repair_notation as rn>
                            <div class="form-check form-switch">
                                <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault">
                                <label class="form-check-label" for="flexSwitchCheckDefault">${rn.notation!"none"}</label>
                            </div>
                        </#list>
                        </div>
                    </div>
                </div>
            </#list>
            </#if>
        </div>
    </div>

    <p>${element}</p>
    <p>Вид ремонта (техобслуживание, ремонт, капитальный)</p>
    <p>Экспорт моделей (кнопка)</p>


    <p>Element Destination</p>
    <#list elem_destination as ed>
        <span>element - ${ed[0]!"none"}</span><br/>
        <span>element destination - ${ed[1]!"none"}</span><br/>
        <span>proxy- ${ed[2]!"none"}</span><br/>
        <br/>
    </#list>

</@c.page>
