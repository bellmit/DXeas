package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ParentBreedBatchEntryCollection extends AbstractObjectCollection 
{
    public ParentBreedBatchEntryCollection()
    {
        super(ParentBreedBatchEntryInfo.class);
    }
    public boolean add(ParentBreedBatchEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ParentBreedBatchEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ParentBreedBatchEntryInfo item)
    {
        return removeObject(item);
    }
    public ParentBreedBatchEntryInfo get(int index)
    {
        return(ParentBreedBatchEntryInfo)getObject(index);
    }
    public ParentBreedBatchEntryInfo get(Object key)
    {
        return(ParentBreedBatchEntryInfo)getObject(key);
    }
    public void set(int index, ParentBreedBatchEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ParentBreedBatchEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ParentBreedBatchEntryInfo item)
    {
        return super.indexOf(item);
    }
}