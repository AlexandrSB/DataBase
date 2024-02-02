
<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle"
       href="/element/0"
       role="button"
       data-bs-toggle="dropdown"
       aria-expanded="false"
    >Оборудование</a>

    <ul class="dropdown-menu dropdown-menu-dark">
        <li>
            <a class="dropdown-item" href="/element/0">Все оборудование</a>
        </li>
        <#if nav??>
            <#list nav as n>
                <li>
                    <a class="dropdown-item" href="/element/${n.id}">${n.name}</a>
                </li>
            <#else>
                <span>***</span>
            </#list>
        </#if>
    </ul>
</li>


<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle"
       href="/storage"
       role="button"
       data-bs-toggle="dropdown"
       aria-expanded="false"
    >Склад</a>

    <ul class="dropdown-menu dropdown-menu-dark">
        <li>
            <a class="dropdown-item" href="/storage">Storage menu</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/contragent">Contragent</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/storage">Storage</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/workshop">Workshop</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/goods">Goods</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/equipment">Equipment</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/arrival">Arrival Goods</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/expense">Expense Goods</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/contragents_party">Contragents party</a>
        </li>
    </ul>
</li>


<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle"
       href="/storage"
       role="button"
       data-bs-toggle="dropdown"
       aria-expanded="false"
    >Мастерская</a>

    <ul class="dropdown-menu dropdown-menu-dark">
        <li>
            <a class="dropdown-item" href="/workshop">Мастерская</a>
        </li>
        <li>
            <a class="dropdown-item" href="/workshop/repair">Ремонт</a>
        </li>
        <li>
            <a class="dropdown-item" href="/workshop/diagnostics">Диагностика</a>
        </li>
        <li>
            <a class="dropdown-item" href="/workshop/clearing">Чистка</a>
        </li>
    </ul>
</li>
