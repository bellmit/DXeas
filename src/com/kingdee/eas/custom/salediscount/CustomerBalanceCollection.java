package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CustomerBalanceCollection extends AbstractObjectCollection 
{
    public CustomerBalanceCollection()
    {
        super(CustomerBalanceInfo.class);
    }
    public boolean add(CustomerBalanceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CustomerBalanceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CustomerBalanceInfo item)
    {
        return removeObject(item);
    }
    public CustomerBalanceInfo get(int index)
    {
        return(CustomerBalanceInfo)getObject(index);
    }
    public CustomerBalanceInfo get(Object key)
    {
        return(CustomerBalanceInfo)getObject(key);
    }
    public void set(int index, CustomerBalanceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CustomerBalanceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CustomerBalanceInfo item)
    {
        return super.indexOf(item);
    }
}