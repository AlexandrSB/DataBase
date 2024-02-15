<#import "constructor/simple_element.ftlh" as se>

<#macro componentCard>
    <div class="card-columns">
        <#list elements as element>
            <div class="card my-3" style="width: 18rem;">
                <#if element.parent??>
                    <option>Parent : ${element.parent.name}</option>
                </#if>
                <option>${element.name}</option>
            </div>
        <#else>
            <b>No components!</b>
        </#list>
    </div>
</#macro>


<#macro componentTable>
    <div class="">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Element name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Groups</th>
                    <th scope="col">Class</th>
                    <th scope="col">Category</th>
                    <th scope="col">Button</th>
                </tr>
            </thead>
            <tbody>
                <#list elements as e>
                    <#list e.groups as gr>
                        <#if gr.id == my_group.id || my_group.id == 0>
                        <tr>
                            <td><span>${e.name}</span></td>
                            <td><span>${e.description}</span></td>
                            <td>
                                <a href="/element/${gr.id}">${gr.name}</a>
                            </td>

                            <td>${e.elementType.type}</td>
                            <td>${e.category}</td>

                            <td><a href="/element/view/${e.id}">view</a></td>
                        </tr>
                        </#if>
                    </#list>
                </#list>
            </tbody>
        </table>
    </div>
</#macro>

<#macro proxies_table>
<div class="">
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
        <th scope="col">Class</th>
        <th scope="col">Category</th>
        <th scope="col">Button</th>
    </tr>
    </thead>
    <tbody>
        <#list proxies as p>
            <tr>
                <td><span>${p.name!"none"}</span></td>
                <td><span>${p.description!"none"}</span></td>
                <#if p.elementType??>
                    <td>${p.elementType.type!"none"}</td>
                <#else>
                    <td>&ltnone&gt</td>
                </#if>
                <td>${p.category!"none"}</td>

                <td><a href="/proxy/${p.id}">view</a></td>
            </tr>
        </#list>
    </tbody>
</table>
</div>
</#macro>
