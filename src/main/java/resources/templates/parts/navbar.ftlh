<#import "equipmentNavbar.ftlh" as eq_navbar>
<#import "storageNavbar.ftlh" as st_navbar>
<#global show_navbar = 1>

<#if show_navbar = 1>
    <@eq_navbar.equipment_navbar />
<#else>
    <@st_navbar.storage_navbar />
</#if>