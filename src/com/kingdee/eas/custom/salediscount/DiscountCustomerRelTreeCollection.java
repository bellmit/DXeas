package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DiscountCustomerRelTreeCollection extends AbstractObjectCollection 
{
    public DiscountCustomerRelTreeCollection()
    {
        super(DiscountCustomerRelTreeInfo.class);
    }
    public boolean add(DiscountCustomerRelTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DiscountCustomerRelTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DiscountCustomerRelTreeInfo item)
    {
        return removeObject(item);
    }
    public DiscountCustomerRelTreeInfo get(int index)
    {
        return(DiscountCustomerRelTreeInfo)getObject(index);
    }
    public DiscountCustomerRelTreeInfo get(Object key)
    {
        return(DiscountCustomerRelTreeInfo)getObject(key);
    }
    public void set(int index, DiscountCustomerRelTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DiscountCustomerRelTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DiscountCustomerRelTreeInfo item)
    {
        return super.indexOf(item);
    }
}