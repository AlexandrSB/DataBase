


<#macro equipCards>
    <div class="card-columns">
        <#list equipments as equip>
            <div class="card my-3" style="width: 18rem;">
                <div>
                    <span>${equip.firmName}</span>
                    <span>${equip.model}</span>
                    <i>${equip.type}</i><br>
                    <a href="equipments/${equip.id?c}">View</a>
                </div>
            </div>
        <#else>
            <span>No equipments</span>
        </#list>
    </div>
</#macro>

<#macro equipTable>
    <div class="">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Firm name</th>
                    <th scope="col">Model</th>
                    <th scope="col">Type</th>
                    <th scope="col">Button</th>
                </tr>
            </thead>
            <tbody>
                <#list equipments as equip>
                    <tr>
                        <td><span>${equip.firmName}</span></td>
                        <td><span>${equip.model}</span></td>
                        <td><span>${equip.type}</span></td>
                        <td><a href="/equipments/${equip.id}">view</a></td>
                    <#else>
                        <b>No components!</b>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>
</#macro>