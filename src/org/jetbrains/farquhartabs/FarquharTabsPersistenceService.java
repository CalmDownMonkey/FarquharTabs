package org.jetbrains.farquhartabs;

import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;

import java.util.HashMap;

import java.util.Map;

@State(
        name = "TabColorSettings",
        storages = @Storage(id="default", file = StoragePathMacros.WORKSPACE_FILE)
)
public class FarquharTabsPersistenceService implements PersistentStateComponent<FarquharTabsPersistenceService> {

    private Map<String, String> mapValues;

    public FarquharTabsPersistenceService() {
        mapValues = new HashMap<>();
    }

    public Map<String, String> getMapValues() { return mapValues; }

    public void setMapValues(Map<String, String> mapValues) { this.mapValues = mapValues; }

    public void loadState(FarquharTabsPersistenceService state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public FarquharTabsPersistenceService getState() {
        return this;
    }
}