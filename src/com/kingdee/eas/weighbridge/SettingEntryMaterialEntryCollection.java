package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettingEntryMaterialEntryCollection extends AbstractObjectCollection 
{
    public SettingEntryMaterialEntryCollection()
    {
        super(SettingEntryMaterialEntryInfo.class);
    }
    public boolean add(SettingEntryMaterialEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettingEntryMaterialEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettingEntryMaterialEntryInfo item)
    {
        return removeObject(item);
    }
    public SettingEntryMaterialEntryInfo get(int index)
    {
        return(SettingEntryMaterialEntryInfo)getObject(index);
    }
    public SettingEntryMaterialEntryInfo get(Object key)
    {
        return(SettingEntryMaterialEntryInfo)getObject(key);
    }
    public void set(int index, SettingEntryMaterialEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettingEntryMaterialEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettingEntryMaterialEntryInfo item)
    {
        return super.indexOf(item);
    }
}