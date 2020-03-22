package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LeavecheckEntryCollection extends AbstractObjectCollection 
{
    public LeavecheckEntryCollection()
    {
        super(LeavecheckEntryInfo.class);
    }
    public boolean add(LeavecheckEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LeavecheckEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LeavecheckEntryInfo item)
    {
        return removeObject(item);
    }
    public LeavecheckEntryInfo get(int index)
    {
        return(LeavecheckEntryInfo)getObject(index);
    }
    public LeavecheckEntryInfo get(Object key)
    {
        return(LeavecheckEntryInfo)getObject(key);
    }
    public void set(int index, LeavecheckEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LeavecheckEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LeavecheckEntryInfo item)
    {
        return super.indexOf(item);
    }
}