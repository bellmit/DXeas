package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RealTimeInventoryCollection extends AbstractObjectCollection 
{
    public RealTimeInventoryCollection()
    {
        super(RealTimeInventoryInfo.class);
    }
    public boolean add(RealTimeInventoryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RealTimeInventoryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RealTimeInventoryInfo item)
    {
        return removeObject(item);
    }
    public RealTimeInventoryInfo get(int index)
    {
        return(RealTimeInventoryInfo)getObject(index);
    }
    public RealTimeInventoryInfo get(Object key)
    {
        return(RealTimeInventoryInfo)getObject(key);
    }
    public void set(int index, RealTimeInventoryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RealTimeInventoryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RealTimeInventoryInfo item)
    {
        return super.indexOf(item);
    }
}