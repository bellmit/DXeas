package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DeliveryRecordBillCollection extends AbstractObjectCollection 
{
    public DeliveryRecordBillCollection()
    {
        super(DeliveryRecordBillInfo.class);
    }
    public boolean add(DeliveryRecordBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DeliveryRecordBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DeliveryRecordBillInfo item)
    {
        return removeObject(item);
    }
    public DeliveryRecordBillInfo get(int index)
    {
        return(DeliveryRecordBillInfo)getObject(index);
    }
    public DeliveryRecordBillInfo get(Object key)
    {
        return(DeliveryRecordBillInfo)getObject(key);
    }
    public void set(int index, DeliveryRecordBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DeliveryRecordBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DeliveryRecordBillInfo item)
    {
        return super.indexOf(item);
    }
}