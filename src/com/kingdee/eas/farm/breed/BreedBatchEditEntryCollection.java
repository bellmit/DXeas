package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedBatchEditEntryCollection extends AbstractObjectCollection 
{
    public BreedBatchEditEntryCollection()
    {
        super(BreedBatchEditEntryInfo.class);
    }
    public boolean add(BreedBatchEditEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedBatchEditEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedBatchEditEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedBatchEditEntryInfo get(int index)
    {
        return(BreedBatchEditEntryInfo)getObject(index);
    }
    public BreedBatchEditEntryInfo get(Object key)
    {
        return(BreedBatchEditEntryInfo)getObject(key);
    }
    public void set(int index, BreedBatchEditEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedBatchEditEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedBatchEditEntryInfo item)
    {
        return super.indexOf(item);
    }
}