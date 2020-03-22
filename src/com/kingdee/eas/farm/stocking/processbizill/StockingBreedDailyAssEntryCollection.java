package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBreedDailyAssEntryCollection extends AbstractObjectCollection 
{
    public StockingBreedDailyAssEntryCollection()
    {
        super(StockingBreedDailyAssEntryInfo.class);
    }
    public boolean add(StockingBreedDailyAssEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBreedDailyAssEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBreedDailyAssEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingBreedDailyAssEntryInfo get(int index)
    {
        return(StockingBreedDailyAssEntryInfo)getObject(index);
    }
    public StockingBreedDailyAssEntryInfo get(Object key)
    {
        return(StockingBreedDailyAssEntryInfo)getObject(key);
    }
    public void set(int index, StockingBreedDailyAssEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBreedDailyAssEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBreedDailyAssEntryInfo item)
    {
        return super.indexOf(item);
    }
}