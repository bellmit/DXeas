package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SeedBillEntryCollection extends AbstractObjectCollection 
{
    public SeedBillEntryCollection()
    {
        super(SeedBillEntryInfo.class);
    }
    public boolean add(SeedBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SeedBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SeedBillEntryInfo item)
    {
        return removeObject(item);
    }
    public SeedBillEntryInfo get(int index)
    {
        return(SeedBillEntryInfo)getObject(index);
    }
    public SeedBillEntryInfo get(Object key)
    {
        return(SeedBillEntryInfo)getObject(key);
    }
    public void set(int index, SeedBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SeedBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SeedBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}