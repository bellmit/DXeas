package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchBabyBillEntryCollection extends AbstractObjectCollection 
{
    public HatchBabyBillEntryCollection()
    {
        super(HatchBabyBillEntryInfo.class);
    }
    public boolean add(HatchBabyBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchBabyBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchBabyBillEntryInfo item)
    {
        return removeObject(item);
    }
    public HatchBabyBillEntryInfo get(int index)
    {
        return(HatchBabyBillEntryInfo)getObject(index);
    }
    public HatchBabyBillEntryInfo get(Object key)
    {
        return(HatchBabyBillEntryInfo)getObject(key);
    }
    public void set(int index, HatchBabyBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchBabyBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchBabyBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}