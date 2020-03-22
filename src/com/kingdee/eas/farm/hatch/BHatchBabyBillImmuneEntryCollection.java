package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BHatchBabyBillImmuneEntryCollection extends AbstractObjectCollection 
{
    public BHatchBabyBillImmuneEntryCollection()
    {
        super(BHatchBabyBillImmuneEntryInfo.class);
    }
    public boolean add(BHatchBabyBillImmuneEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BHatchBabyBillImmuneEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BHatchBabyBillImmuneEntryInfo item)
    {
        return removeObject(item);
    }
    public BHatchBabyBillImmuneEntryInfo get(int index)
    {
        return(BHatchBabyBillImmuneEntryInfo)getObject(index);
    }
    public BHatchBabyBillImmuneEntryInfo get(Object key)
    {
        return(BHatchBabyBillImmuneEntryInfo)getObject(key);
    }
    public void set(int index, BHatchBabyBillImmuneEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BHatchBabyBillImmuneEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BHatchBabyBillImmuneEntryInfo item)
    {
        return super.indexOf(item);
    }
}