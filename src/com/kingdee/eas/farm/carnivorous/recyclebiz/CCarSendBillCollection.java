package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCarSendBillCollection extends AbstractObjectCollection 
{
    public CCarSendBillCollection()
    {
        super(CCarSendBillInfo.class);
    }
    public boolean add(CCarSendBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCarSendBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCarSendBillInfo item)
    {
        return removeObject(item);
    }
    public CCarSendBillInfo get(int index)
    {
        return(CCarSendBillInfo)getObject(index);
    }
    public CCarSendBillInfo get(Object key)
    {
        return(CCarSendBillInfo)getObject(key);
    }
    public void set(int index, CCarSendBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCarSendBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCarSendBillInfo item)
    {
        return super.indexOf(item);
    }
}