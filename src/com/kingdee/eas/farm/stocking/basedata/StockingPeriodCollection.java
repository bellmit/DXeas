package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingPeriodCollection extends AbstractObjectCollection 
{
    public StockingPeriodCollection()
    {
        super(StockingPeriodInfo.class);
    }
    public boolean add(StockingPeriodInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingPeriodCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingPeriodInfo item)
    {
        return removeObject(item);
    }
    public StockingPeriodInfo get(int index)
    {
        return(StockingPeriodInfo)getObject(index);
    }
    public StockingPeriodInfo get(Object key)
    {
        return(StockingPeriodInfo)getObject(key);
    }
    public void set(int index, StockingPeriodInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingPeriodInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingPeriodInfo item)
    {
        return super.indexOf(item);
    }
}