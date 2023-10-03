<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as fm>



<@c.page>

    <@se.header_1
        title = "Новая партия товара"
    />

    <@fm.form_button
        id = "form_add_to_parcel_id"
        action = "addToParcel/${party_id}"
        method = "post"
        button_name = "Add to Party">

        <div class="form-group row justify-content-center">
            <div class="col-sm-6">
                <input
                        class="form-control"
                        type="hidden"
                        name="party_id"
                        placeholder=""
                        id="party_id_id"
                        value=${party_id}
                />
            </div>
        </div>

        <@se.select_element
            element_name = "good_name"
            element_id = "good_name_id"
            label = "Good"
            placeholder = "Insert good name"
            elements_array = goods
            elements_attr = ""
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
            elements_attr = ""
        />

        <@se.input_element
            element_name = "quantity"
            element_id = "quantity_id"
            label = "Quantity"
            placeholder = "Input goods quantity"
        />

    </@fm.form_button>

    <@fm.form_button
        id = "form_add_to_parcel_id"
        action = "redirectToGoodsTrackingFromContragent"
        method = "post"
        button_name = "Next -->">

        <@se.input_hidden
            name = "party_id"
            value = "${party_id}"
        />

    </@fm.form_button>

    <@ce.table_input
        table_head = ["Id", "Good", "Dimension", "Quantity"]
    >

        <#list parcels as ps>
            <tr>
                <td>${ps.id!"none"}</td>

                <#if ps.good??>
                    <td>${(ps.good.name)!"none"}</td>
                <#else>
                    <td>none</td>
                </#if>

                <#if ps.quantityAccount??>
                    <td>${ps.quantityAccount.dimension.dimension!"none"}</td>
                    <td>${ps.quantityAccount.quantity!"none"}</td>
                <#else>
                    <td>none</td>
                    <td>none</td>
                </#if>

            <#else>
                <td>&ltnone&gt</td>
            </tr>
        </#list>
    </@ce.table_input>

</@c.page>