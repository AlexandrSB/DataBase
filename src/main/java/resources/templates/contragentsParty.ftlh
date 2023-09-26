<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as fm>



<@c.page>

    <@se.header_1
        title = "Партии товаров"
    />

    <@fm.form_button
            id = "form_add_to_party_id"
            action = "addToParty"
            method = "post"
            button_name = "Create new party">

        <@se.input_element
            element_name = "party_name"
            element_id = "quantity_id"
            label = "Name"
            placeholder = "Input name of parties"
        />

        <@se.select_element
            element_name = "contragent_name"
            element_id = "contragent_id"
            label = "From Contragent"
            placeholder = "Insert contragent name"
            elements_array = contragents
            elements_attr = "name"
        />

        <@se.select_element
            element_name = "storage_name"
            element_id = "storage_id"
            label = "To Storage"
            placeholder = "Insert storage name"
            elements_array = storages
            elements_attr = "name"
        />

    </@fm.form_button>

    <@ce.table_input
            table_head = ["Id", "Name", "Good", "Dimension", "Quantity"]
        >
        <#list partyFromContragents as pfc>
            <tr>
                <td>${(pfc.id)!"none"}</td>
                <td>${pfc.name!"none"}</td>
<#--                <#list pfc.proxyList as pfl>-->
<#--                    <td>-->
<#--                        <span>${pfl}</span>-->
<#--                    </td>-->
<#--                </#list>-->
<#--                <td>-->
<#--                    <span>${pfc.parcel!"none"}</span>-->
<#--                </td>-->
<#--                <td>${pfc.parcel!"none"}</td>-->
            </tr>
        </#list>
    </@ce.table_input>

</@c.page>