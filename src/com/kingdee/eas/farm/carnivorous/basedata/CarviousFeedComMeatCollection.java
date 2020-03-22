package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarviousFeedComMeatCollection extends AbstractObjectCollection 
{
    public CarviousFeedComMeatCollection()
    {
        super(CarviousFeedComMeatInfo.class);
    }
    public boolean add(CarviousFeedComMeatInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarviousFeedComMeatCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarviousFeedComMeatInfo item)
    {
        return removeObject(item);
    }
    public CarviousFeedComMeatInfo get(int index)
    {
        return(CarviousFeedComMeatInfo)getObject(index);
    }
    public CarviousFeedComMeatInfo get(Object key)
    {
        return(CarviousFeedComMeatInfo)getObject(key);
    }
    public void set(int index, CarviousFeedComMeatInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarviousFeedComMeatInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarviousFeedComMeatInfo item)
    {
        return super.indexOf(item);
    }
}