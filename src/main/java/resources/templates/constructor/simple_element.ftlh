<#macro input_element_center
        element_name
        element_id
        label
        placeholder
    >

    <div class="form-group row justify-content-center">
        <label for="${element_name}" class="col-sm-2 col-form-label">${label} : </label>
        <div class="col-sm-6">
            <input class="form-control" type="text" name="${element_name}"
                   placeholder="${placeholder}" id="${element_id}" >
        </div>
    </div>

</#macro>

<#macro select_element_center
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
                <#list elements_array?keys as e>
                    <option>${e}</option>
                </#list>
            </select>
        </div>
    </div>

</#macro>