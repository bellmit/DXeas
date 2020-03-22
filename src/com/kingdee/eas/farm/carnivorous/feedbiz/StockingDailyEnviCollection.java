package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingDailyEnviCollection extends AbstractObjectCollection 
{
    public StockingDailyEnviCollection()
    {
        super(StockingDailyEnviInfo.class);
    }
    public boolean add(StockingDailyEnviInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingDailyEnviCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingDailyEnviInfo item)
    {
        return removeObject(item);
    }
    public StockingDailyEnviInfo get(int index)
    {
        return(StockingDailyEnviInfo)getObject(index);
    }
    public StockingDailyEnviInfo get(Object key)
    {
        return(StockingDailyEnviInfo)getObject(key);
    }
    public void set(int index, StockingDailyEnviInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingDailyEnviInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingDailyEnviInfo item)
    {
        return super.indexOf(item);
    }
}