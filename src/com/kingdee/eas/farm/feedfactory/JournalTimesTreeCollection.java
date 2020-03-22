package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class JournalTimesTreeCollection extends AbstractObjectCollection 
{
    public JournalTimesTreeCollection()
    {
        super(JournalTimesTreeInfo.class);
    }
    public boolean add(JournalTimesTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(JournalTimesTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(JournalTimesTreeInfo item)
    {
        return removeObject(item);
    }
    public JournalTimesTreeInfo get(int index)
    {
        return(JournalTimesTreeInfo)getObject(index);
    }
    public JournalTimesTreeInfo get(Object key)
    {
        return(JournalTimesTreeInfo)getObject(key);
    }
    public void set(int index, JournalTimesTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(JournalTimesTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(JournalTimesTreeInfo item)
    {
        return super.indexOf(item);
    }
}