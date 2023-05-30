<#macro comps>
    <div class"card-columns">
        <#list components as component>
            <div class="card my-3" style="width: 18rem;">
                <span>${component.ownerModel}</span>
                <span>${component.name}</span>
            </div>
        <#else>
            No components!
        </#list>
    </div>
</#macro>


<#macro equips>
    <form action="equipments" method="post" id="equip">
        <div class="form-group row">
            <label for="equip" class="col-sm-2 col-form-label">Equipments :</label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="myModel">
                    <#list equipments as equip>
                        <option>${equip.model}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="component" class="col-sm-2 col-form-label">Component :</label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="name" placeholder="componentName" id="component"></br>
            </div>
        </div>
        <button class="btn btn-primary my-2" type="submit">Add</button>
    </form>
</#macro>
