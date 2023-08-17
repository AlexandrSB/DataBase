<#import "description.ftlh" as descr>

<#macro addComponent>
    <form action="add_element" method="post" id="equip">

        <div class="form-group row">
            <label for="group_name" class="col-sm-2 col-form-label">Group : </label>
            <div class="col-sm-6">
                <select class="form-control" id="group_name" name="group_name">
                    <option>${my_group.groupName}</option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <label for="comp" class="col-sm-2 col-form-label">Parent : </label>
            <div class="col-sm-6">
                <select class="form-control" id="elemParent" name="parent">
                    <option>&ltnone&gt</option>
                    <#list elements as elem>
                        <option>${elem.name}</option>
                    <#else>
                        <option>Not Parent</option>
                    </#list>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label for="element" class="col-sm-2 col-form-label">Component : </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="elementName"
                placeholder="componentName" id="element" >
            </div>
        </div>

        <@descr.description />

        <button class="btn btn-primary my-2" type="submit">Add</button>
    </form>
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
                    <th scope="col">Parent</th>
                    <th scope="col">Button</th>
                </tr>
            </thead>
            <tbody>
                <#list elements as e>
                    <#list e.groups as e_gr>
                    <#if my_group.id == e_gr.id || my_group.id == 0>
                        <tr>
                            <td><span>${e.name}</span></td>
                            <td><span>${e.description}</span></td>
                            <#if e.groups??>
                                <td>
                                    <select id="table_group">
                                        <#list e.groups as gr>
                                            <option>${gr.groupName}</option>
                                        <#else>
                                            <option>No Groups</option>
                                        </#list>
                                    </select>
                                </td>
                            <#else>
                                <td><span>&ltnone&gt</span></td>
                            </#if>

                            <#if e.parent??>
                                <td><span>${e.parent.name}</span></td>
                            <#else>
                                <td><span>&ltnone&gt</span></td>
                            </#if>
                            <td><a href="/elements/${e.id}">view</a></td>
                        <#else>
                            <b>No components!</b>
                        </tr>
                    </#if>
                    </#list>
                </#list>
            </tbody>
        </table>
    </div>

</#macro>