package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedFactoryTruckPlanCollection extends AbstractObjectCollection 
{
    public FeedFactoryTruckPlanCollection()
    {
        super(FeedFactoryTruckPlanInfo.class);
    }
    public boolean add(FeedFactoryTruckPlanInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedFactoryTruckPlanCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedFactoryTruckPlanInfo item)
    {
        return removeObject(item);
    }
    public FeedFactoryTruckPlanInfo get(int index)
    {
        return(FeedFactoryTruckPlanInfo)getObject(index);
    }
    public FeedFactoryTruckPlanInfo get(Object key)
    {
        return(FeedFactoryTruckPlanInfo)getObject(key);
    }
    public void set(int index, FeedFactoryTruckPlanInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedFactoryTruckPlanInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedFactoryTruckPlanInfo item)
    {
        return super.indexOf(item);
    }
}