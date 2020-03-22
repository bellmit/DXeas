package com.kingdee.eas.custom.farmpolling;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PollingRecordBillInventoryEntryCollection extends AbstractObjectCollection 
{
    public PollingRecordBillInventoryEntryCollection()
    {
        super(PollingRecordBillInventoryEntryInfo.class);
    }
    public boolean add(PollingRecordBillInventoryEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PollingRecordBillInventoryEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PollingRecordBillInventoryEntryInfo item)
    {
        return removeObject(item);
    }
    public PollingRecordBillInventoryEntryInfo get(int index)
    {
        return(PollingRecordBillInventoryEntryInfo)getObject(index);
    }
    public PollingRecordBillInventoryEntryInfo get(Object key)
    {
        return(PollingRecordBillInventoryEntryInfo)getObject(key);
    }
    public void set(int index, PollingRecordBillInventoryEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PollingRecordBillInventoryEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PollingRecordBillInventoryEntryInfo item)
    {
        return super.indexOf(item);
    }
}