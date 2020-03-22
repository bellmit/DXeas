package com.kingdee.eas.custom.farmpolling;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PollingRecordBillCollection extends AbstractObjectCollection 
{
    public PollingRecordBillCollection()
    {
        super(PollingRecordBillInfo.class);
    }
    public boolean add(PollingRecordBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PollingRecordBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PollingRecordBillInfo item)
    {
        return removeObject(item);
    }
    public PollingRecordBillInfo get(int index)
    {
        return(PollingRecordBillInfo)getObject(index);
    }
    public PollingRecordBillInfo get(Object key)
    {
        return(PollingRecordBillInfo)getObject(key);
    }
    public void set(int index, PollingRecordBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PollingRecordBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PollingRecordBillInfo item)
    {
        return super.indexOf(item);
    }
}