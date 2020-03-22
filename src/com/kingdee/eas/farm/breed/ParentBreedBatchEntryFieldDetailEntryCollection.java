package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ParentBreedBatchEntryFieldDetailEntryCollection extends AbstractObjectCollection 
{
    public ParentBreedBatchEntryFieldDetailEntryCollection()
    {
        super(ParentBreedBatchEntryFieldDetailEntryInfo.class);
    }
    public boolean add(ParentBreedBatchEntryFieldDetailEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ParentBreedBatchEntryFieldDetailEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ParentBreedBatchEntryFieldDetailEntryInfo item)
    {
        return removeObject(item);
    }
    public ParentBreedBatchEntryFieldDetailEntryInfo get(int index)
    {
        return(ParentBreedBatchEntryFieldDetailEntryInfo)getObject(index);
    }
    public ParentBreedBatchEntryFieldDetailEntryInfo get(Object key)
    {
        return(ParentBreedBatchEntryFieldDetailEntryInfo)getObject(key);
    }
    public void set(int index, ParentBreedBatchEntryFieldDetailEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ParentBreedBatchEntryFieldDetailEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ParentBreedBatchEntryFieldDetailEntryInfo item)
    {
        return super.indexOf(item);
    }
}