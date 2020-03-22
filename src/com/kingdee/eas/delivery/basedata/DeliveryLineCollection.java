package com.kingdee.eas.delivery.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DeliveryLineCollection extends AbstractObjectCollection 
{
    public DeliveryLineCollection()
    {
        super(DeliveryLineInfo.class);
    }
    public boolean add(DeliveryLineInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DeliveryLineCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DeliveryLineInfo item)
    {
        return removeObject(item);
    }
    public DeliveryLineInfo get(int index)
    {
        return(DeliveryLineInfo)getObject(index);
    }
    public DeliveryLineInfo get(Object key)
    {
        return(DeliveryLineInfo)getObject(key);
    }
    public void set(int index, DeliveryLineInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DeliveryLineInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DeliveryLineInfo item)
    {
        return super.indexOf(item);
    }
}