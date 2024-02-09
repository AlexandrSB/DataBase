<#import "parts/common.ftlh" as c />
<#import "parts/componentParts.ftlh" as cp />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page "Elements">
    <#include "parts/navbar/navbar_breadcramb.ftlh" />

    <@se.header_1
        title = my_group.name
        />



    <#if my_group.id gt 0>
    <form action="add_element" method="post" id="equip">

        <input
                type="text"
                name="group_name"
                value="${my_group.name}"
                hidden="hidden"
        />

        <@se.input_element
                element_name = "element_name"
                element_id = "element"
                label = "Component"
                placeholder = "Component Name"
        />

        <@se.select_element
            element_name = "element_type"
            element_id = "element_type_id"
            label = "Equipment"
            placeholder = "Input element type"
            elements_array = elements_type
            elements_attr = "type"
        />

        <@se.simple_list
            name = "this_category"
            label = "Category"
            this_list = categories
            column_length = "sm-6"
            justify_content = "justify-content-center"
        />

        <@se.description />

        <@se.button_send
            button_name = "Add"
        />

    </form>
    </#if>

    <br />
    <br />

    <!--
    <h5 class"my-2">Addition</h5>
    <div>
        <@cp.componentCard />
    </div>
    // -->

    <@cp.componentTable />
</@c.page>