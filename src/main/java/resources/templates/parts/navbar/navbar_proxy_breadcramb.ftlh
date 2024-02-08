<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/${root}">${root_name}</a></li>
        <#list nav_breadcrumb as nb>
            <li class="breadcrumb-item">
                <a href="${nb[0]}">${nb[1]}</a>
            </li>
        </#list>
        <li class="breadcrumb-item active" aria-current="page">${last}</li>
    </ol>
</nav>
