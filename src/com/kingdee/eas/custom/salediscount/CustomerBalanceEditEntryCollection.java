package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CustomerBalanceEditEntryCollection extends AbstractObjectCollection 
{
    public CustomerBalanceEditEntryCollection()
    {
        super(CustomerBalanceEditEntryInfo.class);
    }
    public boolean add(CustomerBalanceEditEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CustomerBalanceEditEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CustomerBalanceEditEntryInfo item)
    {
        return removeObject(item);
    }
    public CustomerBalanceEditEntryInfo get(int index)
    {
        return(CustomerBalanceEditEntryInfo)getObject(index);
    }
    public CustomerBalanceEditEntryInfo get(Object key)
    {
        return(CustomerBalanceEditEntryInfo)getObject(key);
    }
    public void set(int index, CustomerBalanceEditEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CustomerBalanceEditEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CustomerBalanceEditEntryInfo item)
    {
        return super.indexOf(item);
    }
}