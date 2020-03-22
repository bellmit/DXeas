package com.kingdee.eas.custom.farmpolling;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PollingRecordBillEntryCollection extends AbstractObjectCollection 
{
    public PollingRecordBillEntryCollection()
    {
        super(PollingRecordBillEntryInfo.class);
    }
    public boolean add(PollingRecordBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PollingRecordBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PollingRecordBillEntryInfo item)
    {
        return removeObject(item);
    }
    public PollingRecordBillEntryInfo get(int index)
    {
        return(PollingRecordBillEntryInfo)getObject(index);
    }
    public PollingRecordBillEntryInfo get(Object key)
    {
        return(PollingRecordBillEntryInfo)getObject(key);
    }
    public void set(int index, PollingRecordBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PollingRecordBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PollingRecordBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}