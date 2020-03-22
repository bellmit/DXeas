package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBreedDailyEntryCollection extends AbstractObjectCollection 
{
    public StockingBreedDailyEntryCollection()
    {
        super(StockingBreedDailyEntryInfo.class);
    }
    public boolean add(StockingBreedDailyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBreedDailyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBreedDailyEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingBreedDailyEntryInfo get(int index)
    {
        return(StockingBreedDailyEntryInfo)getObject(index);
    }
    public StockingBreedDailyEntryInfo get(Object key)
    {
        return(StockingBreedDailyEntryInfo)getObject(key);
    }
    public void set(int index, StockingBreedDailyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBreedDailyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBreedDailyEntryInfo item)
    {
        return super.indexOf(item);
    }
}