package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedTruckCollection extends AbstractObjectCollection 
{
    public FeedTruckCollection()
    {
        super(FeedTruckInfo.class);
    }
    public boolean add(FeedTruckInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedTruckCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedTruckInfo item)
    {
        return removeObject(item);
    }
    public FeedTruckInfo get(int index)
    {
        return(FeedTruckInfo)getObject(index);
    }
    public FeedTruckInfo get(Object key)
    {
        return(FeedTruckInfo)getObject(key);
    }
    public void set(int index, FeedTruckInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedTruckInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedTruckInfo item)
    {
        return super.indexOf(item);
    }
}