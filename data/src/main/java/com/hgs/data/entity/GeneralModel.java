package com.hgs.data.entity;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.TableInfo;
import com.activeandroid.annotation.Column;
import com.hgs.data.entity.model.ChangeState;

import java.lang.reflect.Field;

public abstract class GeneralModel extends Model {
    protected GeneralModel()
    {
        super();
        if (State == null){
            State = ChangeState.UNCHANGED;
        }
    }
    @com.fasterxml.jackson.annotation.JsonProperty("LocalId")
    protected int LocalId;

    @com.fasterxml.jackson.annotation.JsonProperty("State")
    @Column
    public ChangeState State;

    public boolean IsSelected;

    @Column
    public int RemoteId;

    public void setAaId(Long id) {
        try {
            Field idField = Model.class.getDeclaredField("mId");
            idField.setAccessible(true);
            idField.set(this, id);
        } catch (Exception e) {
            throw new RuntimeException("Reflection failed to get the Active Android ID", e);
        }
    }

    public static void truncate(Class<? extends Model> type){
        TableInfo tableInfo = Cache.getTableInfo(type);
        ActiveAndroid.execSQL(
                String.format("DELETE FROM %s;",
                        tableInfo.getTableName()));
        ActiveAndroid.execSQL(
                String.format("DELETE FROM sqlite_sequence WHERE name='%s';",
                        tableInfo.getTableName()));
    }

    public int getLocalId() {
        return LocalId;
    }

    public void setLocalId(int localId) {
        LocalId = localId;
    }

    public int getRemoteId(){
        return RemoteId;
    }
}
