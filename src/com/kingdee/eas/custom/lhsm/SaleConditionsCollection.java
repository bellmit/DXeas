package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SaleConditionsCollection extends AbstractObjectCollection 
{
    public SaleConditionsCollection()
    {
        super(SaleConditionsInfo.class);
    }
    public boolean add(SaleConditionsInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SaleConditionsCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SaleConditionsInfo item)
    {
        return removeObject(item);
    }
    public SaleConditionsInfo get(int index)
    {
        return(SaleConditionsInfo)getObject(index);
    }
    public SaleConditionsInfo get(Object key)
    {
        return(SaleConditionsInfo)getObject(key);
    }
    public void set(int index, SaleConditionsInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SaleConditionsInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SaleConditionsInfo item)
    {
        return super.indexOf(item);
    }
}