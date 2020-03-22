package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CyxKbSettingCollection extends AbstractObjectCollection 
{
    public CyxKbSettingCollection()
    {
        super(CyxKbSettingInfo.class);
    }
    public boolean add(CyxKbSettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CyxKbSettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CyxKbSettingInfo item)
    {
        return removeObject(item);
    }
    public CyxKbSettingInfo get(int index)
    {
        return(CyxKbSettingInfo)getObject(index);
    }
    public CyxKbSettingInfo get(Object key)
    {
        return(CyxKbSettingInfo)getObject(key);
    }
    public void set(int index, CyxKbSettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CyxKbSettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CyxKbSettingInfo item)
    {
        return super.indexOf(item);
    }
}