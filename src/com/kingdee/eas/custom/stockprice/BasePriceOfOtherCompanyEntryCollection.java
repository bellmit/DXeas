package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BasePriceOfOtherCompanyEntryCollection extends AbstractObjectCollection 
{
    public BasePriceOfOtherCompanyEntryCollection()
    {
        super(BasePriceOfOtherCompanyEntryInfo.class);
    }
    public boolean add(BasePriceOfOtherCompanyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BasePriceOfOtherCompanyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BasePriceOfOtherCompanyEntryInfo item)
    {
        return removeObject(item);
    }
    public BasePriceOfOtherCompanyEntryInfo get(int index)
    {
        return(BasePriceOfOtherCompanyEntryInfo)getObject(index);
    }
    public BasePriceOfOtherCompanyEntryInfo get(Object key)
    {
        return(BasePriceOfOtherCompanyEntryInfo)getObject(key);
    }
    public void set(int index, BasePriceOfOtherCompanyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BasePriceOfOtherCompanyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BasePriceOfOtherCompanyEntryInfo item)
    {
        return super.indexOf(item);
    }
}