<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />
<#import "parts/constructor/forms.ftlh" as fm>


<@c.page>
    <#assign path = "/storage/contragents_party" />

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

        <@se.input_hidden
            name = "pathToNewParty"
            value = "/storage/parcel/${party_id}"
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
            label = "Proxy name: "
            placeholder = "proxy"
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

    <@fm.form_button
        id = "form_add_to_parcel_id"
        action = "redirectToGoodsTrackingFromContragent"
        method = "post"
        button_name = "Write">

        <@se.input_hidden
            name = "party_id"
            value = "${party_id}"
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
        table_head = ["Id", "Party", "Good", "Dimension", "Quantity"]
    >

        <#list parcels as ps>
            <tr>
                <td>${ps.id!"none"}</td>

                <#if ps.party??>
                    <td>${ps.party.name}</td>
                <#else>
                    <td>none</td>
                </#if>

                <#if ps.good??>
                    <td>${(ps.good.name)!"none"}</td>
                <#else>
                    <td>none</td>
                </#if>

                <#if ps.quantityAccount??>
                    <td>${ps.quantityAccount.dimension.dimension!"none"}</td>
                    <td>${ps.quantityAccount.quantity}</td>
                <#else>
                    <td>none</td>
                    <td>none</td>
                </#if>
            </tr>

        <#else>
            <tr>
                <td>&ltnone&gt</td>
            </tr>
        </#list>
    </@ce.table_input>

</@c.page>