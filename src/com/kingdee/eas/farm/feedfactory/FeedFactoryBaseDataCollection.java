package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedFactoryBaseDataCollection extends AbstractObjectCollection 
{
    public FeedFactoryBaseDataCollection()
    {
        super(FeedFactoryBaseDataInfo.class);
    }
    public boolean add(FeedFactoryBaseDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedFactoryBaseDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedFactoryBaseDataInfo item)
    {
        return removeObject(item);
    }
    public FeedFactoryBaseDataInfo get(int index)
    {
        return(FeedFactoryBaseDataInfo)getObject(index);
    }
    public FeedFactoryBaseDataInfo get(Object key)
    {
        return(FeedFactoryBaseDataInfo)getObject(key);
    }
    public void set(int index, FeedFactoryBaseDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedFactoryBaseDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedFactoryBaseDataInfo item)
    {
        return super.indexOf(item);
    }
}