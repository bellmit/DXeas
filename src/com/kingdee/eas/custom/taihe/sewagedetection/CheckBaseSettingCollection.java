package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckBaseSettingCollection extends AbstractObjectCollection 
{
    public CheckBaseSettingCollection()
    {
        super(CheckBaseSettingInfo.class);
    }
    public boolean add(CheckBaseSettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckBaseSettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckBaseSettingInfo item)
    {
        return removeObject(item);
    }
    public CheckBaseSettingInfo get(int index)
    {
        return(CheckBaseSettingInfo)getObject(index);
    }
    public CheckBaseSettingInfo get(Object key)
    {
        return(CheckBaseSettingInfo)getObject(key);
    }
    public void set(int index, CheckBaseSettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckBaseSettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckBaseSettingInfo item)
    {
        return super.indexOf(item);
    }
}