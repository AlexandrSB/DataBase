<#import "constructor/simple_element.ftlh" as se>

<#macro addComponent>
<!--    <form action="add_element" method="post" id="equip">-->

<!--        <input type="text" name="group_name" value="${my_group.groupName}" hidden="hidden">-->

<!--        <div class="form-group row justify-content-center">-->
<!--            <label for="element" class="col-sm-2 col-form-label">Component : </label>-->
<!--            <div class="col-sm-6">-->
<!--                <input class="form-control" type="text" name="elementName"-->
<!--                placeholder="componentName" id="element" >-->
<!--            </div>-->
<!--        </div>-->

<!--        <@se.description />-->

<!--        <div class="d-grid gap-2 col-4 mx-auto">-->
<!--            <button class="btn btn-primary my-2" type="submit">Add</button>-->
<!--        </div>-->
<!--    </form>-->
</#macro>

<#macro componentCard>
    <div class="card-columns">
        <#list elements as element>
            <div class="card my-3" style="width: 18rem;">
                <#if element.parent??>
                    <option>Parent : ${element.parent.name}</option>
                </#if>
                <option>${element.name}</option>
            </div>
        <#else>
            <b>No components!</b>
        </#list>
    </div>
</#macro>


<#macro componentTable>
    <div class="">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Element name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Groups</th>
                    <th scope="col">Class</th>
                    <th scope="col">Category</th>
                    <th scope="col">Button</th>
                </tr>
            </thead>
            <tbody>
                <#list elements as e>
                    <#list e.groups as gr>
                        <#if gr.id == my_group.id || my_group.id == 0>
                        <tr>
                            <td><span>${e.name}</span></td>
                            <td><span>${e.description}</span></td>
                            <td>
                                <a href="/element/${gr.id}">${gr.name}</a>
                            </td>

                            <td>${e.elementType.type}</td>
                            <td>${e.category}</td>

                            <td><a href="/element/view/${e.id}">view</a></td>
                        </tr>
                        </#if>
                    </#list>
                </#list>
            </tbody>
        </table>
    </div>
</#macro>