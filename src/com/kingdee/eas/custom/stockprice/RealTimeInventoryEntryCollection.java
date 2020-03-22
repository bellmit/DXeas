package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RealTimeInventoryEntryCollection extends AbstractObjectCollection 
{
    public RealTimeInventoryEntryCollection()
    {
        super(RealTimeInventoryEntryInfo.class);
    }
    public boolean add(RealTimeInventoryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RealTimeInventoryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RealTimeInventoryEntryInfo item)
    {
        return removeObject(item);
    }
    public RealTimeInventoryEntryInfo get(int index)
    {
        return(RealTimeInventoryEntryInfo)getObject(index);
    }
    public RealTimeInventoryEntryInfo get(Object key)
    {
        return(RealTimeInventoryEntryInfo)getObject(key);
    }
    public void set(int index, RealTimeInventoryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RealTimeInventoryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RealTimeInventoryEntryInfo item)
    {
        return super.indexOf(item);
    }
}