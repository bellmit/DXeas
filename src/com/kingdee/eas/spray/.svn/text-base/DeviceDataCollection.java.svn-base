package com.kingdee.eas.spray;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DeviceDataCollection extends AbstractObjectCollection 
{
    public DeviceDataCollection()
    {
        super(DeviceDataInfo.class);
    }
    public boolean add(DeviceDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DeviceDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DeviceDataInfo item)
    {
        return removeObject(item);
    }
    public DeviceDataInfo get(int index)
    {
        return(DeviceDataInfo)getObject(index);
    }
    public DeviceDataInfo get(Object key)
    {
        return(DeviceDataInfo)getObject(key);
    }
    public void set(int index, DeviceDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DeviceDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DeviceDataInfo item)
    {
        return super.indexOf(item);
    }
}