package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BHatchBabyBillMatUserEntryCollection extends AbstractObjectCollection 
{
    public BHatchBabyBillMatUserEntryCollection()
    {
        super(BHatchBabyBillMatUserEntryInfo.class);
    }
    public boolean add(BHatchBabyBillMatUserEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BHatchBabyBillMatUserEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BHatchBabyBillMatUserEntryInfo item)
    {
        return removeObject(item);
    }
    public BHatchBabyBillMatUserEntryInfo get(int index)
    {
        return(BHatchBabyBillMatUserEntryInfo)getObject(index);
    }
    public BHatchBabyBillMatUserEntryInfo get(Object key)
    {
        return(BHatchBabyBillMatUserEntryInfo)getObject(key);
    }
    public void set(int index, BHatchBabyBillMatUserEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BHatchBabyBillMatUserEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BHatchBabyBillMatUserEntryInfo item)
    {
        return super.indexOf(item);
    }
}