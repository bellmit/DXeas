package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DiscountRecordBillCollection extends AbstractObjectCollection 
{
    public DiscountRecordBillCollection()
    {
        super(DiscountRecordBillInfo.class);
    }
    public boolean add(DiscountRecordBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DiscountRecordBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DiscountRecordBillInfo item)
    {
        return removeObject(item);
    }
    public DiscountRecordBillInfo get(int index)
    {
        return(DiscountRecordBillInfo)getObject(index);
    }
    public DiscountRecordBillInfo get(Object key)
    {
        return(DiscountRecordBillInfo)getObject(key);
    }
    public void set(int index, DiscountRecordBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DiscountRecordBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DiscountRecordBillInfo item)
    {
        return super.indexOf(item);
    }
}