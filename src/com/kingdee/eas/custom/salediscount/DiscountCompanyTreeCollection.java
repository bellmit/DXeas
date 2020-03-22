package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DiscountCompanyTreeCollection extends AbstractObjectCollection 
{
    public DiscountCompanyTreeCollection()
    {
        super(DiscountCompanyTreeInfo.class);
    }
    public boolean add(DiscountCompanyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DiscountCompanyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DiscountCompanyTreeInfo item)
    {
        return removeObject(item);
    }
    public DiscountCompanyTreeInfo get(int index)
    {
        return(DiscountCompanyTreeInfo)getObject(index);
    }
    public DiscountCompanyTreeInfo get(Object key)
    {
        return(DiscountCompanyTreeInfo)getObject(key);
    }
    public void set(int index, DiscountCompanyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DiscountCompanyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DiscountCompanyTreeInfo item)
    {
        return super.indexOf(item);
    }
}