package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BEggCandlingBillEggEntryCollection extends AbstractObjectCollection 
{
    public BEggCandlingBillEggEntryCollection()
    {
        super(BEggCandlingBillEggEntryInfo.class);
    }
    public boolean add(BEggCandlingBillEggEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BEggCandlingBillEggEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BEggCandlingBillEggEntryInfo item)
    {
        return removeObject(item);
    }
    public BEggCandlingBillEggEntryInfo get(int index)
    {
        return(BEggCandlingBillEggEntryInfo)getObject(index);
    }
    public BEggCandlingBillEggEntryInfo get(Object key)
    {
        return(BEggCandlingBillEggEntryInfo)getObject(key);
    }
    public void set(int index, BEggCandlingBillEggEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BEggCandlingBillEggEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BEggCandlingBillEggEntryInfo item)
    {
        return super.indexOf(item);
    }
}