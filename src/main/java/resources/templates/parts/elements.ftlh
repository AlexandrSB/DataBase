<#macro comps>
    <div class"card-columns">
        <#list components as component>
            <div class="card my-3" style="width: 18rem;">
                <#list component.owner as owner>
                    <span>${owner.model}</span>
                </#list>
                <span>${component.name}</span>
                <#if component.isComposite??>
                    <span>is composite</span>
                </#if>
                <#if component.isMechanic??>
                    <span>is mechanic</span>
                </#if>
                <#if component.isElectric??>
                    <span>is electric</span>
                </#if>
                <#if component.isElectronic??>
                    <span>is electronic</span>
                </#if>
            </div>
        <#else>
            <b>No components!</b>
        </#list>
    </div>
</#macro>


<#macro component>
    <form action="components" method="post" id="equip">
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

        <div class="form-group row">
            <label for="isComposite" class="col-sm-2 col-form-label">Is composite :</label>
            <div class="col-sm-1">
                <input class="form-control" type="checkbox" name="isComposite" id="isComposite">
            </div>
        </div>

        <div class="form-group row">
            <label for="isComposite" class="col-sm-2 col-form-label">Is mechanic :</label>
            <div class="col-sm-1">
                <input class="form-control" type="checkbox" name="isMechanic" id="isMechanic">
            </div>
        </div>

        <div class="form-group row">
            <label for="isComposite" class="col-sm-2 col-form-label">Is electric :</label>
            <div class="col-sm-1">
                <input class="form-control" type="checkbox" name="isElectric" id="isElectric">
            </div>
        </div>

        <div class="form-group row">
            <label for="isComposite" class="col-sm-2 col-form-label">Is electronic :</label>
            <div class="col-sm-1">
                <input class="form-control" type="checkbox" name="isElectronic" id="isElectronic">
            </div>
        </div>

        <button class="btn btn-primary my-2" type="submit">Add</button>
    </form>
</#macro>

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
