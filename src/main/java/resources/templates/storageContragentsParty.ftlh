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

    </@fm.form_button>

    <@ce.table_input
            table_head = ["Id", "Name", "Link"]
        >
        <#list partyFromContragents as pfc>
            <tr>
                <td>${(pfc.id)!"none"}</td>
                <td>${pfc.name!"none"}</td>
                <td><a href="/storage/parcel/${pfc.id}">View</a></td>
            </tr>
        </#list>
    </@ce.table_input>

</@c.page>