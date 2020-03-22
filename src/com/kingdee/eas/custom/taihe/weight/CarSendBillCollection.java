package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarSendBillCollection extends AbstractObjectCollection 
{
    public CarSendBillCollection()
    {
        super(CarSendBillInfo.class);
    }
    public boolean add(CarSendBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarSendBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarSendBillInfo item)
    {
        return removeObject(item);
    }
    public CarSendBillInfo get(int index)
    {
        return(CarSendBillInfo)getObject(index);
    }
    public CarSendBillInfo get(Object key)
    {
        return(CarSendBillInfo)getObject(key);
    }
    public void set(int index, CarSendBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarSendBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarSendBillInfo item)
    {
        return super.indexOf(item);
    }
}