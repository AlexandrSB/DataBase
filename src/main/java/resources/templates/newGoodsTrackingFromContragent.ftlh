<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as fm>



<@c.page>

    <@se.header_1
        title = "Поступление товара от контрагента"
    />

    <@fm.form_button
        id = "form_add_to_tracking_id"
        action = "trackingFromContragentToStorage"
        method = "post"
        button_name = "Add to Tracking">

        <@se.input_hidden
            name = "id"
            value = "${tracking_id}"
        />

        <@se.select_element
            element_name = "contragent_name"
            element_id = "contragents_name_id"
            label = "Contragent"
            placeholder = ""
            elements_array = contragents
            elements_attr = "name"
        />


        <@se.select_element
            element_name = "storage_name"
            element_id = "storage_name_id"
            label = "Storage"
            placeholder = ""
            elements_array = storages
            elements_attr = "name"
        />


    </@fm.form_button>

</@c.page>