<#macro table_element
        table_head
        table_body
        table_columns
    >

    <div class="">
    <table class="table table-striped table-hover">
        <thead>
            <tr>
            <#list table_head as th>
                <th scope="col">${th}</th>
            </#list>
            </tr>
        </thead>

        <#list table_body as tb>
        <tbody>
            <tr>
                <#list table_columns as tc>
                    <td><span>${(tb[tc])!"none"}</span></td>
                </#list>
            <#else>
                    <td><span>&ltnone&gt</span></td>
            </tr>
        </tbody>
        </#list>
    </table>
    </div>
</#macro>

<#macro table_link_element
        table_head
        table_body
        table_columns
        link
        link_link
        link_name
    >

    <div class="">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <#list table_head as th>
                        <th scope="col">${th}</th>
                    </#list>
                </tr>
            </thead>

        <#list table_body as tb>
            <td>
                <tr>
                    <#list table_columns as tc>
                        <td><span>${tb[tc]!"none"}</span></td>
                    </#list>
                        <td><a href=${link+tb[link_link]!"none"}>${link_name!"none"}</a></td>
        <#else>
                    <td><span>&ltnone&gt</span></td>
                </tr>
            </tbody>
        </#list>
            </table>
    </div>
</#macro>
