package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmPollingBillCollection extends AbstractObjectCollection 
{
    public FarmPollingBillCollection()
    {
        super(FarmPollingBillInfo.class);
    }
    public boolean add(FarmPollingBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmPollingBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmPollingBillInfo item)
    {
        return removeObject(item);
    }
    public FarmPollingBillInfo get(int index)
    {
        return(FarmPollingBillInfo)getObject(index);
    }
    public FarmPollingBillInfo get(Object key)
    {
        return(FarmPollingBillInfo)getObject(key);
    }
    public void set(int index, FarmPollingBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmPollingBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmPollingBillInfo item)
    {
        return super.indexOf(item);
    }
}