package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HatchAdjustBillEggEntryCollection extends AbstractObjectCollection 
{
    public HatchAdjustBillEggEntryCollection()
    {
        super(HatchAdjustBillEggEntryInfo.class);
    }
    public boolean add(HatchAdjustBillEggEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HatchAdjustBillEggEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HatchAdjustBillEggEntryInfo item)
    {
        return removeObject(item);
    }
    public HatchAdjustBillEggEntryInfo get(int index)
    {
        return(HatchAdjustBillEggEntryInfo)getObject(index);
    }
    public HatchAdjustBillEggEntryInfo get(Object key)
    {
        return(HatchAdjustBillEggEntryInfo)getObject(key);
    }
    public void set(int index, HatchAdjustBillEggEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HatchAdjustBillEggEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HatchAdjustBillEggEntryInfo item)
    {
        return super.indexOf(item);
    }
}