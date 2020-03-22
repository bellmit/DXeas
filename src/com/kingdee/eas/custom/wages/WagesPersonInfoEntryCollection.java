package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WagesPersonInfoEntryCollection extends AbstractObjectCollection 
{
    public WagesPersonInfoEntryCollection()
    {
        super(WagesPersonInfoEntryInfo.class);
    }
    public boolean add(WagesPersonInfoEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WagesPersonInfoEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WagesPersonInfoEntryInfo item)
    {
        return removeObject(item);
    }
    public WagesPersonInfoEntryInfo get(int index)
    {
        return(WagesPersonInfoEntryInfo)getObject(index);
    }
    public WagesPersonInfoEntryInfo get(Object key)
    {
        return(WagesPersonInfoEntryInfo)getObject(key);
    }
    public void set(int index, WagesPersonInfoEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WagesPersonInfoEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WagesPersonInfoEntryInfo item)
    {
        return super.indexOf(item);
    }
}