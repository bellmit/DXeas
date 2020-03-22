package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SowRentoutBillCollection extends AbstractObjectCollection 
{
    public SowRentoutBillCollection()
    {
        super(SowRentoutBillInfo.class);
    }
    public boolean add(SowRentoutBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SowRentoutBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SowRentoutBillInfo item)
    {
        return removeObject(item);
    }
    public SowRentoutBillInfo get(int index)
    {
        return(SowRentoutBillInfo)getObject(index);
    }
    public SowRentoutBillInfo get(Object key)
    {
        return(SowRentoutBillInfo)getObject(key);
    }
    public void set(int index, SowRentoutBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SowRentoutBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SowRentoutBillInfo item)
    {
        return super.indexOf(item);
    }
}