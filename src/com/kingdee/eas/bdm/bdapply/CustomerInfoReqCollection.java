package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CustomerInfoReqCollection extends AbstractObjectCollection 
{
    public CustomerInfoReqCollection()
    {
        super(CustomerInfoReqInfo.class);
    }
    public boolean add(CustomerInfoReqInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CustomerInfoReqCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CustomerInfoReqInfo item)
    {
        return removeObject(item);
    }
    public CustomerInfoReqInfo get(int index)
    {
        return(CustomerInfoReqInfo)getObject(index);
    }
    public CustomerInfoReqInfo get(Object key)
    {
        return(CustomerInfoReqInfo)getObject(key);
    }
    public void set(int index, CustomerInfoReqInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CustomerInfoReqInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CustomerInfoReqInfo item)
    {
        return super.indexOf(item);
    }
}