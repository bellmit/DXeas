package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBreedDailyDrugEntryCollection extends AbstractObjectCollection 
{
    public StockingBreedDailyDrugEntryCollection()
    {
        super(StockingBreedDailyDrugEntryInfo.class);
    }
    public boolean add(StockingBreedDailyDrugEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBreedDailyDrugEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBreedDailyDrugEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingBreedDailyDrugEntryInfo get(int index)
    {
        return(StockingBreedDailyDrugEntryInfo)getObject(index);
    }
    public StockingBreedDailyDrugEntryInfo get(Object key)
    {
        return(StockingBreedDailyDrugEntryInfo)getObject(key);
    }
    public void set(int index, StockingBreedDailyDrugEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBreedDailyDrugEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBreedDailyDrugEntryInfo item)
    {
        return super.indexOf(item);
    }
}