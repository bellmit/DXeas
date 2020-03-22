package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BHatchBabyBillGoEntryCollection extends AbstractObjectCollection 
{
    public BHatchBabyBillGoEntryCollection()
    {
        super(BHatchBabyBillGoEntryInfo.class);
    }
    public boolean add(BHatchBabyBillGoEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BHatchBabyBillGoEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BHatchBabyBillGoEntryInfo item)
    {
        return removeObject(item);
    }
    public BHatchBabyBillGoEntryInfo get(int index)
    {
        return(BHatchBabyBillGoEntryInfo)getObject(index);
    }
    public BHatchBabyBillGoEntryInfo get(Object key)
    {
        return(BHatchBabyBillGoEntryInfo)getObject(key);
    }
    public void set(int index, BHatchBabyBillGoEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BHatchBabyBillGoEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BHatchBabyBillGoEntryInfo item)
    {
        return super.indexOf(item);
    }
}