package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SystemSettingCollection extends AbstractObjectCollection 
{
    public SystemSettingCollection()
    {
        super(SystemSettingInfo.class);
    }
    public boolean add(SystemSettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SystemSettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SystemSettingInfo item)
    {
        return removeObject(item);
    }
    public SystemSettingInfo get(int index)
    {
        return(SystemSettingInfo)getObject(index);
    }
    public SystemSettingInfo get(Object key)
    {
        return(SystemSettingInfo)getObject(key);
    }
    public void set(int index, SystemSettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SystemSettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SystemSettingInfo item)
    {
        return super.indexOf(item);
    }
}