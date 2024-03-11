<#macro type_of_operation operation_type >
    <#if repair_cards_of_modules?has_content>
    <ul>
        <#list repair_cards_of_modules as rcom>
        <li>
            <span>${rcom.workshopModule.name}</span>
            <ul>
                <#list rcom.consumptionOfMaterials as com>
                    <#list type_of_operations as too>
                    <#if too.completedWork == com.completedWork &&
                        too.operationType == operation_type>
                        <#if com.typeOfSparePart??>
                            <li><span>${com.completedWork.notation} -- ${com.quantityOfMaterial!"none"} ${com.typeOfSparePart.name}</span></li>
                        <#else>
                            <li><span>${com.completedWork.notation}</span></li>
                        </#if>
                    </#if>
                    </#list>
                </#list>
            </ul>
        </li>
        </#list>
    </ul>
    </#if>
</#macro>