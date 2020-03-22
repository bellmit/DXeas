package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SalesPriceCollection extends AbstractObjectCollection 
{
    public SalesPriceCollection()
    {
        super(SalesPriceInfo.class);
    }
    public boolean add(SalesPriceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SalesPriceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SalesPriceInfo item)
    {
        return removeObject(item);
    }
    public SalesPriceInfo get(int index)
    {
        return(SalesPriceInfo)getObject(index);
    }
    public SalesPriceInfo get(Object key)
    {
        return(SalesPriceInfo)getObject(key);
    }
    public void set(int index, SalesPriceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SalesPriceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SalesPriceInfo item)
    {
        return super.indexOf(item);
    }
}