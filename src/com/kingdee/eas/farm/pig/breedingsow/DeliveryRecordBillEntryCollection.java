package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DeliveryRecordBillEntryCollection extends AbstractObjectCollection 
{
    public DeliveryRecordBillEntryCollection()
    {
        super(DeliveryRecordBillEntryInfo.class);
    }
    public boolean add(DeliveryRecordBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DeliveryRecordBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DeliveryRecordBillEntryInfo item)
    {
        return removeObject(item);
    }
    public DeliveryRecordBillEntryInfo get(int index)
    {
        return(DeliveryRecordBillEntryInfo)getObject(index);
    }
    public DeliveryRecordBillEntryInfo get(Object key)
    {
        return(DeliveryRecordBillEntryInfo)getObject(key);
    }
    public void set(int index, DeliveryRecordBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DeliveryRecordBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DeliveryRecordBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}