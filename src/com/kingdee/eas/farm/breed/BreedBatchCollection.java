package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedBatchCollection extends AbstractObjectCollection 
{
    public BreedBatchCollection()
    {
        super(BreedBatchInfo.class);
    }
    public boolean add(BreedBatchInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedBatchCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedBatchInfo item)
    {
        return removeObject(item);
    }
    public BreedBatchInfo get(int index)
    {
        return(BreedBatchInfo)getObject(index);
    }
    public BreedBatchInfo get(Object key)
    {
        return(BreedBatchInfo)getObject(key);
    }
    public void set(int index, BreedBatchInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedBatchInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedBatchInfo item)
    {
        return super.indexOf(item);
    }
}