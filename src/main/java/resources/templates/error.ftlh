<#import "parts/common.ftlh" as c>

<@c.page>

    <h1>Something went wrong! </h1>
    <h2>Our Engineers are on it</h2>
    <span>${timestamp?datetime}</span>
    <br>
    <span>Error status: ${status}</span>
    <br>
    <span>${error}</span>
    <br>
    <span>Path: ${path}</span>
    <br>
    <a href="/">Go Home</a>

</@c.page>