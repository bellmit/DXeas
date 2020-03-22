package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarriageFormatCollection extends AbstractObjectCollection 
{
    public CarriageFormatCollection()
    {
        super(CarriageFormatInfo.class);
    }
    public boolean add(CarriageFormatInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarriageFormatCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarriageFormatInfo item)
    {
        return removeObject(item);
    }
    public CarriageFormatInfo get(int index)
    {
        return(CarriageFormatInfo)getObject(index);
    }
    public CarriageFormatInfo get(Object key)
    {
        return(CarriageFormatInfo)getObject(key);
    }
    public void set(int index, CarriageFormatInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarriageFormatInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarriageFormatInfo item)
    {
        return super.indexOf(item);
    }
}