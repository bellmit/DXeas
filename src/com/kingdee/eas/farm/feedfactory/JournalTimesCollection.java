package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class JournalTimesCollection extends AbstractObjectCollection 
{
    public JournalTimesCollection()
    {
        super(JournalTimesInfo.class);
    }
    public boolean add(JournalTimesInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(JournalTimesCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(JournalTimesInfo item)
    {
        return removeObject(item);
    }
    public JournalTimesInfo get(int index)
    {
        return(JournalTimesInfo)getObject(index);
    }
    public JournalTimesInfo get(Object key)
    {
        return(JournalTimesInfo)getObject(key);
    }
    public void set(int index, JournalTimesInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(JournalTimesInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(JournalTimesInfo item)
    {
        return super.indexOf(item);
    }
}