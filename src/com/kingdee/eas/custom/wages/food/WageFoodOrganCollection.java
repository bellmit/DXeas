package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WageFoodOrganCollection extends AbstractObjectCollection 
{
    public WageFoodOrganCollection()
    {
        super(WageFoodOrganInfo.class);
    }
    public boolean add(WageFoodOrganInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WageFoodOrganCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WageFoodOrganInfo item)
    {
        return removeObject(item);
    }
    public WageFoodOrganInfo get(int index)
    {
        return(WageFoodOrganInfo)getObject(index);
    }
    public WageFoodOrganInfo get(Object key)
    {
        return(WageFoodOrganInfo)getObject(key);
    }
    public void set(int index, WageFoodOrganInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WageFoodOrganInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WageFoodOrganInfo item)
    {
        return super.indexOf(item);
    }
}