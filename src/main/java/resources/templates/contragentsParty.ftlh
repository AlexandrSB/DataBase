<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as fm>



<@c.page>

    <@se.header_1
        title = "Формирование партии товара"
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
            element_name = "good_name"
            element_id = "good_name_id"
            label = "Good"
            placeholder = "Insert good name"
            elements_array = goods
            elements_attr = "name"
        />

        <@se.select_element
            element_name = "proxy_name"
            element_id = "proxy_name_id"
            label = "Characteristik"
            placeholder = "Choise characteristik"
            elements_array = proxies!["none"]
            elements_attr = "name"
        />

        <@se.select_element
            element_name = "quantity_dimension"
            element_id = "quantity_dimension_id"
            label = "Dimension"
            placeholder = "Insert dimension"
            elements_array = quantities
            elements_attr = "dimension"
        />

        <@se.input_element
            element_name = "quantity"
            element_id = "quantity_id"
            label = "Quantity"
            placeholder = "Input goods quantity"
        />

    </@fm.form_button>

    <@ce.table_input
            table_head = ["Id", "Name", "Good", "Dimension", "Quantity"]
        >
        <#list partyFromContragents as pfc>
            <tr>
                <td>${(pfc.id)!"none"}</td>
                <td>${pfc.name!"none"}</td>
                <#list pfc.proxyList as pfl>
                    <td>
                        <span>${pfl}</span>
                    </td>
                </#list>
                <td>
                    <span>${pfc.parcel!"none"}</span>
                </td>
                <td>${pfc.parcel!"none"}</td>
            </tr>
        </#list>
    </@ce.table_input>

</@c.page>