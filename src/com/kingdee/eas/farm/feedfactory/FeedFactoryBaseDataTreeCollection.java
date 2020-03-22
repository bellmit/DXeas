package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedFactoryBaseDataTreeCollection extends AbstractObjectCollection 
{
    public FeedFactoryBaseDataTreeCollection()
    {
        super(FeedFactoryBaseDataTreeInfo.class);
    }
    public boolean add(FeedFactoryBaseDataTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedFactoryBaseDataTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedFactoryBaseDataTreeInfo item)
    {
        return removeObject(item);
    }
    public FeedFactoryBaseDataTreeInfo get(int index)
    {
        return(FeedFactoryBaseDataTreeInfo)getObject(index);
    }
    public FeedFactoryBaseDataTreeInfo get(Object key)
    {
        return(FeedFactoryBaseDataTreeInfo)getObject(key);
    }
    public void set(int index, FeedFactoryBaseDataTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedFactoryBaseDataTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedFactoryBaseDataTreeInfo item)
    {
        return super.indexOf(item);
    }
}