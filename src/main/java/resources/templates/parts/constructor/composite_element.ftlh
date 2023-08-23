<#macro table_element
        table_head
        table_body
    />

    <div class="">
    <table class="table table-striped table-hover">
        <thead>
            <tr>
            <#list table_head as th>
                <th scope="col">${th}</th>
            </#list>
            </tr>
        </thead>

        <tbody>
            <tr>
                <#list table_body as tb>
                    <td><span>${tb}</span></td>
                <#else>
                    <td><span>&ltnone&gt</span></td>
                </#list>
            </tr>
        </tbody>
    </table>
    </div>
</#macro>