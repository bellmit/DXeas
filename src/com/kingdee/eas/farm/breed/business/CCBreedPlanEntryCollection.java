package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCBreedPlanEntryCollection extends AbstractObjectCollection 
{
    public CCBreedPlanEntryCollection()
    {
        super(CCBreedPlanEntryInfo.class);
    }
    public boolean add(CCBreedPlanEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCBreedPlanEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCBreedPlanEntryInfo item)
    {
        return removeObject(item);
    }
    public CCBreedPlanEntryInfo get(int index)
    {
        return(CCBreedPlanEntryInfo)getObject(index);
    }
    public CCBreedPlanEntryInfo get(Object key)
    {
        return(CCBreedPlanEntryInfo)getObject(key);
    }
    public void set(int index, CCBreedPlanEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCBreedPlanEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCBreedPlanEntryInfo item)
    {
        return super.indexOf(item);
    }
}