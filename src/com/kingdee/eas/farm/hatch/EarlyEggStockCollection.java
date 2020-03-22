package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EarlyEggStockCollection extends AbstractObjectCollection 
{
    public EarlyEggStockCollection()
    {
        super(EarlyEggStockInfo.class);
    }
    public boolean add(EarlyEggStockInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EarlyEggStockCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EarlyEggStockInfo item)
    {
        return removeObject(item);
    }
    public EarlyEggStockInfo get(int index)
    {
        return(EarlyEggStockInfo)getObject(index);
    }
    public EarlyEggStockInfo get(Object key)
    {
        return(EarlyEggStockInfo)getObject(key);
    }
    public void set(int index, EarlyEggStockInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EarlyEggStockInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EarlyEggStockInfo item)
    {
        return super.indexOf(item);
    }
}