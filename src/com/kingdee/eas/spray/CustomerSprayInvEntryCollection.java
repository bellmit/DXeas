package com.kingdee.eas.spray;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CustomerSprayInvEntryCollection extends AbstractObjectCollection 
{
    public CustomerSprayInvEntryCollection()
    {
        super(CustomerSprayInvEntryInfo.class);
    }
    public boolean add(CustomerSprayInvEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CustomerSprayInvEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CustomerSprayInvEntryInfo item)
    {
        return removeObject(item);
    }
    public CustomerSprayInvEntryInfo get(int index)
    {
        return(CustomerSprayInvEntryInfo)getObject(index);
    }
    public CustomerSprayInvEntryInfo get(Object key)
    {
        return(CustomerSprayInvEntryInfo)getObject(key);
    }
    public void set(int index, CustomerSprayInvEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CustomerSprayInvEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CustomerSprayInvEntryInfo item)
    {
        return super.indexOf(item);
    }
}