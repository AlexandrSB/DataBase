<#import "parts/common.ftlh" as com>

<@com.page>
    <div>
        <form method = "POST" action = "/equipment/${group.id}">
            <div class="form-row align-items-center">

                <div class="col-sm-10">
                    <h3 class="mb-2">${group.group_name}</h3>
                    <input name="gr" type="text" value="${group.id?c}" />
                </div>
                <div class="form-group row">
                    <label for="equip_name" class="col-sm-2 col-form-label">Value : </label>
                    <div class="col-sm-6">
                        <input class="form-control" type="text" name="equip_name" id="equip">
                    </div>
                </div>

                <div class="col-auto">
                    <button class="btn btn-primary mb-2" type="submit" >Add Element</button>
                </div>

            </div>
        </form>

        <h5 class="align-self-center my-2">Components</h5>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">View</th>
                </tr>
            </thead>
            <tbody>
                <#list equipment as eq>
                <tr>
                    <td><span>${eq.model}</span></td>
                    <td>
                        <a href="/equipment/equip/${eq.id}">view</a>
                    </td>
                <#else>
                    <b>No components!</b>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</@com.page>
