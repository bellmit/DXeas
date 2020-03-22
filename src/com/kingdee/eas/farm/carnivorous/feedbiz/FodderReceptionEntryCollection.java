package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderReceptionEntryCollection extends AbstractObjectCollection 
{
    public FodderReceptionEntryCollection()
    {
        super(FodderReceptionEntryInfo.class);
    }
    public boolean add(FodderReceptionEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderReceptionEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderReceptionEntryInfo item)
    {
        return removeObject(item);
    }
    public FodderReceptionEntryInfo get(int index)
    {
        return(FodderReceptionEntryInfo)getObject(index);
    }
    public FodderReceptionEntryInfo get(Object key)
    {
        return(FodderReceptionEntryInfo)getObject(key);
    }
    public void set(int index, FodderReceptionEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderReceptionEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderReceptionEntryInfo item)
    {
        return super.indexOf(item);
    }
}