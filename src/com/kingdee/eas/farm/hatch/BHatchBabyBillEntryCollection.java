package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BHatchBabyBillEntryCollection extends AbstractObjectCollection 
{
    public BHatchBabyBillEntryCollection()
    {
        super(BHatchBabyBillEntryInfo.class);
    }
    public boolean add(BHatchBabyBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BHatchBabyBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BHatchBabyBillEntryInfo item)
    {
        return removeObject(item);
    }
    public BHatchBabyBillEntryInfo get(int index)
    {
        return(BHatchBabyBillEntryInfo)getObject(index);
    }
    public BHatchBabyBillEntryInfo get(Object key)
    {
        return(BHatchBabyBillEntryInfo)getObject(key);
    }
    public void set(int index, BHatchBabyBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BHatchBabyBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BHatchBabyBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}