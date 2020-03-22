package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SynDateLogEntryCollection extends AbstractObjectCollection 
{
    public SynDateLogEntryCollection()
    {
        super(SynDateLogEntryInfo.class);
    }
    public boolean add(SynDateLogEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SynDateLogEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SynDateLogEntryInfo item)
    {
        return removeObject(item);
    }
    public SynDateLogEntryInfo get(int index)
    {
        return(SynDateLogEntryInfo)getObject(index);
    }
    public SynDateLogEntryInfo get(Object key)
    {
        return(SynDateLogEntryInfo)getObject(key);
    }
    public void set(int index, SynDateLogEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SynDateLogEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SynDateLogEntryInfo item)
    {
        return super.indexOf(item);
    }
}