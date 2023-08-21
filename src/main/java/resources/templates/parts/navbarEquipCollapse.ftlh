<#macro navbar_equip_collapse>

<#if group??>
    <#list group as g>
        <#if g.level == 1>
            <li class="nav-item">
                <a class="nav-link" href="/element/${g.id}">${g.name}</a>
            </li>
        </#if>

        <#if g.parent_id??>
            <#if g.level == 2>
                <li class="nav-item">
                    <a
                            class="nav-link nav-link-collapse"
                            href="/element/${g.id}"
                            id="hasSubItems"
                            data-toggle="collapse"
                            data-target="#nav${g.id}"
                            aria-controls="nav${g.id}"
                            aria-expanded="false"
                    >${g.name}</a>

                    <ul class="nav-second-level collapse" id="nav${g.id}" data-parent="#navAccordion">
                        <#if g.parent_id == 5>

                            <li class="nav-item">
                                <a class="nav-link" href="/element/${g.id}">
                                    <span class="nav-link-text">${g.name}</span>
                                </a>
                            </li>

                            <ul class="nav-third-level collapse" id="3${g.id}" data-parent="#nav${g.id}">

                                <li class="nav-item">
                                    <#if g.level == 4>
                                        <a class="nav-link" href="/element/${g.id}">
                                            <span class="nav-link-text">${g.name}</span>
                                        </a>
                                    </#if>
                                </li>

                            </ul>
                        </#if>
                    </ul>
                </li>
            </#if>

            <#if g.id == 7 || g.parent_id == 7>
                <li class="nav-item">
                    <#if g.id == 7>
                        <a
                                class="nav-link nav-link-collapse"
                                href="#"
                                id="hasSubItems"
                                data-toggle="collapse"
                                data-target="#nav${g.id}"
                                aria-controls="nav${g.id}"
                                aria-expanded="false"
                        >${g.name}</a>
                    </#if>

                    <ul class="nav-second-level collapse" id="nav${g.id}" data-parent="#navAccordion">
                        <#if g.parent_id == 7>

                            <li class="nav-item">
                                <a class="nav-link" href="/element/${g.id}">
                                    <span class="nav-link-text">${g.name}</span>
                                </a>
                            </li>

                            <ul class="nav-third-level collapse" id="3${g.id}" data-parent="#nav${g.id}">

                                <li class="nav-item">
                                    <#if g.level == 4>
                                        <a class="nav-link" href="/element/${g.id}">
                                            <span class="nav-link-text">${g.name}</span>
                                        </a>
                                    </#if>
                                </li>

                            </ul>
                        </#if>
                    </ul>
                </li>
            </#if>
        </#if>
    </#list>
</#if>

</#macro>