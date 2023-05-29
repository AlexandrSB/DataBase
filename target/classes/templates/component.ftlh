<#import "parts/common.ftlh" as c>
<#import "parts/elements.ftlh" as e>

<@c.page "Components">
    <a href="http://localhost:8080">Home</a>

    <div>
        <@e.equips />
    </div>

    <div>Addition</div>
    <div>
        <@e.comps />
    </div>
</@c.page>