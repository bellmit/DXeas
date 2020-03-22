package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingDailyCollection extends AbstractObjectCollection 
{
    public StockingDailyCollection()
    {
        super(StockingDailyInfo.class);
    }
    public boolean add(StockingDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingDailyInfo item)
    {
        return removeObject(item);
    }
    public StockingDailyInfo get(int index)
    {
        return(StockingDailyInfo)getObject(index);
    }
    public StockingDailyInfo get(Object key)
    {
        return(StockingDailyInfo)getObject(key);
    }
    public void set(int index, StockingDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingDailyInfo item)
    {
        return super.indexOf(item);
    }
}