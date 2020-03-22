package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StockingBRelationCollection extends AbstractObjectCollection 
{
    public StockingBRelationCollection()
    {
        super(StockingBRelationInfo.class);
    }
    public boolean add(StockingBRelationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StockingBRelationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StockingBRelationInfo item)
    {
        return removeObject(item);
    }
    public StockingBRelationInfo get(int index)
    {
        return(StockingBRelationInfo)getObject(index);
    }
    public StockingBRelationInfo get(Object key)
    {
        return(StockingBRelationInfo)getObject(key);
    }
    public void set(int index, StockingBRelationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StockingBRelationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StockingBRelationInfo item)
    {
        return super.indexOf(item);
    }
}