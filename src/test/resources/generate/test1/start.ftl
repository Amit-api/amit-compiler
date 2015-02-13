Start

<#list runtime.processTemplate("types","type.ftl","%s.java") as processed>
done: ${processed}
</#list>

End
