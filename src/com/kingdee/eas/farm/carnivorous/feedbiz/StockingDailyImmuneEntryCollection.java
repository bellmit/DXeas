package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingDailyImmuneEntryCollection extends AbstractObjectCollection 
{
    public StockingDailyImmuneEntryCollection()
    {
        super(StockingDailyImmuneEntryInfo.class);
    }
    public boolean add(StockingDailyImmuneEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingDailyImmuneEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingDailyImmuneEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingDailyImmuneEntryInfo get(int index)
    {
        return(StockingDailyImmuneEntryInfo)getObject(index);
    }
    public StockingDailyImmuneEntryInfo get(Object key)
    {
        return(StockingDailyImmuneEntryInfo)getObject(key);
    }
    public void set(int index, StockingDailyImmuneEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingDailyImmuneEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingDailyImmuneEntryInfo item)
    {
        return super.indexOf(item);
    }
}