<#import "parts/common.ftlh" as c>

<@c.page>
    <a href="http://localhost:8080">Home</a>
    <div>
        <form method="post" action="equipments">
            <select class="form-control" id="firma" name="firmName">
                <#list firmas as firma>
                <option>${firma}</option>
                </#list>
            </select>

            <input type="text" name="myModel" placeholder="Model"></br>
            <select class="form-control" id="model" name="type">
                <#list types as type>
                    <option>${type}</option>
                </#list>
            </select>

            <button type="submit">Add</button>
        </form>
    </div>

    <div>Addition</div><br>
    <#list equipments as equip>
        <div>
            <b>${equip.id}</b>
            <span>${equip.firmName}</span>
            <span>${equip.model}</span>
            <i>${equip.type}</i><br>
        </div>
    </#list>
</@c.page>