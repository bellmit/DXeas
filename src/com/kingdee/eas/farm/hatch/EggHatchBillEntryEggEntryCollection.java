package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggHatchBillEntryEggEntryCollection extends AbstractObjectCollection 
{
    public EggHatchBillEntryEggEntryCollection()
    {
        super(EggHatchBillEntryEggEntryInfo.class);
    }
    public boolean add(EggHatchBillEntryEggEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggHatchBillEntryEggEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggHatchBillEntryEggEntryInfo item)
    {
        return removeObject(item);
    }
    public EggHatchBillEntryEggEntryInfo get(int index)
    {
        return(EggHatchBillEntryEggEntryInfo)getObject(index);
    }
    public EggHatchBillEntryEggEntryInfo get(Object key)
    {
        return(EggHatchBillEntryEggEntryInfo)getObject(key);
    }
    public void set(int index, EggHatchBillEntryEggEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggHatchBillEntryEggEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggHatchBillEntryEggEntryInfo item)
    {
        return super.indexOf(item);
    }
}