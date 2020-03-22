package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBreedDailyCollection extends AbstractObjectCollection 
{
    public StockingBreedDailyCollection()
    {
        super(StockingBreedDailyInfo.class);
    }
    public boolean add(StockingBreedDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBreedDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBreedDailyInfo item)
    {
        return removeObject(item);
    }
    public StockingBreedDailyInfo get(int index)
    {
        return(StockingBreedDailyInfo)getObject(index);
    }
    public StockingBreedDailyInfo get(Object key)
    {
        return(StockingBreedDailyInfo)getObject(key);
    }
    public void set(int index, StockingBreedDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBreedDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBreedDailyInfo item)
    {
        return super.indexOf(item);
    }
}