package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBatchHouseEntryCollection extends AbstractObjectCollection 
{
    public StockingBatchHouseEntryCollection()
    {
        super(StockingBatchHouseEntryInfo.class);
    }
    public boolean add(StockingBatchHouseEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBatchHouseEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBatchHouseEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingBatchHouseEntryInfo get(int index)
    {
        return(StockingBatchHouseEntryInfo)getObject(index);
    }
    public StockingBatchHouseEntryInfo get(Object key)
    {
        return(StockingBatchHouseEntryInfo)getObject(key);
    }
    public void set(int index, StockingBatchHouseEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBatchHouseEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBatchHouseEntryInfo item)
    {
        return super.indexOf(item);
    }
}