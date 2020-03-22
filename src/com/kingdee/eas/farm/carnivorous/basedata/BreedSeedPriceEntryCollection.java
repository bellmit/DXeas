package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedSeedPriceEntryCollection extends AbstractObjectCollection 
{
    public BreedSeedPriceEntryCollection()
    {
        super(BreedSeedPriceEntryInfo.class);
    }
    public boolean add(BreedSeedPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedSeedPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedSeedPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedSeedPriceEntryInfo get(int index)
    {
        return(BreedSeedPriceEntryInfo)getObject(index);
    }
    public BreedSeedPriceEntryInfo get(Object key)
    {
        return(BreedSeedPriceEntryInfo)getObject(key);
    }
    public void set(int index, BreedSeedPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedSeedPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedSeedPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}