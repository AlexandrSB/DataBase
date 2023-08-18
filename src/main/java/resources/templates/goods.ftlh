<#import "parts/common.ftlh" as c>
<#import "parts/description.ftlh" as descr>

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
            <label for="condition" class="col-sm-2 col-form-label">Element : </label>
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
            <label for="inventoryNumber" class="col-sm-2 col-form-label">Inventory number : </label>
            <div class="col-sm-6">
                <input
                        type="text"
                        name="inventoryNumber"
                        id="inv_number"
                        placeholder="Inventory number"
                        pattern=^[A-Z][0-9]{6.}
                        class="form-control"
                >
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

        <@descr.description />

        <button class="btn btn-primary my-2" type="submit">Add</button>
    </form>

    <div class="">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">name</th>
                    <th scope="col">inventory number</th>
                    <th scope="col">barcode</th>
                    <th scope="col">condition</th>
                </tr>
            </thead>
            <tbody>
                <#if goods??>
                    <#list goods as obj>
                        <tr>
                            <td><span>${obj.id}</span></td>
                            <td><span>${obj.name}</span></td>
                            <td><span>${obj.inventoryNumber!"<none>"}</span></td>
                            <td><span>${obj.barcode!"<none>"}</span></td>
                            <#if obj.condition??>
                                <td><span>${obj.condition.name!"<none>"}</span></td>
                            <#else>
                                <td><span>&ltnone&gt<span></td>
                            </#if>
                        </tr>
                    <#else>
                        <b>No components!</b>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>

</@c.page>