package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CommecialChilkenDailyEntryCollection extends AbstractObjectCollection 
{
    public CommecialChilkenDailyEntryCollection()
    {
        super(CommecialChilkenDailyEntryInfo.class);
    }
    public boolean add(CommecialChilkenDailyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CommecialChilkenDailyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CommecialChilkenDailyEntryInfo item)
    {
        return removeObject(item);
    }
    public CommecialChilkenDailyEntryInfo get(int index)
    {
        return(CommecialChilkenDailyEntryInfo)getObject(index);
    }
    public CommecialChilkenDailyEntryInfo get(Object key)
    {
        return(CommecialChilkenDailyEntryInfo)getObject(key);
    }
    public void set(int index, CommecialChilkenDailyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CommecialChilkenDailyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CommecialChilkenDailyEntryInfo item)
    {
        return super.indexOf(item);
    }
}