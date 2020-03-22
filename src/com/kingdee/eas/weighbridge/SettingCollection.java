package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettingCollection extends AbstractObjectCollection 
{
    public SettingCollection()
    {
        super(SettingInfo.class);
    }
    public boolean add(SettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettingInfo item)
    {
        return removeObject(item);
    }
    public SettingInfo get(int index)
    {
        return(SettingInfo)getObject(index);
    }
    public SettingInfo get(Object key)
    {
        return(SettingInfo)getObject(key);
    }
    public void set(int index, SettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettingInfo item)
    {
        return super.indexOf(item);
    }
}