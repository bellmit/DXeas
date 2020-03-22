package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingDailyAssEntryCollection extends AbstractObjectCollection 
{
    public StockingDailyAssEntryCollection()
    {
        super(StockingDailyAssEntryInfo.class);
    }
    public boolean add(StockingDailyAssEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingDailyAssEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingDailyAssEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingDailyAssEntryInfo get(int index)
    {
        return(StockingDailyAssEntryInfo)getObject(index);
    }
    public StockingDailyAssEntryInfo get(Object key)
    {
        return(StockingDailyAssEntryInfo)getObject(key);
    }
    public void set(int index, StockingDailyAssEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingDailyAssEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingDailyAssEntryInfo item)
    {
        return super.indexOf(item);
    }
}