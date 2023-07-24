<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="addAttribute" method="post" id="attr">
        <div class="form-group row">
            <label for="myModel" class="col-sm-2 col-form-label">Component : </label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="comp">
                    <#list components as comp>
                        <option>${comp.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="attr" class="col-sm-2 col-form-label">Attribute : </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="attr" id="attrId">
            </div>
        </div>

        <div class="form-group row">
            <label for="val" class="col-sm-2 col-form-label">Value : </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="val" id="attrId">
            </div>
        </div>

        <div class="form-group row">
            <label for="un" class="col-sm-2 col-form-label">Unit : </label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="un">
                    <#list units as u>
                        <option>${u}</option>
                    </#list>
                </select>
            </div>
        </div>

        <button class="btn btn-primary my-2" type="submit">Add</button>
    </form>

    <h5 class="my-2">Addtion</div>
    <div class="card-columns">
        <#list components as element>
            <div class="card my-3" style="width: 18rem;">
            <span>${element.name}</span>
        </#list>
    </div>
</@c.page>