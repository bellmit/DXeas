package com.kingdee.eas.custom.test;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SdlEntryCollection extends AbstractObjectCollection 
{
    public SdlEntryCollection()
    {
        super(SdlEntryInfo.class);
    }
    public boolean add(SdlEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SdlEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SdlEntryInfo item)
    {
        return removeObject(item);
    }
    public SdlEntryInfo get(int index)
    {
        return(SdlEntryInfo)getObject(index);
    }
    public SdlEntryInfo get(Object key)
    {
        return(SdlEntryInfo)getObject(key);
    }
    public void set(int index, SdlEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SdlEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SdlEntryInfo item)
    {
        return super.indexOf(item);
    }
}