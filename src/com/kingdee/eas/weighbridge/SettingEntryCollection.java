package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettingEntryCollection extends AbstractObjectCollection 
{
    public SettingEntryCollection()
    {
        super(SettingEntryInfo.class);
    }
    public boolean add(SettingEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettingEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettingEntryInfo item)
    {
        return removeObject(item);
    }
    public SettingEntryInfo get(int index)
    {
        return(SettingEntryInfo)getObject(index);
    }
    public SettingEntryInfo get(Object key)
    {
        return(SettingEntryInfo)getObject(key);
    }
    public void set(int index, SettingEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettingEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettingEntryInfo item)
    {
        return super.indexOf(item);
    }
}