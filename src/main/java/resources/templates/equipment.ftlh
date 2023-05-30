<#import "parts/common.ftlh" as c>

<@c.page>
    <div>
        <form method="post" action="equipments">
            <div class="form-group row">
                <label for="firma" class="col-sm-1 col-form-label">Firma :</label>
                <div class="col-sm-6">
                    <select class="form-control" id="firma" name="firmName">
                        <#list firmas as firma>
                            <option>${firma}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="model" class="col-sm-1 col-form-label">Model :</label>
                <div class="col-sm-6">
                    <input type="text" name="myModel" id="model" placeholder="Model" class="form-control">
                </div>
            </div>
            <div class="form-group row">
                <label for="type" class="col-sm-1 col-form-label">Type :</label>
                <div class="col-sm-6">
                    <select class="form-control" id="type" name="type" class="form-control">
                        <#list types as type>
                            <option>${type}</option>
                        </#list>
                    </select>
                </div>
            </div>
                <button class="btn btn-primary" type="submit">Add</button>
        </form>
    </div>

    <div class="card-columns">
        <#list equipments as equip>
            <div class="card my-3" style="width: 18rem;">
                <div>
                    <span>${equip.firmName}</span>
                    <span>${equip.model}</span>
                    <i>${equip.type}</i><br>
                </div>
            </div>
        <#else>
            No equipments!
        </#list>
    </div>
</@c.page>