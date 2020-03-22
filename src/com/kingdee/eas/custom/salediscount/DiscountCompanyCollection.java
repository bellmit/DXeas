package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DiscountCompanyCollection extends AbstractObjectCollection 
{
    public DiscountCompanyCollection()
    {
        super(DiscountCompanyInfo.class);
    }
    public boolean add(DiscountCompanyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DiscountCompanyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DiscountCompanyInfo item)
    {
        return removeObject(item);
    }
    public DiscountCompanyInfo get(int index)
    {
        return(DiscountCompanyInfo)getObject(index);
    }
    public DiscountCompanyInfo get(Object key)
    {
        return(DiscountCompanyInfo)getObject(key);
    }
    public void set(int index, DiscountCompanyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DiscountCompanyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DiscountCompanyInfo item)
    {
        return super.indexOf(item);
    }
}