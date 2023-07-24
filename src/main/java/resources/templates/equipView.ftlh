<#import "parts/common.ftlh" as com>

<@com.page>
    <div>
        <form method = "GET" action = "http://localhost:8080/addComponent?name=${equip.id}">
            <div class="form-row align-items-center">

                <div class="col-sm-10">
                    <h3 class="mb-2">${equip.type} ${equip.firmName} ${equip.model}</h3>
                    <input name="eq" value="${equip.id?c}" type="hidden"/>
                </div>

                <div class="col-auto">
                    <button class="btn btn-primary mb-2" type="submit" >Add Element</button>
                </div>

            </div>
        </form>

        <h5 class="align-self-center my-2">Components</h5>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Composite</th>
                    <th scope="col">Mechanic</th>
                    <th scope="col">Electronic</th>
                    <th scope="col">Electric</th>
                    <th scope="col">View</th>
                </tr>
            </thead>
            <tbody>
                <#list element as cp>
                <tr>
                    <td><span>${cp.name}</span></td>
                    <td>
                        <#if cp.description??>
                            <span>${cp.description}</span>
                        <#else>
                            <none>
                        </#if>
                    </td>
                    <td>
                         <#if cp.isComposite>
                             <span>True</span>
                         <#else>
                            <span>-</span>
                         </#if>
                    </td>
                    <td>
                         <#if cp.isMechanic>
                             <span>True</span>
                         <#else>
                            <span>-</span>
                         </#if>
                    </td>
                    <td>
                         <#if cp.isElectronic>
                             <span>True</span>
                         <#else>
                            <span>-</span>
                         </#if>
                    </td>
                    <td>
                         <#if cp.isElectric>
                             <span>True</span>
                         <#else>
                            <span>-</span>
                         </#if>
                    </td>
                    <td>
                        <a href="/components/${cp.id}">view</a>
                    </td>
                <#else>
                    <b>No components!</b>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</@com.page>
