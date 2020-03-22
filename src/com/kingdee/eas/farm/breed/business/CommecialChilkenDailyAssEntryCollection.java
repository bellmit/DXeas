package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CommecialChilkenDailyAssEntryCollection extends AbstractObjectCollection 
{
    public CommecialChilkenDailyAssEntryCollection()
    {
        super(CommecialChilkenDailyAssEntryInfo.class);
    }
    public boolean add(CommecialChilkenDailyAssEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CommecialChilkenDailyAssEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CommecialChilkenDailyAssEntryInfo item)
    {
        return removeObject(item);
    }
    public CommecialChilkenDailyAssEntryInfo get(int index)
    {
        return(CommecialChilkenDailyAssEntryInfo)getObject(index);
    }
    public CommecialChilkenDailyAssEntryInfo get(Object key)
    {
        return(CommecialChilkenDailyAssEntryInfo)getObject(key);
    }
    public void set(int index, CommecialChilkenDailyAssEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CommecialChilkenDailyAssEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CommecialChilkenDailyAssEntryInfo item)
    {
        return super.indexOf(item);
    }
}