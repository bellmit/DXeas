package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedDataStageEntryCollection extends AbstractObjectCollection 
{
    public BreedDataStageEntryCollection()
    {
        super(BreedDataStageEntryInfo.class);
    }
    public boolean add(BreedDataStageEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedDataStageEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedDataStageEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedDataStageEntryInfo get(int index)
    {
        return(BreedDataStageEntryInfo)getObject(index);
    }
    public BreedDataStageEntryInfo get(Object key)
    {
        return(BreedDataStageEntryInfo)getObject(key);
    }
    public void set(int index, BreedDataStageEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedDataStageEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedDataStageEntryInfo item)
    {
        return super.indexOf(item);
    }
}