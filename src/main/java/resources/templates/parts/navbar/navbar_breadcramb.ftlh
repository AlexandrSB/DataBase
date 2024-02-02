<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">Home</a></li>
        <#list nav_breadcrumb as nb>
            <li class="breadcrumb-item"><a href="/element/${nb.id}">${nb.name}</a></li>
        </#list>
            <li class="breadcrumb-item active" aria-current="page">${my_group.name}</li>
    </ol>
</nav>