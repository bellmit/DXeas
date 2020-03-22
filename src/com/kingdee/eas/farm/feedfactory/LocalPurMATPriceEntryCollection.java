package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LocalPurMATPriceEntryCollection extends AbstractObjectCollection 
{
    public LocalPurMATPriceEntryCollection()
    {
        super(LocalPurMATPriceEntryInfo.class);
    }
    public boolean add(LocalPurMATPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LocalPurMATPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LocalPurMATPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public LocalPurMATPriceEntryInfo get(int index)
    {
        return(LocalPurMATPriceEntryInfo)getObject(index);
    }
    public LocalPurMATPriceEntryInfo get(Object key)
    {
        return(LocalPurMATPriceEntryInfo)getObject(key);
    }
    public void set(int index, LocalPurMATPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LocalPurMATPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LocalPurMATPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}