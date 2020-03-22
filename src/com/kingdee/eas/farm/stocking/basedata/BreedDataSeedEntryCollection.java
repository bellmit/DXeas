package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedDataSeedEntryCollection extends AbstractObjectCollection 
{
    public BreedDataSeedEntryCollection()
    {
        super(BreedDataSeedEntryInfo.class);
    }
    public boolean add(BreedDataSeedEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedDataSeedEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedDataSeedEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedDataSeedEntryInfo get(int index)
    {
        return(BreedDataSeedEntryInfo)getObject(index);
    }
    public BreedDataSeedEntryInfo get(Object key)
    {
        return(BreedDataSeedEntryInfo)getObject(key);
    }
    public void set(int index, BreedDataSeedEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedDataSeedEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedDataSeedEntryInfo item)
    {
        return super.indexOf(item);
    }
}