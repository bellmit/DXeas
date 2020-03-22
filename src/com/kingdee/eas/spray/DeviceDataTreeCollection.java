package com.kingdee.eas.spray;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DeviceDataTreeCollection extends AbstractObjectCollection 
{
    public DeviceDataTreeCollection()
    {
        super(DeviceDataTreeInfo.class);
    }
    public boolean add(DeviceDataTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DeviceDataTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DeviceDataTreeInfo item)
    {
        return removeObject(item);
    }
    public DeviceDataTreeInfo get(int index)
    {
        return(DeviceDataTreeInfo)getObject(index);
    }
    public DeviceDataTreeInfo get(Object key)
    {
        return(DeviceDataTreeInfo)getObject(key);
    }
    public void set(int index, DeviceDataTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DeviceDataTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DeviceDataTreeInfo item)
    {
        return super.indexOf(item);
    }
}