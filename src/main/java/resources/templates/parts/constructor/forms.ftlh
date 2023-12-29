<#macro form
        id
        action
        method
        >

    <form action=${action} method=${method} id=id>
        <#nested>
    </form>

</#macro>

<#macro form_button
        id
        action
        method
        button_name
    >

    <form action=${action} method=${method} id=${id}>
        <#nested>
        <div class="d-grid gap-2 col-4 mx-auto">
            <button class="btn btn-primary my-2" type="submit">${button_name}</button>
        </div>
    </form>

</#macro>
