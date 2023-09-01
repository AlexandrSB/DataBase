<li class="nav-item">
    <a class="nav-link" href="/storage">Склад</a>
</li>

<li class="nav-item">
    <a class="nav-link" href="/element/0">Оборудование</a>
</li>

<#if nav??>
    <#list nav as n>
        <li class="nav-item">
            <a class="nav-link" href="/element/${n.id}">${n.groupName}</a>
        </li>
    <#else>
        <span>***</span>
    </#list>
</#if>