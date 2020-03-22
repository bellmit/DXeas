package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedWithHisNumberCollection extends AbstractObjectCollection 
{
    public FeedWithHisNumberCollection()
    {
        super(FeedWithHisNumberInfo.class);
    }
    public boolean add(FeedWithHisNumberInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedWithHisNumberCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedWithHisNumberInfo item)
    {
        return removeObject(item);
    }
    public FeedWithHisNumberInfo get(int index)
    {
        return(FeedWithHisNumberInfo)getObject(index);
    }
    public FeedWithHisNumberInfo get(Object key)
    {
        return(FeedWithHisNumberInfo)getObject(key);
    }
    public void set(int index, FeedWithHisNumberInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedWithHisNumberInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedWithHisNumberInfo item)
    {
        return super.indexOf(item);
    }
}