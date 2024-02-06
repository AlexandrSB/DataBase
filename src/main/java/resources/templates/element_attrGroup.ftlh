<#import "parts/common.ftlh" as c />
<#import "parts/constructor/simple_element.ftlh" as se />

<@c.page>
    <@se.header_1
        title = proxy.name
        />

    <@se.header_2
        title = attrGroup.name
        />

    <#list  attrGroup.attributes as a>
        <ul>
            <li>${a.name} -- ${a.attributeValue.name}
                <#if a.attributeValue.unit.unitDictionary.name != "<none>">
                    ${a.attributeValue.unit.unitDictionary.name}
                </#if>
            </li>
        </ul>
    </#list>
</@c.page>
