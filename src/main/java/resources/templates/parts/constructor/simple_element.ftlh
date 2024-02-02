<#macro header_1 title >
    <h1 class="text-center mt-1 mb-4">${title}</h1>
</#macro>


<#macro header_2 title >
    <h2 class="text-center mr-2 mb-3">${title}</h2>
</#macro>

<#macro header_3 title >
    <h3 class="text-center mr-2 mb-3">${title}</h3>
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
                name="${element_name!none}"
                placeholder="${placeholder!none}"
                pattern="{5,}"
                id="${element_id}" />
        </div>
    </div>

</#macro>


<#macro input_hidden name value>
    <div class="form-group row justify-content-center">
        <div class="col-sm-6">
            <input
                    class="form-control"
                    type="hidden"
                    name=${name}
            id="${name}_id"
            value=${value}
            />
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

<#macro simple_list
    name
    label
    this_list
    column_length
    justify_content
    >

    <div class="form-group row ${justify_content}">
        <#if this_list?has_content>
            <label for=${name!"default"} class="col-sm-2 col-form-label">${label} : </label>
            <div class="col-${column_length}">
                <select class="form-control" id="${name}+_id" name="${name}">
                    <#if this_list??>
                        <#list this_list as l>
                            <#if l??>
                                <option>${l}</option>
                            </#if>
                        <#else>
                            <option>&ltnone&gt</option>
                        </#list>
                    </#if>
                </select>
            </div>
        </#if>
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
        <label for=${element_name!"default"} class="col-sm-2 col-form-label">${label} : </label>
        <div class="col-sm-6">
            <select class="form-control" id=${element_id!"default_id"} name=${element_name!"default_name"}>
                <#if elements_array??>
                    <#list elements_array as e>
                        <#if elements_attr == "">
                            <option>${e!"none"}</option>
                    <#else />
                            <#if e??>
                                <#assign el = e?keys?seq_index_of(elements_attr)>
                                <option>${(e?values[el])}</option>
                            <#else>
                                <option>Null Pointer Exception!</option>
                            </#if>
                        </#if>
                    </#list>
                <#else />
                    <option>&ltnone&gt</option>
                </#if>
            </select>
        </div>
    </div>

</#macro>

<#macro select_list_element
        element_name
        label
        >

    <div class="form-group row justify-content-center">
        <label for=${element_name!"default"} class="col-sm-2 col-form-label">${label} : </label>
        <div class="col-sm-6">
            <select class="form-control" id=${element_name!"default_id"}_id name=${element_name!"default_name"}>
                <#nested>
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

