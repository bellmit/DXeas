package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DataBaseSettingCollection extends AbstractObjectCollection 
{
    public DataBaseSettingCollection()
    {
        super(DataBaseSettingInfo.class);
    }
    public boolean add(DataBaseSettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DataBaseSettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DataBaseSettingInfo item)
    {
        return removeObject(item);
    }
    public DataBaseSettingInfo get(int index)
    {
        return(DataBaseSettingInfo)getObject(index);
    }
    public DataBaseSettingInfo get(Object key)
    {
        return(DataBaseSettingInfo)getObject(key);
    }
    public void set(int index, DataBaseSettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DataBaseSettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DataBaseSettingInfo item)
    {
        return super.indexOf(item);
    }
}