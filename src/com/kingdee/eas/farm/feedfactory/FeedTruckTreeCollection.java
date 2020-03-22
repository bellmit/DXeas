package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedTruckTreeCollection extends AbstractObjectCollection 
{
    public FeedTruckTreeCollection()
    {
        super(FeedTruckTreeInfo.class);
    }
    public boolean add(FeedTruckTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedTruckTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedTruckTreeInfo item)
    {
        return removeObject(item);
    }
    public FeedTruckTreeInfo get(int index)
    {
        return(FeedTruckTreeInfo)getObject(index);
    }
    public FeedTruckTreeInfo get(Object key)
    {
        return(FeedTruckTreeInfo)getObject(key);
    }
    public void set(int index, FeedTruckTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedTruckTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedTruckTreeInfo item)
    {
        return super.indexOf(item);
    }
}