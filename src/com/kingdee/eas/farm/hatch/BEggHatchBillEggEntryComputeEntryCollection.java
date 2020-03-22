package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BEggHatchBillEggEntryComputeEntryCollection extends AbstractObjectCollection 
{
    public BEggHatchBillEggEntryComputeEntryCollection()
    {
        super(BEggHatchBillEggEntryComputeEntryInfo.class);
    }
    public boolean add(BEggHatchBillEggEntryComputeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BEggHatchBillEggEntryComputeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BEggHatchBillEggEntryComputeEntryInfo item)
    {
        return removeObject(item);
    }
    public BEggHatchBillEggEntryComputeEntryInfo get(int index)
    {
        return(BEggHatchBillEggEntryComputeEntryInfo)getObject(index);
    }
    public BEggHatchBillEggEntryComputeEntryInfo get(Object key)
    {
        return(BEggHatchBillEggEntryComputeEntryInfo)getObject(key);
    }
    public void set(int index, BEggHatchBillEggEntryComputeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BEggHatchBillEggEntryComputeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BEggHatchBillEggEntryComputeEntryInfo item)
    {
        return super.indexOf(item);
    }
}