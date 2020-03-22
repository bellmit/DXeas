package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BasePriceOfOtherCompanyCollection extends AbstractObjectCollection 
{
    public BasePriceOfOtherCompanyCollection()
    {
        super(BasePriceOfOtherCompanyInfo.class);
    }
    public boolean add(BasePriceOfOtherCompanyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BasePriceOfOtherCompanyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BasePriceOfOtherCompanyInfo item)
    {
        return removeObject(item);
    }
    public BasePriceOfOtherCompanyInfo get(int index)
    {
        return(BasePriceOfOtherCompanyInfo)getObject(index);
    }
    public BasePriceOfOtherCompanyInfo get(Object key)
    {
        return(BasePriceOfOtherCompanyInfo)getObject(key);
    }
    public void set(int index, BasePriceOfOtherCompanyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BasePriceOfOtherCompanyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BasePriceOfOtherCompanyInfo item)
    {
        return super.indexOf(item);
    }
}