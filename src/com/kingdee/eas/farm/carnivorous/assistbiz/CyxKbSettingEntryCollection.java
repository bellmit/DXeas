package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CyxKbSettingEntryCollection extends AbstractObjectCollection 
{
    public CyxKbSettingEntryCollection()
    {
        super(CyxKbSettingEntryInfo.class);
    }
    public boolean add(CyxKbSettingEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CyxKbSettingEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CyxKbSettingEntryInfo item)
    {
        return removeObject(item);
    }
    public CyxKbSettingEntryInfo get(int index)
    {
        return(CyxKbSettingEntryInfo)getObject(index);
    }
    public CyxKbSettingEntryInfo get(Object key)
    {
        return(CyxKbSettingEntryInfo)getObject(key);
    }
    public void set(int index, CyxKbSettingEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CyxKbSettingEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CyxKbSettingEntryInfo item)
    {
        return super.indexOf(item);
    }
}