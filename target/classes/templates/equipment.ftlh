<#import "parts/common.ftlh" as c>
<#import "parts/elements.ftlh" as e>

<@c.page>
    <div>
        <form method="post" action="equipments">
            <div class="form-group row">
                <label for="firma" class="col-sm-1 col-form-label">Firma : </label>
                <div class="col-sm-6">
                    <select class="form-control" id="firma" name="firmName">
                        <#list firmas as firma>
                            <option>${firma}</option>
                        </#list>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <label for="type" class="col-sm-1 col-form-label">Type : </label>
                <div class="col-sm-6">
                    <select class="form-control" id="type" name="type" class="form-control">
                        <#list types as type>
                            <option>${type}</option>
                        </#list>
                    </select>
                </div>
            </div>

            <#if groups??>
                    <div class="form-group row">
                        <label for="group" class="col-sm-1 col-form-label">Group : </label>
                    <div class="col-sm-6">
                        <select class="form-control" id="type" name="group" class="form-control">
                            <option value="">&ltnone&gt</option>
                            <#list groups as group>
                                <option>${group}</option>
                            </#list>
                        </select>
                    </div>
                </div>
            </#if>

            <div class="form-group row">
                <label for="model" class="col-sm-1 col-form-label">Model : </label>
                <div class="col-sm-6">
                    <input type="text" name="myModel" id="model" placeholder="Model" class="form-control">
                </div>
            </div>
                <button class="btn btn-primary my-2" type="submit">Add</button>
        </form>
    </div>
        <button class="btn btn-primary my-2" onclick="location.href = '/equipments';">Show all</button>

    <@e.equipCards />
</@c.page>