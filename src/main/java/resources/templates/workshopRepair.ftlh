<#import "parts/common.ftlh" as c>
<#import "parts/constructor/composite_element.ftlh" as ce>
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/forms.ftlh" as f />


<@c.page>

    <@se.header_2
        title = "Оборудование в ремонте"
    />

    <a href="/workshop/awaiting">Оборудование в ожидании ремонта</a>

    <div class="row">
        <@ce.card_element_2
            title_1 = "Ремонт"
            title_2 = "Оборудование в ремонте"
            href_1 = "/workshop/repair"
            href_1_name = "Ремонт"
        >
            <#list repair_cards as rc>
                <p>${rc.workshopElement.prefixInventoryNumber!"none"}
                    ${rc.workshopElement.inventoryNumber!"none"} --
                    ${rc.equipmentName!"none"} --
                    <a href="/workshop/repair_card/${rc.id}">card</a>
                </p>
            <#else>
                <p>&ltnone&gt</p>
            </#list>

        <form action="workshop/take_elements" method="post" id="take_elements_id">

            <@se.input_hidden
                name = "path"
                value = "/workshop"
            />

        <button class="btn btn-primary" type="submit">Take element</button>
        </form>

        </@ce.card_element_2>
    </div>

</@c.page>
