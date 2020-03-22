package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CustomerViewTypeCollection extends AbstractObjectCollection 
{
    public CustomerViewTypeCollection()
    {
        super(CustomerViewTypeInfo.class);
    }
    public boolean add(CustomerViewTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CustomerViewTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CustomerViewTypeInfo item)
    {
        return removeObject(item);
    }
    public CustomerViewTypeInfo get(int index)
    {
        return(CustomerViewTypeInfo)getObject(index);
    }
    public CustomerViewTypeInfo get(Object key)
    {
        return(CustomerViewTypeInfo)getObject(key);
    }
    public void set(int index, CustomerViewTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CustomerViewTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CustomerViewTypeInfo item)
    {
        return super.indexOf(item);
    }
}