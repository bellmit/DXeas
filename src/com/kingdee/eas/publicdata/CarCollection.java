package com.kingdee.eas.publicdata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarCollection extends AbstractObjectCollection 
{
    public CarCollection()
    {
        super(CarInfo.class);
    }
    public boolean add(CarInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarInfo item)
    {
        return removeObject(item);
    }
    public CarInfo get(int index)
    {
        return(CarInfo)getObject(index);
    }
    public CarInfo get(Object key)
    {
        return(CarInfo)getObject(key);
    }
    public void set(int index, CarInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarInfo item)
    {
        return super.indexOf(item);
    }
}