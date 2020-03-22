package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedStandardDrugEntryCollection extends AbstractObjectCollection 
{
    public BreedStandardDrugEntryCollection()
    {
        super(BreedStandardDrugEntryInfo.class);
    }
    public boolean add(BreedStandardDrugEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedStandardDrugEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedStandardDrugEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedStandardDrugEntryInfo get(int index)
    {
        return(BreedStandardDrugEntryInfo)getObject(index);
    }
    public BreedStandardDrugEntryInfo get(Object key)
    {
        return(BreedStandardDrugEntryInfo)getObject(key);
    }
    public void set(int index, BreedStandardDrugEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedStandardDrugEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedStandardDrugEntryInfo item)
    {
        return super.indexOf(item);
    }
}