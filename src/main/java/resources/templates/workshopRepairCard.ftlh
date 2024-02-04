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

    <p>${element}</p>

    <p>Element Destination</p>
    <#list elem_destination as ed>
        <span>element - ${ed[0]!"none"}</span><br/>
        <span>element destination - ${ed[1]!"none"}</span><br/>
        <span>proxy- ${ed[2]!"none"}</span><br/>
        <br/>
    </#list>

</@c.page>
