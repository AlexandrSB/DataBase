<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>

    <form action="add_goods" method="post" id="equip">
        <div class="form-group row">
            <label for="myElem" class="col-sm-2 col-form-label">Element : </label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="elem">
                <#if elements??>
                    <#list elements as e>
                        <option>${e.name}</option>
                    <#else>
                        <option>&ltnone&gt</option>
                    </#list>
                </#if>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="condition" class="col-sm-2 col-form-label">Condition : </label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="condition">
                <#if conditions??>
                    <#list conditions as cond>
                        <option>${cond.name}</option>
                    <#else>
                        <option>&ltnone&gt</option>
                    </#list>
                </#if>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="barcode" class="col-sm-2 col-form-label">Barcode : </label>
            <div class="col-sm-6">
                <input
                        type="text"
                        name="barcode"
                        id="barcode_id"
                        placeholder="Barcode"
                        pattern=[0-9]{6,}
                        class="form-control"
                >
            </div>
        </div>

        <@se.description />

        <button class="btn btn-primary my-2" type="submit">Add</button>
    </form>

    <div class="">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">name</th>
                </tr>
            </thead>
            <tbody>
                <#if goods??>
                    <#list goods as obj>
                        <tr>
                            <td><span>${obj.id}</span></td>
                            <td><span>${obj.name}</span></td>
                        </tr>
                    <#else>
                        <b>No components!</b>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>

</@c.page>