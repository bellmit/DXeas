package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ParentBreedBatchCollection extends AbstractObjectCollection 
{
    public ParentBreedBatchCollection()
    {
        super(ParentBreedBatchInfo.class);
    }
    public boolean add(ParentBreedBatchInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ParentBreedBatchCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ParentBreedBatchInfo item)
    {
        return removeObject(item);
    }
    public ParentBreedBatchInfo get(int index)
    {
        return(ParentBreedBatchInfo)getObject(index);
    }
    public ParentBreedBatchInfo get(Object key)
    {
        return(ParentBreedBatchInfo)getObject(key);
    }
    public void set(int index, ParentBreedBatchInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ParentBreedBatchInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ParentBreedBatchInfo item)
    {
        return super.indexOf(item);
    }
}