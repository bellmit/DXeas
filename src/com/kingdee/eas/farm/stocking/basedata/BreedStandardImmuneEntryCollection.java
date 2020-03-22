package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedStandardImmuneEntryCollection extends AbstractObjectCollection 
{
    public BreedStandardImmuneEntryCollection()
    {
        super(BreedStandardImmuneEntryInfo.class);
    }
    public boolean add(BreedStandardImmuneEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedStandardImmuneEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedStandardImmuneEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedStandardImmuneEntryInfo get(int index)
    {
        return(BreedStandardImmuneEntryInfo)getObject(index);
    }
    public BreedStandardImmuneEntryInfo get(Object key)
    {
        return(BreedStandardImmuneEntryInfo)getObject(key);
    }
    public void set(int index, BreedStandardImmuneEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedStandardImmuneEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedStandardImmuneEntryInfo item)
    {
        return super.indexOf(item);
    }
}