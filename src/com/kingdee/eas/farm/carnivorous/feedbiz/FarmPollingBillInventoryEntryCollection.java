package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmPollingBillInventoryEntryCollection extends AbstractObjectCollection 
{
    public FarmPollingBillInventoryEntryCollection()
    {
        super(FarmPollingBillInventoryEntryInfo.class);
    }
    public boolean add(FarmPollingBillInventoryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmPollingBillInventoryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmPollingBillInventoryEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmPollingBillInventoryEntryInfo get(int index)
    {
        return(FarmPollingBillInventoryEntryInfo)getObject(index);
    }
    public FarmPollingBillInventoryEntryInfo get(Object key)
    {
        return(FarmPollingBillInventoryEntryInfo)getObject(key);
    }
    public void set(int index, FarmPollingBillInventoryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmPollingBillInventoryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmPollingBillInventoryEntryInfo item)
    {
        return super.indexOf(item);
    }
}