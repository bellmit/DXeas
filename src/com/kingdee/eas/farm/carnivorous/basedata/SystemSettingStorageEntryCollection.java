package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SystemSettingStorageEntryCollection extends AbstractObjectCollection 
{
    public SystemSettingStorageEntryCollection()
    {
        super(SystemSettingStorageEntryInfo.class);
    }
    public boolean add(SystemSettingStorageEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SystemSettingStorageEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SystemSettingStorageEntryInfo item)
    {
        return removeObject(item);
    }
    public SystemSettingStorageEntryInfo get(int index)
    {
        return(SystemSettingStorageEntryInfo)getObject(index);
    }
    public SystemSettingStorageEntryInfo get(Object key)
    {
        return(SystemSettingStorageEntryInfo)getObject(key);
    }
    public void set(int index, SystemSettingStorageEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SystemSettingStorageEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SystemSettingStorageEntryInfo item)
    {
        return super.indexOf(item);
    }
}