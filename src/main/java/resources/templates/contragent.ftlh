<#import "parts/common.ftlh" as c>

<@c.page>
    <h1>Contragent</h1>

    <form action="add_contragent" method="post" id="contrnt">

        <div class="form-group row">
            <label for="element" class="col-sm-2 col-form-label">Name : </label>
            <div class="col-sm-6">
                <input
                    class="form-control"
                    type="text"
                    name="name"
                    placeholder="contragentName"
                    pattern="[A-Za-zА-Яа-яЁё0-9 ]{3,}"
                    id="contragent_id">
            </div>
        </div>

        <div class="form-group row">
            <label for="description" class="col-sm-2 col-form-label">Description :</label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="description" placeholder="Description" id="desk">
            </div>
        </div>

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
                <#if contragents??>
                    <#list contragents as obj>
                        <tr>
                            <td><span>${obj.id}</span></td>
                            <td><span>${obj.name}</span></td>
                            <td><span>${obj.description}</span></td>
                        </tr>
                    <#else>
                        <b>No components!</b>
                    </#list>
                </#if>
            </tbody>
        </table>
    </div>

</@c.page>
