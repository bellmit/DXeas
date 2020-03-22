package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedDataEntryCollection extends AbstractObjectCollection 
{
    public BreedDataEntryCollection()
    {
        super(BreedDataEntryInfo.class);
    }
    public boolean add(BreedDataEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedDataEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedDataEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedDataEntryInfo get(int index)
    {
        return(BreedDataEntryInfo)getObject(index);
    }
    public BreedDataEntryInfo get(Object key)
    {
        return(BreedDataEntryInfo)getObject(key);
    }
    public void set(int index, BreedDataEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedDataEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedDataEntryInfo item)
    {
        return super.indexOf(item);
    }
}