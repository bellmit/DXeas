package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBatchCollection extends AbstractObjectCollection 
{
    public StockingBatchCollection()
    {
        super(StockingBatchInfo.class);
    }
    public boolean add(StockingBatchInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBatchCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBatchInfo item)
    {
        return removeObject(item);
    }
    public StockingBatchInfo get(int index)
    {
        return(StockingBatchInfo)getObject(index);
    }
    public StockingBatchInfo get(Object key)
    {
        return(StockingBatchInfo)getObject(key);
    }
    public void set(int index, StockingBatchInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBatchInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBatchInfo item)
    {
        return super.indexOf(item);
    }
}