
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
        <li>
            <a class="dropdown-item" href="/element/1">Оргтехника</a>
        </li>
        <li>
            <a class="dropdown-item" href="/element/2">Компьютеры</a>
        </li>
        <li>
            <a class="dropdown-item" href="/element/3">Мониторы</a>
        </li>
        <li>
            <a class="dropdown-item" href="/element/4">Компоненты</a>
        </li>
        <li>
            <a class="dropdown-item" href="/element/5">ИБП</a>
        </li>
        <li>
            <a class="dropdown-item" href="/element/6">Торговое оборудование</a>
        </li>
        <li>
            <a class="dropdown-item" href="/element/7">Расходные материалы</a>
        </li>
<!--        <#if nav??>-->
<!--            <#list nav as n>-->
<!--                <li>-->
<!--                    <a class="dropdown-item" href="/element/${n.id}">${n.name}</a>-->
<!--                </li>-->
<!--            <#else>-->
<!--                <span>***</span>-->
<!--            </#list>-->
<!--        </#if>-->
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
            <a class="dropdown-item" href="/storage/contragent">Контрагент</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/storage">Склад</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/workshop">Мастерская</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/goods">Товары</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/equipment">Оборудование</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/arrival">Приход товара</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/expense">Расход товара</a>
        </li>
        <li>
            <a class="dropdown-item" href="/storage/contragents_party">Контрагент партия</a>
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
            <a class="dropdown-item" href="/workshop">Оборудование в ремонте</a>
        </li>
        <li>
            <a class="dropdown-item" href="/workshop/awaiting">Оборудование в ожидании ремонта</a>
        </li>
    </ul>
</li>
