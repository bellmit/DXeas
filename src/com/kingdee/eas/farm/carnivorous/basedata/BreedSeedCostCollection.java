package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedSeedCostCollection extends AbstractObjectCollection 
{
    public BreedSeedCostCollection()
    {
        super(BreedSeedCostInfo.class);
    }
    public boolean add(BreedSeedCostInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedSeedCostCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedSeedCostInfo item)
    {
        return removeObject(item);
    }
    public BreedSeedCostInfo get(int index)
    {
        return(BreedSeedCostInfo)getObject(index);
    }
    public BreedSeedCostInfo get(Object key)
    {
        return(BreedSeedCostInfo)getObject(key);
    }
    public void set(int index, BreedSeedCostInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedSeedCostInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedSeedCostInfo item)
    {
        return super.indexOf(item);
    }
}