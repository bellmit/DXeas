package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ReserveSowCollection extends AbstractObjectCollection 
{
    public ReserveSowCollection()
    {
        super(ReserveSowInfo.class);
    }
    public boolean add(ReserveSowInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ReserveSowCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ReserveSowInfo item)
    {
        return removeObject(item);
    }
    public ReserveSowInfo get(int index)
    {
        return(ReserveSowInfo)getObject(index);
    }
    public ReserveSowInfo get(Object key)
    {
        return(ReserveSowInfo)getObject(key);
    }
    public void set(int index, ReserveSowInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ReserveSowInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ReserveSowInfo item)
    {
        return super.indexOf(item);
    }
}