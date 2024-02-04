<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />
<#import "parts/constructor/composite_element.ftlh" as ce />

<@c.page>

    <@se.header_1
        title = "Запчасти и расходные материалы"
        />

    <@se.header_2
        title = good.name
        />

    <form action="/storage/parcel/addParcel" method="post" id="add_parcel">

        <@se.input_hidden
            name = "good_id"
            value = good.id
        />

        <@se.select_list_element
                element_name = "parcel_name"
                label = "Parcel name"
                >
            <#list proxies as p>
                <option>${p.name}</option>
            <#else>
                <option>&ltnone&gt</option>
            </#list>
        </@se.select_list_element>

        <@se.button_send
                button_name = "Add Parcels"
                />

    </form>

</@c.page>
