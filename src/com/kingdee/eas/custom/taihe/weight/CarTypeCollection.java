package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarTypeCollection extends AbstractObjectCollection 
{
    public CarTypeCollection()
    {
        super(CarTypeInfo.class);
    }
    public boolean add(CarTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarTypeInfo item)
    {
        return removeObject(item);
    }
    public CarTypeInfo get(int index)
    {
        return(CarTypeInfo)getObject(index);
    }
    public CarTypeInfo get(Object key)
    {
        return(CarTypeInfo)getObject(key);
    }
    public void set(int index, CarTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarTypeInfo item)
    {
        return super.indexOf(item);
    }
}