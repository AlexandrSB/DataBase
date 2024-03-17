<#macro table_element
        table_head = [""]
        table_body = [""]
        table_columns = [""]
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

        <tbody>
            <#list table_body as tb>
                <tr>
                    <#list table_columns as tc>
                        <td><span>${(tb[tc])!"none"}</span></td>
                    <#else>
                        <td>none</td>
                    </#list>
                </tr>
            <#else>
                <tr>
                    <td><span>&ltnone&gt</span></td>
                </tr>
            </#list>
        </tbody>
    </table>
    </div>
</#macro>

<#macro table_link_element
        table_head = [""]
        table_body = [""]
        table_columns = [""]
        link = "#"
        link_link = ""
        link_name = "default_name"
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

<#macro table_input
        table_head = [""]
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

        <tbody>
            <#nested>
        </tbody>
    </table>
</div>
</#macro>


<#macro card_element
        title_1 = ""
        title_2 = ""
        text = ""
        href_1 = ""
        href_1_name = ""
        href_2 = ""
        href_2_name = ""
        >

    <div class="card" style="
    width: 15rem;
    .card-columns {
        @include media-breakpoint-only(lg) {
        column-count: 5;
    }
    @include media-breakpoint-only(xl) {
        column-count: 5;
    }
    ">
        <div class="card-body">
            <h5 class="card-title">${title_1}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${title_2}</h6>
            <p class="card-text">${text}</p>
            <a href="${href_1}" class="card-link">${href_1_name}</a>
            <a href="${href_2}" class="card-link">${href_2_name}</a>
        </div>
    </div>

</#macro>

<#macro card_element_1
        title_1 = ""
        title_2 = ""
        text = [""]
        href_1 = ""
        href_1_name = ""
        >

    <div class="mb-3 col-sm-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${title_1}</h5>
                <h6 class="card-subtitle mb-2 text-muted">${title_2}</h6>
                <#list text as t>
                    <p class="card-text">${t}</p>
                <#else>
                    <p class="card-text">none</p>
                </#list>
                <a href="${href_1}" class="card-link">${href_1_name}</a>
            </div>
        </div>
    </div>

</#macro>

<#macro card_element_2
        title_1 = ""
        title_2 = ""
        href_1 = ""
        href_1_name = ""
        >

    <div class="col-sm-4">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${title_1}</h5>
                <h6 class="card-subtitle mb-2 text-muted">${title_2}</h6>
                <#nested>
                <a href="${href_1}" class="card-link">${href_1_name}</a>
            </div>
        </div>
    </div>

</#macro>
