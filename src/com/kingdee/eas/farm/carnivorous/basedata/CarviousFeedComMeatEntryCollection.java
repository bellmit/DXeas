package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarviousFeedComMeatEntryCollection extends AbstractObjectCollection 
{
    public CarviousFeedComMeatEntryCollection()
    {
        super(CarviousFeedComMeatEntryInfo.class);
    }
    public boolean add(CarviousFeedComMeatEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarviousFeedComMeatEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarviousFeedComMeatEntryInfo item)
    {
        return removeObject(item);
    }
    public CarviousFeedComMeatEntryInfo get(int index)
    {
        return(CarviousFeedComMeatEntryInfo)getObject(index);
    }
    public CarviousFeedComMeatEntryInfo get(Object key)
    {
        return(CarviousFeedComMeatEntryInfo)getObject(key);
    }
    public void set(int index, CarviousFeedComMeatEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarviousFeedComMeatEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarviousFeedComMeatEntryInfo item)
    {
        return super.indexOf(item);
    }
}