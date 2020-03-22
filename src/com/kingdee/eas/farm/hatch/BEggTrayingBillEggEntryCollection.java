package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BEggTrayingBillEggEntryCollection extends AbstractObjectCollection 
{
    public BEggTrayingBillEggEntryCollection()
    {
        super(BEggTrayingBillEggEntryInfo.class);
    }
    public boolean add(BEggTrayingBillEggEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BEggTrayingBillEggEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BEggTrayingBillEggEntryInfo item)
    {
        return removeObject(item);
    }
    public BEggTrayingBillEggEntryInfo get(int index)
    {
        return(BEggTrayingBillEggEntryInfo)getObject(index);
    }
    public BEggTrayingBillEggEntryInfo get(Object key)
    {
        return(BEggTrayingBillEggEntryInfo)getObject(key);
    }
    public void set(int index, BEggTrayingBillEggEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BEggTrayingBillEggEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BEggTrayingBillEggEntryInfo item)
    {
        return super.indexOf(item);
    }
}