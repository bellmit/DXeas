package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedSeedReceiveBillCollection extends AbstractObjectCollection 
{
    public BreedSeedReceiveBillCollection()
    {
        super(BreedSeedReceiveBillInfo.class);
    }
    public boolean add(BreedSeedReceiveBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedSeedReceiveBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedSeedReceiveBillInfo item)
    {
        return removeObject(item);
    }
    public BreedSeedReceiveBillInfo get(int index)
    {
        return(BreedSeedReceiveBillInfo)getObject(index);
    }
    public BreedSeedReceiveBillInfo get(Object key)
    {
        return(BreedSeedReceiveBillInfo)getObject(key);
    }
    public void set(int index, BreedSeedReceiveBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedSeedReceiveBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedSeedReceiveBillInfo item)
    {
        return super.indexOf(item);
    }
}