package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarviousFeedPlanEntryCollection extends AbstractObjectCollection 
{
    public CarviousFeedPlanEntryCollection()
    {
        super(CarviousFeedPlanEntryInfo.class);
    }
    public boolean add(CarviousFeedPlanEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarviousFeedPlanEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarviousFeedPlanEntryInfo item)
    {
        return removeObject(item);
    }
    public CarviousFeedPlanEntryInfo get(int index)
    {
        return(CarviousFeedPlanEntryInfo)getObject(index);
    }
    public CarviousFeedPlanEntryInfo get(Object key)
    {
        return(CarviousFeedPlanEntryInfo)getObject(key);
    }
    public void set(int index, CarviousFeedPlanEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarviousFeedPlanEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarviousFeedPlanEntryInfo item)
    {
        return super.indexOf(item);
    }
}