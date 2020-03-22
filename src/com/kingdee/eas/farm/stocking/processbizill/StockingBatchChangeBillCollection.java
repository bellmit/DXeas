package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBatchChangeBillCollection extends AbstractObjectCollection 
{
    public StockingBatchChangeBillCollection()
    {
        super(StockingBatchChangeBillInfo.class);
    }
    public boolean add(StockingBatchChangeBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBatchChangeBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBatchChangeBillInfo item)
    {
        return removeObject(item);
    }
    public StockingBatchChangeBillInfo get(int index)
    {
        return(StockingBatchChangeBillInfo)getObject(index);
    }
    public StockingBatchChangeBillInfo get(Object key)
    {
        return(StockingBatchChangeBillInfo)getObject(key);
    }
    public void set(int index, StockingBatchChangeBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBatchChangeBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBatchChangeBillInfo item)
    {
        return super.indexOf(item);
    }
}