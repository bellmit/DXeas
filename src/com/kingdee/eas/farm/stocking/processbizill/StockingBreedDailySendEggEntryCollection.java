package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBreedDailySendEggEntryCollection extends AbstractObjectCollection 
{
    public StockingBreedDailySendEggEntryCollection()
    {
        super(StockingBreedDailySendEggEntryInfo.class);
    }
    public boolean add(StockingBreedDailySendEggEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBreedDailySendEggEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBreedDailySendEggEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingBreedDailySendEggEntryInfo get(int index)
    {
        return(StockingBreedDailySendEggEntryInfo)getObject(index);
    }
    public StockingBreedDailySendEggEntryInfo get(Object key)
    {
        return(StockingBreedDailySendEggEntryInfo)getObject(key);
    }
    public void set(int index, StockingBreedDailySendEggEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBreedDailySendEggEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBreedDailySendEggEntryInfo item)
    {
        return super.indexOf(item);
    }
}