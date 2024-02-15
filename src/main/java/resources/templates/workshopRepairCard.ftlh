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
        + workshop_element.inventoryNumber +
        " [" + repair_card.equipment_name + "]"
        />

    <span>Начало ремонта: ${repair_card.beginRepairTimestamp!"none"}</span></br>
    <span>Окончание ремонта: ${repair_card.endRepairTimestamp!"none"}</span>

    <form class="row g-6" action="endRepair" method="post">
        <@se.input_hidden
            name = "repair_card_id"
            value = repair_card.id
            />

        <@se.input_hidden
            name = "storage_equipment_id"
            value = workshop_element.id
            />


        <div class="col-4">
            <button type="submit" class="btn btn-primary mb-3">Завершить ремонт</button>
        </div>
    </form>


    <form class="row g-6" action="writeOff" method="post">

        <@se.input_hidden
                name = "repair_card_id"
                value = repair_card.id
                />

        <@se.input_hidden
                name = "storage_equipment_id"
                value = workshop_element.id
                />


        <div class="col-4">
        <button type="submit" class="btn btn-primary mb-3">Списать оборудование</button>
        </div>
    </form>

    <#if elem_destination[0][1]?has_content>
        <ul>
        <#list elem_destination as ed>
            <li>
                <a href="/workshop/repair_card/${repair_card.id}/${ed[1].id}">Ремонт модуля -- ${ed[1].name!"none"}</a>
            </li>
        </#list>
        </ul>
    </#if>

    <#if repair_cards_of_modules?has_content>

        <@se.header_2
            title = "Выполненные работы"
            />

        <ul>
            <#list repair_cards_of_modules as rcom>
                <li>
                    <span>${rcom.workshopModule.name}</span>
                    <ul>
                        <#list consumption_of_materials as com>
                            <#if com.workshopModule.name == rcom.workshopModule.name>
                                <li><span>${com} ${com.workshopModule.name}</span></li>
                            </#if>
                        </#list>
                    </ul>
                </li>
            </#list>
        </ul>
    </#if>


</@c.page>
