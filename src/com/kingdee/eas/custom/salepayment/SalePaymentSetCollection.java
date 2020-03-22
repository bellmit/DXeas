package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SalePaymentSetCollection extends AbstractObjectCollection 
{
    public SalePaymentSetCollection()
    {
        super(SalePaymentSetInfo.class);
    }
    public boolean add(SalePaymentSetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SalePaymentSetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SalePaymentSetInfo item)
    {
        return removeObject(item);
    }
    public SalePaymentSetInfo get(int index)
    {
        return(SalePaymentSetInfo)getObject(index);
    }
    public SalePaymentSetInfo get(Object key)
    {
        return(SalePaymentSetInfo)getObject(key);
    }
    public void set(int index, SalePaymentSetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SalePaymentSetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SalePaymentSetInfo item)
    {
        return super.indexOf(item);
    }
}