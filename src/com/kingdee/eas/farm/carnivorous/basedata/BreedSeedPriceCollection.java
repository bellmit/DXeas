package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedSeedPriceCollection extends AbstractObjectCollection 
{
    public BreedSeedPriceCollection()
    {
        super(BreedSeedPriceInfo.class);
    }
    public boolean add(BreedSeedPriceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedSeedPriceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedSeedPriceInfo item)
    {
        return removeObject(item);
    }
    public BreedSeedPriceInfo get(int index)
    {
        return(BreedSeedPriceInfo)getObject(index);
    }
    public BreedSeedPriceInfo get(Object key)
    {
        return(BreedSeedPriceInfo)getObject(key);
    }
    public void set(int index, BreedSeedPriceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedSeedPriceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedSeedPriceInfo item)
    {
        return super.indexOf(item);
    }
}