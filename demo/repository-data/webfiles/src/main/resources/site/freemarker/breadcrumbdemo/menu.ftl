<#include "../include/imports.ftl">

<#assign folders = hstRequest.getAttribute("folders") />

<div>
	<#list folders as folder>
					<@hst.link var="link" hippobean=folder fullyQualified=true />
					1111<a href="${link}">${folder.displayName}</a>
<br>
						<#list folder.getFolders() as subfolder>
	        <@hst.link var="sublink" hippobean=subfolder fullyQualified=true />
								222222<a href="${sublink}">${subfolder.displayName}</a>
								<br>
			                         <#list subfolder.getFolders() as subsubfolder>
                                                 <@hst.link var="subsublink" hippobean=subsubfolder fullyQualified=true />
                                               								33333333<a href="${subsublink}">${subsubfolder.displayName}</a>
                                               								</#list>
                                               								</#list>
                                               								</#list>

                                               								</div>