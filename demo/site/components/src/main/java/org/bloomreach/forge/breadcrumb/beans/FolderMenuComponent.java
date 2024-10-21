package org.bloomreach.forge.breadcrumb.beans;


import org.hippoecm.hst.component.support.bean.dynamic.BaseHstDynamicComponent;
import org.hippoecm.hst.content.beans.standard.HippoBean;
import org.hippoecm.hst.content.beans.standard.HippoFolder;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FolderMenuComponent extends BaseHstDynamicComponent {

    @Override
    public void doBeforeRender(HstRequest request, HstResponse response) {

        final Logger log = LoggerFactory.getLogger(FolderMenuComponent.class);
        HippoBean rootFolder = request.getRequestContext().getSiteContentBaseBean();

        List<HippoFolder> folders = new ArrayList<>();
        List<String> excludedFolders=Arrays.asList("banners","news","content","Component","Footer");
        List<HippoFolder> filteredFolders = new ArrayList<>();
        folders = rootFolder.getChildBeans(HippoFolder.class);
        if (!folders.isEmpty()) {
             for(HippoFolder folder:folders){
                if(!excludedFolders.contains(folder.getDisplayName())) {
                   log.info("Folder Name" + folder.getDisplayName());
                   filteredFolders.add(folder);
                }
         }
         request.setAttribute("folders", filteredFolders);
        }
    }
}
