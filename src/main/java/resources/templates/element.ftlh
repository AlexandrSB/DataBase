<#import "parts/common.ftlh" as c />
<#import "parts/componentParts.ftlh" as cp />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page "Elements">
    <#include "parts/navbar/navbar_breadcramb.ftlh" />

    <h1 class="text-center">${my_group.groupName}</h1>
    <br/>

    <form action="add_element" method="post" id="equip">

        <input
                type="text"
                name="group_name"
                value="${my_group.groupName}"
                hidden="hidden"
        />

        <@se.input_element
                element_name = "elementName"
                element_id = "element"
                label = "Component"
                placeholder = "Component Name"
        />

        <@se.select_element
            element_name = "element_type"
            element_id = "element_type_id"
            label = "Type"
            placeholder = "Input element type"
            elements_array = elements_type
            elements_attr = "type"
        />
        <@se.description />

        <@se.checkbox
            checkbox_name = "is_equipment"
            checkbox_id = "is_equipment_id"
            label = "Is Equipment"
            checked = "unchecked"
        />

        <@se.button_send
            button_name = "Add"
        />

    </form>

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