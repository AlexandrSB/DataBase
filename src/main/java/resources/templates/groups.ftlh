<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="addGroup" method="post" id="groupsForm">
        <label class="col-sm-2 col-form-label">Groups :
            <input class="form-control" type="text" name="groupName" id="groupId">
            <button class="btn btn-primary my-2" type="submit">Add</button>
        </label>

        <label class="col-sm-2 col-form-label">Parent ID :
            <input class="form-control" type="text" name="parentId" id="parentId">
            <button class="btn btn-primary my-2" type="submit">Add</button>
        </label>

        <table class="table table-striped table-hover">

            <thead>
                <tr>
                   <th scope="col">Group name</th>
                   <th scope="col">Level</th>
                </tr>
            </thead>

            <tbody>
                <#list gr as g>
                    <tr>
                        <td><span>${""?left_pad((g.level-1)*15, ".")} ${g.name}</span></td>
                        <td><span>${g.level}</span></td>
                    <#else>
                        <td><b>No groups!</b></td>
                    </tr>
                </#list>
            </tbody>

        </table>
    </form>
</@c.page>