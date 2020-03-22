package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedSeedBillEntryCollection extends AbstractObjectCollection 
{
    public BreedSeedBillEntryCollection()
    {
        super(BreedSeedBillEntryInfo.class);
    }
    public boolean add(BreedSeedBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedSeedBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedSeedBillEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedSeedBillEntryInfo get(int index)
    {
        return(BreedSeedBillEntryInfo)getObject(index);
    }
    public BreedSeedBillEntryInfo get(Object key)
    {
        return(BreedSeedBillEntryInfo)getObject(key);
    }
    public void set(int index, BreedSeedBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedSeedBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedSeedBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}