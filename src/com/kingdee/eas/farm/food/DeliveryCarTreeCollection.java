package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DeliveryCarTreeCollection extends AbstractObjectCollection 
{
    public DeliveryCarTreeCollection()
    {
        super(DeliveryCarTreeInfo.class);
    }
    public boolean add(DeliveryCarTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DeliveryCarTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DeliveryCarTreeInfo item)
    {
        return removeObject(item);
    }
    public DeliveryCarTreeInfo get(int index)
    {
        return(DeliveryCarTreeInfo)getObject(index);
    }
    public DeliveryCarTreeInfo get(Object key)
    {
        return(DeliveryCarTreeInfo)getObject(key);
    }
    public void set(int index, DeliveryCarTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DeliveryCarTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DeliveryCarTreeInfo item)
    {
        return super.indexOf(item);
    }
}