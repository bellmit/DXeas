package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedBusinessDailyCollection extends AbstractObjectCollection 
{
    public FeedBusinessDailyCollection()
    {
        super(FeedBusinessDailyInfo.class);
    }
    public boolean add(FeedBusinessDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedBusinessDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedBusinessDailyInfo item)
    {
        return removeObject(item);
    }
    public FeedBusinessDailyInfo get(int index)
    {
        return(FeedBusinessDailyInfo)getObject(index);
    }
    public FeedBusinessDailyInfo get(Object key)
    {
        return(FeedBusinessDailyInfo)getObject(key);
    }
    public void set(int index, FeedBusinessDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedBusinessDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedBusinessDailyInfo item)
    {
        return super.indexOf(item);
    }
}