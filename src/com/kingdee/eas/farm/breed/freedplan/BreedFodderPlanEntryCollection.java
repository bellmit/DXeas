package com.kingdee.eas.farm.breed.freedplan;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedFodderPlanEntryCollection extends AbstractObjectCollection 
{
    public BreedFodderPlanEntryCollection()
    {
        super(BreedFodderPlanEntryInfo.class);
    }
    public boolean add(BreedFodderPlanEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedFodderPlanEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedFodderPlanEntryInfo item)
    {
        return removeObject(item);
    }
    public BreedFodderPlanEntryInfo get(int index)
    {
        return(BreedFodderPlanEntryInfo)getObject(index);
    }
    public BreedFodderPlanEntryInfo get(Object key)
    {
        return(BreedFodderPlanEntryInfo)getObject(key);
    }
    public void set(int index, BreedFodderPlanEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedFodderPlanEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedFodderPlanEntryInfo item)
    {
        return super.indexOf(item);
    }
}