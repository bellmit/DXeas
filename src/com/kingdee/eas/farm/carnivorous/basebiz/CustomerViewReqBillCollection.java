package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CustomerViewReqBillCollection extends AbstractObjectCollection 
{
    public CustomerViewReqBillCollection()
    {
        super(CustomerViewReqBillInfo.class);
    }
    public boolean add(CustomerViewReqBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CustomerViewReqBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CustomerViewReqBillInfo item)
    {
        return removeObject(item);
    }
    public CustomerViewReqBillInfo get(int index)
    {
        return(CustomerViewReqBillInfo)getObject(index);
    }
    public CustomerViewReqBillInfo get(Object key)
    {
        return(CustomerViewReqBillInfo)getObject(key);
    }
    public void set(int index, CustomerViewReqBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CustomerViewReqBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CustomerViewReqBillInfo item)
    {
        return super.indexOf(item);
    }
}