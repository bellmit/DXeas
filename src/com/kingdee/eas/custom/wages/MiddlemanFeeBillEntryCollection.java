package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MiddlemanFeeBillEntryCollection extends AbstractObjectCollection 
{
    public MiddlemanFeeBillEntryCollection()
    {
        super(MiddlemanFeeBillEntryInfo.class);
    }
    public boolean add(MiddlemanFeeBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MiddlemanFeeBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MiddlemanFeeBillEntryInfo item)
    {
        return removeObject(item);
    }
    public MiddlemanFeeBillEntryInfo get(int index)
    {
        return(MiddlemanFeeBillEntryInfo)getObject(index);
    }
    public MiddlemanFeeBillEntryInfo get(Object key)
    {
        return(MiddlemanFeeBillEntryInfo)getObject(key);
    }
    public void set(int index, MiddlemanFeeBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MiddlemanFeeBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MiddlemanFeeBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}