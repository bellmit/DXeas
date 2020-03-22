package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarviousFeedPlanCollection extends AbstractObjectCollection 
{
    public CarviousFeedPlanCollection()
    {
        super(CarviousFeedPlanInfo.class);
    }
    public boolean add(CarviousFeedPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarviousFeedPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarviousFeedPlanInfo item)
    {
        return removeObject(item);
    }
    public CarviousFeedPlanInfo get(int index)
    {
        return(CarviousFeedPlanInfo)getObject(index);
    }
    public CarviousFeedPlanInfo get(Object key)
    {
        return(CarviousFeedPlanInfo)getObject(key);
    }
    public void set(int index, CarviousFeedPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarviousFeedPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarviousFeedPlanInfo item)
    {
        return super.indexOf(item);
    }
}