package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBatchTreeCollection extends AbstractObjectCollection 
{
    public StockingBatchTreeCollection()
    {
        super(StockingBatchTreeInfo.class);
    }
    public boolean add(StockingBatchTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBatchTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBatchTreeInfo item)
    {
        return removeObject(item);
    }
    public StockingBatchTreeInfo get(int index)
    {
        return(StockingBatchTreeInfo)getObject(index);
    }
    public StockingBatchTreeInfo get(Object key)
    {
        return(StockingBatchTreeInfo)getObject(key);
    }
    public void set(int index, StockingBatchTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBatchTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBatchTreeInfo item)
    {
        return super.indexOf(item);
    }
}