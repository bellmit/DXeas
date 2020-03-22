package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBreedDailyEnviCollection extends AbstractObjectCollection 
{
    public StockingBreedDailyEnviCollection()
    {
        super(StockingBreedDailyEnviInfo.class);
    }
    public boolean add(StockingBreedDailyEnviInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBreedDailyEnviCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBreedDailyEnviInfo item)
    {
        return removeObject(item);
    }
    public StockingBreedDailyEnviInfo get(int index)
    {
        return(StockingBreedDailyEnviInfo)getObject(index);
    }
    public StockingBreedDailyEnviInfo get(Object key)
    {
        return(StockingBreedDailyEnviInfo)getObject(key);
    }
    public void set(int index, StockingBreedDailyEnviInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBreedDailyEnviInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBreedDailyEnviInfo item)
    {
        return super.indexOf(item);
    }
}