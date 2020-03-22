package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CommecialChilkenDailyCollection extends AbstractObjectCollection 
{
    public CommecialChilkenDailyCollection()
    {
        super(CommecialChilkenDailyInfo.class);
    }
    public boolean add(CommecialChilkenDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CommecialChilkenDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CommecialChilkenDailyInfo item)
    {
        return removeObject(item);
    }
    public CommecialChilkenDailyInfo get(int index)
    {
        return(CommecialChilkenDailyInfo)getObject(index);
    }
    public CommecialChilkenDailyInfo get(Object key)
    {
        return(CommecialChilkenDailyInfo)getObject(key);
    }
    public void set(int index, CommecialChilkenDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CommecialChilkenDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CommecialChilkenDailyInfo item)
    {
        return super.indexOf(item);
    }
}