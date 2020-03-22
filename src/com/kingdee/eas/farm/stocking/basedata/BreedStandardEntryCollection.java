package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedStandardEntryCollection extends AbstractObjectCollection 
{
    public BreedStandardEntryCollection()
    {
        super(BreedStandardEntryInfo.class);
    }
    public boolean add(BreedStandardEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedStandardEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedStandardEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedStandardEntryInfo get(int index)
    {
        return(BreedStandardEntryInfo)getObject(index);
    }
    public BreedStandardEntryInfo get(Object key)
    {
        return(BreedStandardEntryInfo)getObject(key);
    }
    public void set(int index, BreedStandardEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedStandardEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedStandardEntryInfo item)
    {
        return super.indexOf(item);
    }
}