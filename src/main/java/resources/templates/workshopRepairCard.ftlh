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

    <p>${element}</p>
    <p>Вид ремонта (техобслуживание, ремонт, капитальный)</p>
    <p>Экспорт моделей (кнопка)</p>
    <p>Выполненные работы</p>

    <p>Element Destination</p>
    <#list elem_destination as ed>
        <span>element - ${ed[0]!"none"}</span><br/>
        <span>element destination - ${ed[1]!"none"}</span><br/>
        <span>proxy- ${ed[2]!"none"}</span><br/>
        <br/>
    </#list>

</@c.page>
