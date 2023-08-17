<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="/">My Project</a>
  <button
    class="navbar-toggler"
    type="button"
    data-toggle="collapse"
    data-target="#navbarCollapse"
    aria-controls="navbarCollapse"
    aria-expanded="false"
    aria-label="Toggle navigation"
  >
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav mr-auto sidenav" id="navAccordion">

      <li class="nav-item active">
        <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
      </li>

      <#if group??>
        <#list group as g>
          <#if g.level == 1>
            <li class="nav-item">
              <a class="nav-link" href="/element/${g.id}">${g.name}</a>
            </li>
          </#if>

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
            </ul>
          </li>
        </#list>
      </#if>

      <br>

      <li class="nav-item">
        <a class="nav-link" href="#">Item 1</a>
      </li>

      <li class="nav-item">
        <a
          class="nav-link nav-link-collapse"
          href="#"
          id="hasSubItems"
          data-toggle="collapse"
          data-target="#collapseSubItems2"
          aria-controls="collapseSubItems2"
          aria-expanded="false"
        >Item 2</a>

        <ul class="nav-second-level collapse" id="collapseSubItems2" data-parent="#navAccordion">

          <li class="nav-item">
            <a class="nav-link" href="#">
              <span class="nav-link-text">Item 2.1</span>
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="#">
              <span class="nav-link-text">Item 2.2</span>
            </a>
          </li>

        </ul>
      </li>

      <li class="nav-item">
        <a class="nav-link" href="#">Item 3</a>
      </li>

      <li class="nav-item">

        <a
          class="nav-link nav-link-collapse"
          href="#"
          id="hasSubItems"
          data-toggle="collapse"
          data-target="#collapseSubItems4"
          aria-controls="collapseSubItems4"
          aria-expanded="false"
        >Item 4</a>

        <ul class="nav-second-level collapse" id="collapseSubItems4" data-parent="#navAccordion">

          <li class="nav-item">
            <a class="nav-link" href="#">
              <span class="nav-link-text">Item 4.1</span>
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="#">
              <span class="nav-link-text">Item 4.2</span>
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="#">
              <span class="nav-link-text">Item 4.2</span>
            </a>
          </li>

        </ul>
      </li>

    </ul>

    <form class="form-inline ml-auto mt-2 mt-md-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>

  </div>
</nav>

<head>
    <link rel="stylesheet" href="/css/navbarEquipment.css">
</head>