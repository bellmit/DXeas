package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreshDailyFrozenEntryCollection extends AbstractObjectCollection 
{
    public FreshDailyFrozenEntryCollection()
    {
        super(FreshDailyFrozenEntryInfo.class);
    }
    public boolean add(FreshDailyFrozenEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreshDailyFrozenEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreshDailyFrozenEntryInfo item)
    {
        return removeObject(item);
    }
    public FreshDailyFrozenEntryInfo get(int index)
    {
        return(FreshDailyFrozenEntryInfo)getObject(index);
    }
    public FreshDailyFrozenEntryInfo get(Object key)
    {
        return(FreshDailyFrozenEntryInfo)getObject(key);
    }
    public void set(int index, FreshDailyFrozenEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreshDailyFrozenEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreshDailyFrozenEntryInfo item)
    {
        return super.indexOf(item);
    }
}