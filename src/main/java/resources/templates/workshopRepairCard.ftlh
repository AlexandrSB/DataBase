<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as f>

<@c.page>

    <@se.header_1
        title = "Карточка ремонта"
        />

    <@se.header_2
        title = repair_card.repairType?capitalize + ": "
        + equipment.inventoryNumber +
        " [" + equipment.model + "]"
        />

    <#if elem_destination[0][1]?has_content>
        <ul>
        <#list elem_destination as ed>
            <li>
                <a href="/workshop/repair_card/${repair_card.id}/${ed[1].id}">Ремонт модуля -- ${ed[1].name!"none"}</a>
            </li>
        </#list>
        </ul>
    </#if>

</@c.page>
