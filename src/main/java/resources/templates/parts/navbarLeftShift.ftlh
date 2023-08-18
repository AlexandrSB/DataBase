<#macro navbar_left_shift>

    <#if group??>
        <#list group as g>
            <li class="nav-item .offset-md-${g.level}">
                <#assign x = g.level?int>
                <#if x == 1>
                    <a class="nav-link" href="/element/${g.id}">${g.name}</a>
                <#elseif x == 2>
                    <a class="nav-link" href="/element/${g.id}">${"--" + g.name}</a>
                <#elseif x == 3>
                    <a class="nav-link" href="/element/${g.id}">${"----" + g.name}</a>
                <#elseif x == 4>
                    <a class="nav-link" href="/element/${g.id}">${"------" + g.name}</a>
                <#else>
                    <a class="nav-link" href="/element/${g.id}">${"??" + g.name}</a>
                </#if>
            </li>
        </#list>
    </#if>

</#macro>