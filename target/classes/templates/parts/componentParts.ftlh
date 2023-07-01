<#macro addComponent>
    <form action="addComponent" method="post" id="equip">
        <div class="form-group row">
            <label for="myModel" class="col-sm-2 col-form-label">Equipment : </label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="myModel">
                    <#list equipments as equip>
                        <option>${equip.model}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="comp" class="col-sm-2 col-form-label">Parent : </label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="comp">
                    <option value="">&ltnone&gt</option>
                    <#list components as comps>
                        <#if comps.isComposite>
                            <option>${comps.name}</option>
                        </#if>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="component" class="col-sm-2 col-form-label">Component : </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="name" placeholder="componentName" id="component">
            </div>
        </div>

        <#if attributes??>
            <div class="form-group row">
                <label for="attr" class="col-sm-2 col-form-label">Attribute : </label>
                <div class="col-sm-6">
                    <select class="form-control" id="model" name="attr">
                    <option value="">Choice Attrubute</option>
                        <#list attributes as attr>
                            <option>${attr.name}</option>
                        </#list>
                    </select>
                </div>
            </div>
        </#if>

        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description :</label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="description" placeholder="Description" id="desk">
            </div>
        </div>

        <div class="form-group row my-2">
            <label for="inputComposite" class="col-sm-2 col-form-label">Is composite :</label>
            <div class="col-sm-1">
                <input class="form-control" type="checkbox" name="isComposite" id="inputComposite">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputMechanic" class="col-sm-2 col-form-label">Is mechanic :</label>
            <div class="col-sm-1">
                <input class="form-control" type="checkbox" name="isMechanic" id="inputMechanic">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputElectric" class="col-sm-2 col-form-label">Is electric :</label>
            <div class="col-sm-1">
                <input class="form-control" type="checkbox" name="isElectric" id="inputElectric">
            </div>
        </div>

        <div class="form-group row">
            <label for="inputComposite" class="col-sm-2 col-form-label">Is electronic :</label>
            <div class="col-sm-1">
                <input class="form-control" type="checkbox" name="isElectronic" id="inputElectronic">
            </div>
        </div>

        <button class="btn btn-primary my-2" type="submit">Add</button>
    </form>
</#macro>

<#macro componentCard>
    <div class="card-columns">
        <#list components as component>
            <div class="card my-3" style="width: 18rem;">
                <#list component.owner as owner>
                    <span>Equipment : ${owner.model}</span>
                </#list>
                <#if component.relationship??>
                    <#list component.relationship as rel>
                        <span>Parent : ${rel.name}<#sep>, </span>
                    </#list>
                </#if>
                <span>${component.name}</span>
                <#if component.description != "">
                    <span>Description : ${component.description}</span>
                </#if>
                <#if component.isComposite>
                    <span>is composite</span>
                </#if>
                <#if component.isMechanic>
                    <span>is mechanic</span>
                </#if>
                <#if component.isElectric>
                    <span>is electric</span>
                </#if>
                <#if component.isElectronic>
                    <span>is electronic</span>
                </#if>
            </div>
        <#else>
            <b>No components!</b>
        </#list>
    </div>
</#macro>
