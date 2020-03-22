package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingDailyEntryCollection extends AbstractObjectCollection 
{
    public StockingDailyEntryCollection()
    {
        super(StockingDailyEntryInfo.class);
    }
    public boolean add(StockingDailyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingDailyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingDailyEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingDailyEntryInfo get(int index)
    {
        return(StockingDailyEntryInfo)getObject(index);
    }
    public StockingDailyEntryInfo get(Object key)
    {
        return(StockingDailyEntryInfo)getObject(key);
    }
    public void set(int index, StockingDailyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingDailyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingDailyEntryInfo item)
    {
        return super.indexOf(item);
    }
}