package com.kingdee.eas.publicdata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CarTreeCollection extends AbstractObjectCollection 
{
    public CarTreeCollection()
    {
        super(CarTreeInfo.class);
    }
    public boolean add(CarTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CarTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CarTreeInfo item)
    {
        return removeObject(item);
    }
    public CarTreeInfo get(int index)
    {
        return(CarTreeInfo)getObject(index);
    }
    public CarTreeInfo get(Object key)
    {
        return(CarTreeInfo)getObject(key);
    }
    public void set(int index, CarTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CarTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CarTreeInfo item)
    {
        return super.indexOf(item);
    }
}