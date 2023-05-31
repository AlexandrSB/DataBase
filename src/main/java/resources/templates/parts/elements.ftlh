


<#macro equipCards>
    <div class="card-columns">
        <#list equipments as equip>
            <div class="card my-3" style="width: 18rem;">
                <div>
                    <span>${equip.firmName}</span>
                    <span>${equip.model}</span>
                    <i>${equip.type}</i><br>
                    <a href="/equipments/${equip.id}">View</a>
                </div>
            </div>
        <#else>
            No equipments!
        </#list>
    </div>
</#macro>
