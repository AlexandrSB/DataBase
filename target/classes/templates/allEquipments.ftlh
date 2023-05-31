<#import "parts/common.ftlh" as c>
<#import "parts/elements.ftlh" as e>

<@c.page>

    <button class="btn btn-primary my-2" onclick="location.href = '/equipment';">Add</button>

    <div>
        <@e.equipCards />
    </div>
</@c.page>