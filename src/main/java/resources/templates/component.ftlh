<#import "parts/common.ftlh" as c>
<#import "parts/componentParts.ftlh" as cp>

<@c.page "Components">
    <div>
        <@cp.addComponent />
    </div>

    <h5 class"my-2">Addition</h5>
    <div>
        <@cp.componentCard />
    </div>
</@c.page>