<!--<#import "navbarEquipLeftShift.ftlh" as nls>-->
<!--<#import "navbarEquipCollapse.ftlh" as nec>-->
<!--<#import "navbarEquipSimple.ftlh" as nes>-->

<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="/">My Project</a>

  <h3 class="navbar-text mx-auto">Header</h3>

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

      <!-- <@nls.navbar_equip_left_shift /> -->
      <!-- <@nec.navbar_equip_collapse /> -->
<!--      <@nes.navbar_equip_simple />-->

      <#include "navbar/navbar_upper.ftlh">

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