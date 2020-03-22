package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCarSendBillEntryCollection extends AbstractObjectCollection 
{
    public CCarSendBillEntryCollection()
    {
        super(CCarSendBillEntryInfo.class);
    }
    public boolean add(CCarSendBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCarSendBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCarSendBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CCarSendBillEntryInfo get(int index)
    {
        return(CCarSendBillEntryInfo)getObject(index);
    }
    public CCarSendBillEntryInfo get(Object key)
    {
        return(CCarSendBillEntryInfo)getObject(key);
    }
    public void set(int index, CCarSendBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCarSendBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCarSendBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}