package org.jetbrains.farquhartabs;

import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.fileEditor.impl.EditorTabColorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nullable;

import java.awt.*;

public class FarquharTabsColorProviderImpl implements EditorTabColorProvider {

    static{
        System.out.println("ClassLoader: FarquharTabsColorProviderImpl");
    }

    @Nullable
    @Override
    public Color getEditorTabColor(Project project, VirtualFile virtualFile) {
        FarquharTabsPersistenceService test = ServiceManager.getService(project, FarquharTabsPersistenceService.class);

        if(test.getMapValues().get(virtualFile.toString()) != null)
            try {
                return FarquharColourMap.valueOf(test.getMapValues().get(virtualFile.toString())).color;
            } catch (IllegalArgumentException e){
                System.out.println("No such colour " + test.getMapValues().get(virtualFile.toString()));
                return Color.gray;
            }
        else
            return Color.gray;
    }
}
