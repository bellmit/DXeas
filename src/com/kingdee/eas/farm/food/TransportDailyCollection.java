package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TransportDailyCollection extends AbstractObjectCollection 
{
    public TransportDailyCollection()
    {
        super(TransportDailyInfo.class);
    }
    public boolean add(TransportDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TransportDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TransportDailyInfo item)
    {
        return removeObject(item);
    }
    public TransportDailyInfo get(int index)
    {
        return(TransportDailyInfo)getObject(index);
    }
    public TransportDailyInfo get(Object key)
    {
        return(TransportDailyInfo)getObject(key);
    }
    public void set(int index, TransportDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TransportDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TransportDailyInfo item)
    {
        return super.indexOf(item);
    }
}