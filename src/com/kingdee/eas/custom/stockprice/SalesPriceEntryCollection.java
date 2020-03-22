package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SalesPriceEntryCollection extends AbstractObjectCollection 
{
    public SalesPriceEntryCollection()
    {
        super(SalesPriceEntryInfo.class);
    }
    public boolean add(SalesPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SalesPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SalesPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public SalesPriceEntryInfo get(int index)
    {
        return(SalesPriceEntryInfo)getObject(index);
    }
    public SalesPriceEntryInfo get(Object key)
    {
        return(SalesPriceEntryInfo)getObject(key);
    }
    public void set(int index, SalesPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SalesPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SalesPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}