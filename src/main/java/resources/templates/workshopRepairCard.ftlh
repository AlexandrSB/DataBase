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

    <#if elem_destination[0][1]?has_content>
        <ul>
        <#list elem_destination as ed>
            <li>
                <a href="/workshop/repair_card/${equipment.inventoryNumber}/${ed[1].id}">Ремонт модуля -- ${ed[1].name!"none"}</a>
            </li>
        </#list>
        </ul>
    </#if>


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
