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
        + repair_card.equipmentName
        + "[" + workshop_element.prefixInventoryNumber
        + workshop_element.inventoryNumber
        + "]"
        />

    <span>Начало ремонта: ${repair_card.beginRepairTimestamp!"none"}</span></br>
    <span>Окончание ремонта: ${repair_card.endRepairTimestamp!"none"}</span>

    <!-- Форма с кнопкой окончания ремонта -->
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

<!-- Форма с кнопкой списания оборудования -->
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

    <@se.header_2
        title = "Выполненные работы"
        />


<ul class="nav nav-tabs" id="myTab" role="tablist">
<li class="nav-item" role="presentation">
    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button"
            role="tab" aria-controls="home" aria-selected="true">Ремонт</button>
</li>
<li class="nav-item" role="presentation">
    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab"
            aria-controls="profile" aria-selected="false">Диагностика</button>
</li>
<li class="nav-item" role="presentation">
    <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab"
            aria-controls="contact" aria-selected="false">Очистка</button>
</li>
</ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
            <#if repair_cards_of_modules?has_content>
                <ul>
                    <#list repair_cards_of_modules as rcom>
                    <li>
                        <span>${rcom.workshopModule.name}</span>
                        <ul>
                            <#list consumption_of_materials as com>
                            <#if com.workshopModule.id == rcom.workshopModule.id>
                                <#if com.typeOfSparePart??>
                                    <li><span>${com.quantityOfMaterial!"none"} ${com.typeOfSparePart.name}</span></li>
                                </#if>
                            </#if>
                            </#list>
                        </ul>
                    </li>
                    </#list>
                </ul>
            </#if>
        </div>
        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">...</div>
        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">...</div>
    </div>

</@c.page>
