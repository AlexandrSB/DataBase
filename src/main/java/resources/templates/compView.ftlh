<#import "parts/common.ftlh" as c>

<@c.page>

    <h1 class="text-center">${elem.name}</h1>


    <form action="link_elements" method="post" id="link_elements">

        <input type="text" name="thisElement" value="${elem.id}" hidden="hidden">

        <div class="form-group row justify-content-center">
            <label for="elements" class="col-sm-2 col-form-label">Component : </label>
            <div class="col-sm-6">
                <select class="form-control" id="model" name="elementName">
                    <#list elements as e>
                        <option>${e.name}</option>
                    </#list>
                </select>
            </div>
        </div>

<!--        <div class="form-group row justify-content-center">-->
<!--            <label for="element" class="col-sm-2 col-form-label">Component : </label>-->
<!--            <div class="col-sm-6">-->
<!--                <input class="form-control" type="text" name="elementName"-->
<!--                       placeholder="componentName" id="element" >-->
<!--            </div>-->
<!--        </div>-->

        <div class="d-grid gap-2 col-4 mx-auto">
            <button class="btn btn-primary my-2" type="submit">Add</button>
        </div>
    </form>

    <#list elem.groups as g>
        <span>Группы: </span>
        <ul>
            <li>
                <span>${g.groupName}</span>
            </li>
        </ul>
    <#else>
        <span>Группы не найдены</span>
    </#list>

</@c.page>