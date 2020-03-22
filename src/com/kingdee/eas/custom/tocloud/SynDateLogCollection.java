package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SynDateLogCollection extends AbstractObjectCollection 
{
    public SynDateLogCollection()
    {
        super(SynDateLogInfo.class);
    }
    public boolean add(SynDateLogInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SynDateLogCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SynDateLogInfo item)
    {
        return removeObject(item);
    }
    public SynDateLogInfo get(int index)
    {
        return(SynDateLogInfo)getObject(index);
    }
    public SynDateLogInfo get(Object key)
    {
        return(SynDateLogInfo)getObject(key);
    }
    public void set(int index, SynDateLogInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SynDateLogInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SynDateLogInfo item)
    {
        return super.indexOf(item);
    }
}