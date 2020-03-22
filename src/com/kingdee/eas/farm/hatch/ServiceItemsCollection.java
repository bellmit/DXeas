package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ServiceItemsCollection extends AbstractObjectCollection 
{
    public ServiceItemsCollection()
    {
        super(ServiceItemsInfo.class);
    }
    public boolean add(ServiceItemsInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ServiceItemsCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ServiceItemsInfo item)
    {
        return removeObject(item);
    }
    public ServiceItemsInfo get(int index)
    {
        return(ServiceItemsInfo)getObject(index);
    }
    public ServiceItemsInfo get(Object key)
    {
        return(ServiceItemsInfo)getObject(key);
    }
    public void set(int index, ServiceItemsInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ServiceItemsInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ServiceItemsInfo item)
    {
        return super.indexOf(item);
    }
}