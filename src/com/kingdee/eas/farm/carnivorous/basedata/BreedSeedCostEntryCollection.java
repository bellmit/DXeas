package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedSeedCostEntryCollection extends AbstractObjectCollection 
{
    public BreedSeedCostEntryCollection()
    {
        super(BreedSeedCostEntryInfo.class);
    }
    public boolean add(BreedSeedCostEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedSeedCostEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedSeedCostEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedSeedCostEntryInfo get(int index)
    {
        return(BreedSeedCostEntryInfo)getObject(index);
    }
    public BreedSeedCostEntryInfo get(Object key)
    {
        return(BreedSeedCostEntryInfo)getObject(key);
    }
    public void set(int index, BreedSeedCostEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedSeedCostEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedSeedCostEntryInfo item)
    {
        return super.indexOf(item);
    }
}