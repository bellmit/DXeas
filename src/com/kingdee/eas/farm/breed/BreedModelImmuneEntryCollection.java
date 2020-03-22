package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedModelImmuneEntryCollection extends AbstractObjectCollection 
{
    public BreedModelImmuneEntryCollection()
    {
        super(BreedModelImmuneEntryInfo.class);
    }
    public boolean add(BreedModelImmuneEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedModelImmuneEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedModelImmuneEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedModelImmuneEntryInfo get(int index)
    {
        return(BreedModelImmuneEntryInfo)getObject(index);
    }
    public BreedModelImmuneEntryInfo get(Object key)
    {
        return(BreedModelImmuneEntryInfo)getObject(key);
    }
    public void set(int index, BreedModelImmuneEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedModelImmuneEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedModelImmuneEntryInfo item)
    {
        return super.indexOf(item);
    }
}