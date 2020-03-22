package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingPeriodPeriodEntryCollection extends AbstractObjectCollection 
{
    public StockingPeriodPeriodEntryCollection()
    {
        super(StockingPeriodPeriodEntryInfo.class);
    }
    public boolean add(StockingPeriodPeriodEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingPeriodPeriodEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingPeriodPeriodEntryInfo item)
    {
        return removeObject(item);
    }
    public StockingPeriodPeriodEntryInfo get(int index)
    {
        return(StockingPeriodPeriodEntryInfo)getObject(index);
    }
    public StockingPeriodPeriodEntryInfo get(Object key)
    {
        return(StockingPeriodPeriodEntryInfo)getObject(key);
    }
    public void set(int index, StockingPeriodPeriodEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingPeriodPeriodEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingPeriodPeriodEntryInfo item)
    {
        return super.indexOf(item);
    }
}