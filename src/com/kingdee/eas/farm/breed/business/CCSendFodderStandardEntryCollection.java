package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCSendFodderStandardEntryCollection extends AbstractObjectCollection 
{
    public CCSendFodderStandardEntryCollection()
    {
        super(CCSendFodderStandardEntryInfo.class);
    }
    public boolean add(CCSendFodderStandardEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCSendFodderStandardEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCSendFodderStandardEntryInfo item)
    {
        return removeObject(item);
    }
    public CCSendFodderStandardEntryInfo get(int index)
    {
        return(CCSendFodderStandardEntryInfo)getObject(index);
    }
    public CCSendFodderStandardEntryInfo get(Object key)
    {
        return(CCSendFodderStandardEntryInfo)getObject(key);
    }
    public void set(int index, CCSendFodderStandardEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCSendFodderStandardEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCSendFodderStandardEntryInfo item)
    {
        return super.indexOf(item);
    }
}