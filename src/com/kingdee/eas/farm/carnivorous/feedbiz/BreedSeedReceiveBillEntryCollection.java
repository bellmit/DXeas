package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedSeedReceiveBillEntryCollection extends AbstractObjectCollection 
{
    public BreedSeedReceiveBillEntryCollection()
    {
        super(BreedSeedReceiveBillEntryInfo.class);
    }
    public boolean add(BreedSeedReceiveBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedSeedReceiveBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedSeedReceiveBillEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedSeedReceiveBillEntryInfo get(int index)
    {
        return(BreedSeedReceiveBillEntryInfo)getObject(index);
    }
    public BreedSeedReceiveBillEntryInfo get(Object key)
    {
        return(BreedSeedReceiveBillEntryInfo)getObject(key);
    }
    public void set(int index, BreedSeedReceiveBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedSeedReceiveBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedSeedReceiveBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}