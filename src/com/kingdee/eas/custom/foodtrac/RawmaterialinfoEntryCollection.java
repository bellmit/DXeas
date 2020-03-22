package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RawmaterialinfoEntryCollection extends AbstractObjectCollection 
{
    public RawmaterialinfoEntryCollection()
    {
        super(RawmaterialinfoEntryInfo.class);
    }
    public boolean add(RawmaterialinfoEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RawmaterialinfoEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RawmaterialinfoEntryInfo item)
    {
        return removeObject(item);
    }
    public RawmaterialinfoEntryInfo get(int index)
    {
        return(RawmaterialinfoEntryInfo)getObject(index);
    }
    public RawmaterialinfoEntryInfo get(Object key)
    {
        return(RawmaterialinfoEntryInfo)getObject(key);
    }
    public void set(int index, RawmaterialinfoEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RawmaterialinfoEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RawmaterialinfoEntryInfo item)
    {
        return super.indexOf(item);
    }
}