<#macro header_1 title >
    <h1 class="text-center">${title}</h1>
</#macro>

<#macro input_element
        element_name
        element_id
        label
        placeholder
    >

    <div class="form-group row justify-content-center">
        <label for="${element_name}" class="col-sm-2 col-form-label">${label} : </label>
        <div class="col-sm-6">
            <input
                class="form-control"
                type="text"
                name="${element_name}"
                placeholder="${placeholder}"
                pattern="{5,}"
                id="${element_id}" />
        </div>
    </div>

</#macro>

<#macro checkbox
        checkbox_name
        checkbox_id
        label
        checked
    >

<div class="form-group row justify-content-center ">
    <label class="col-sm-2 form-check-label" for="${checkbox_name}">
        ${label} :
    </label>
    <div class="col-sm-6">
        <input class="form-check-input"
               type="checkbox"
               name="${checkbox_name}"
               id="${checkbox_id}"
               checked = ${checked}
        />
    </div>
</div>

        </#macro>

<#macro select_element
        element_name
        element_id
        label
        placeholder
        elements_array
        elements_attr
    >

    <div class="form-group row justify-content-center">
        <label for="${element_name}" class="col-sm-2 col-form-label">${label} : </label>
        <div class="col-sm-6">
            <select class="form-control" id="${element_id}" name="${element_name}">
                <#list elements_array as e>
                    <#if elements_attr == "">
                        <option>${e}</option>
                    <#else>
                        <#assign el = e?keys?seq_index_of(elements_attr)>
                        <option>${e?values[el]}</option>
                    </#if>
                </#list>
            </select>
        </div>
    </div>

</#macro>

<#macro description>

    <div class="form-group row justify-content-center">
        <label for="description" class="col-sm-2 col-form-label">Description :</label>
        <div class="col-sm-6">
            <textarea class="form-control" id="description" rows="4" name="description"></textarea>
        </div>
    </div>

</#macro>

<#macro button_send button_name>

    <div class="d-grid gap-2 col-4 mx-auto">
        <button class="btn btn-primary my-2" type="submit">${button_name}</button>
    </div>

</#macro>
