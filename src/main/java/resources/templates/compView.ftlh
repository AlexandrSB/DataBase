<#import "parts/common.ftlh" as c>
<#import "constructor/simple_element.ftlh" as se>

<@c.page>

    <h1 class="text-center">${elem.name}</h1>


    <form action="link_elements" method="post" id="link_elements">

        <input type="text" name="thisElement" value="${elem.id}" hidden="hidden">

        <@se.select_element_center
            element_name = "elementName"
            element_id = "my_id"
            label = "Component"
            placeholder = "Component Name"
            elements_array = elements
            elements_attr = "name"
        />

        <div class="form-group row justify-content-center">
            <label for="elementName" class="col-sm-2 col-form-label">Component : </label>
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
            <button class="btn btn-primary my-2" type="submit">Add equipment</button>
        </div>
    </form>

    <#list elem.groups as g>
        <span>Группы : </span>
        <ul>
            <li>
                <span>${g.groupName}</span>
            </li>
        </ul>
    <#else>
        <span>Группы не найдены</span>
    </#list>

    <br />
    <span>Содержит элементы : </span>
    <#list elem.elements_source as es>
        <ul>
            <li>
                <a href="/element/view/${es.id}">${es.name}</a>
            </li>
        </ul>
    <#else>
        <span>Нет элементов</span>
    </#list>

    <br />
    <span>Элемент для : </span>
    <#list elem.elements_destination as ed>
            <ul>
                <li>
                    <a href="/element/view/${ed.id}">${ed.name}</a>
                </li>
            </ul>
        <#else>
            <span>Нет оборудования</span>
    </#list>

</@c.page>