package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CustomerBalanceTreeCollection extends AbstractObjectCollection 
{
    public CustomerBalanceTreeCollection()
    {
        super(CustomerBalanceTreeInfo.class);
    }
    public boolean add(CustomerBalanceTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CustomerBalanceTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CustomerBalanceTreeInfo item)
    {
        return removeObject(item);
    }
    public CustomerBalanceTreeInfo get(int index)
    {
        return(CustomerBalanceTreeInfo)getObject(index);
    }
    public CustomerBalanceTreeInfo get(Object key)
    {
        return(CustomerBalanceTreeInfo)getObject(key);
    }
    public void set(int index, CustomerBalanceTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CustomerBalanceTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CustomerBalanceTreeInfo item)
    {
        return super.indexOf(item);
    }
}