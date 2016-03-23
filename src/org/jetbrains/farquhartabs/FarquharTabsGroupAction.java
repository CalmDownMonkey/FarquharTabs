package org.jetbrains.farquhartabs;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.ToggleAction;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.fileEditor.impl.EditorWindow;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

import java.awt.*;

/**
 * Created by Will on 12/04/2015.
 */
public abstract class FarquharTabsGroupAction extends ToggleAction implements DumbAware {

    abstract Color getColour();
    abstract Color getFontColour();
    abstract String getColourName();

    @Override
    public boolean isSelected(AnActionEvent e) {
        return false;
    }

    @Override
    public void setSelected(AnActionEvent e, boolean state) {
        final Project project = e.getData(CommonDataKeys.PROJECT);
        final FileEditorManagerEx fileEditorManager = FileEditorManagerEx.getInstanceEx(project);

        final VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        final EditorWindow[] allWindows = fileEditorManager.getWindows();

        for(EditorWindow aWindow : allWindows){
            int index = aWindow.findFileIndex(file);
            if(index > -1){
                aWindow.getTabbedPane().setBackgroundColorAt(index, getColour());
                aWindow.getTabbedPane().setForegroundAt(index, getFontColour());
            }
        }

        FarquharTabsPersistenceService farquharTabsPersistenceService = ServiceManager.getService(project, FarquharTabsPersistenceService.class);
		if (this.getClass().equals(Default.class)) {
			farquharTabsPersistenceService.getMapValues().remove(file.toString());
		} else {
			farquharTabsPersistenceService.getMapValues().put(file.toString(), getColourName());
		}
    }

    public static class Red    extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.red.color;} Color getFontColour(){return FarquharColourMap.red.font;}  String getColourName() {return FarquharColourMap.red.name;}}
    public static class RedOrange    extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.redOrange.color;}  Color getFontColour(){return FarquharColourMap.redOrange.font;}    String getColourName() {return FarquharColourMap.redOrange.name;}}
    public static class Orange    extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.orange.color;}    Color getFontColour(){return FarquharColourMap.orange.font;}  String getColourName() {return FarquharColourMap.orange.name;}}
    public static class YellowOrange    extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.yellowOrange.color;}   Color getFontColour(){return FarquharColourMap.yellowOrange.font;}   String getColourName() {return FarquharColourMap.yellowOrange.name;}}
    public static class Yellow    extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.yellow.color;}   Color getFontColour(){return FarquharColourMap.yellow.font;}   String getColourName() {return FarquharColourMap.yellow.name;}}
    public static class YellowGreen    extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.yellowGreen.color;}   Color getFontColour(){return FarquharColourMap.yellowGreen.font;}   String getColourName() {return FarquharColourMap.yellowGreen.name;}}

    public static class Green   extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.green.color;} Color getFontColour(){return FarquharColourMap.green.font;}    String getColourName() {return FarquharColourMap.green.name;}}
    public static class BlueGreen   extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.blueGreen.color;}   Color getFontColour(){return FarquharColourMap.blueGreen.font;}  String getColourName() {return FarquharColourMap.blueGreen.name;}}
    public static class Blue   extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.blue.color;}   Color getFontColour(){return FarquharColourMap.blue.font;}  String getColourName() {return FarquharColourMap.blue.name;}}
    public static class BluePurple   extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.bluePurple.color;}   Color getFontColour(){return FarquharColourMap.bluePurple.font;}  String getColourName() {return FarquharColourMap.bluePurple.name;}}
    public static class Purple   extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.purple.color;}  Color getFontColour(){return FarquharColourMap.purple.font;}   String getColourName() {return FarquharColourMap.purple.name;}}
    public static class RedPurple   extends FarquharTabsGroupAction {Color getColour() {return FarquharColourMap.redPurple.color;}   Color getFontColour(){return FarquharColourMap.redPurple.font;}  String getColourName() {return FarquharColourMap.redPurple.name;}}
    
	public static class Default   extends FarquharTabsGroupAction {Color getColour() {return null;}   Color getFontColour(){return null;}  String getColourName() {return "Clear";}}

//    public static class Green extends FarquharTabsGroupAction {Color getColour() {return Color.green;}    String getColourName() {return "green";}}
//    public static class White  extends FarquharTabsGroupAction {Color getColour() {return Color.white;}    String getColourName() {return "white";}}
//    public static class Gray   extends FarquharTabsGroupAction {Color getColour() {return Color.gray;}     String getColourName() {return "gray";}}
}
