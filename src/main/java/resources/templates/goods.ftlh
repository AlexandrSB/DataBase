<#import "parts/common.ftlh" as c>
<#import "parts/description.ftlh" as descr>

<@c.page>

    <form action="add_goods" method="post" id="equip">
        <div class="form-group row">
            <label for="myElem" class="col-sm-2 col-form-label">Element : </label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="elem">
                    <#list elem as e>
                        <option>${e.name}</option>
                    </#list>
                </select>
            </div>
        </div>

        <@descr.description />

        <button class="btn btn-primary my-2" type="submit">Add</button>
    </form>

    <div class="">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">name</th>
                    <th scope="col">description</th>
                </tr>
            </thead>
            <tbody>
                <#if goods??>
                    <#list goods as obj>
                        <tr>
                            <td><span>${obj.id}</span></td>
                            <td><span>${obj.type}</span></td>
                            <td><span>${obj.barcode}</span></td>
                        </tr>
                    <#else>
                        <b>No components!</b>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>

</@c.page>