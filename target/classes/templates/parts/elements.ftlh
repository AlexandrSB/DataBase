<#macro comps>
    <div>Components</div>
    <#list components as component>
        <div>
            <b>${component.id}</b>
            <span>${component.ownerModel}</span>
            <span>${component.name}</span>
        </div>
    <#else>
        No components!
    </#list>
</#macro>


<#macro equips>
    <div>Equipments</div>
    <form action="equipments" method="post">
        <select class="form-control" id="model" name="myModel">
            <#list equipments as equip>
                <option>${equip.model}</option>
            </#list>
        </select><br>
        <input type="text" name="name" placeholder="componentName"></br>
        <button type="submit">Add</button>
    </form>
</#macro>
