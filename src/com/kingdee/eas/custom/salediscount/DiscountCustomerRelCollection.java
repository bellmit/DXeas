package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DiscountCustomerRelCollection extends AbstractObjectCollection 
{
    public DiscountCustomerRelCollection()
    {
        super(DiscountCustomerRelInfo.class);
    }
    public boolean add(DiscountCustomerRelInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DiscountCustomerRelCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DiscountCustomerRelInfo item)
    {
        return removeObject(item);
    }
    public DiscountCustomerRelInfo get(int index)
    {
        return(DiscountCustomerRelInfo)getObject(index);
    }
    public DiscountCustomerRelInfo get(Object key)
    {
        return(DiscountCustomerRelInfo)getObject(key);
    }
    public void set(int index, DiscountCustomerRelInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DiscountCustomerRelInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DiscountCustomerRelInfo item)
    {
        return super.indexOf(item);
    }
}