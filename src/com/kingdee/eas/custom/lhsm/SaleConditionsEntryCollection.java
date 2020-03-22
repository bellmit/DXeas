package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SaleConditionsEntryCollection extends AbstractObjectCollection 
{
    public SaleConditionsEntryCollection()
    {
        super(SaleConditionsEntryInfo.class);
    }
    public boolean add(SaleConditionsEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SaleConditionsEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SaleConditionsEntryInfo item)
    {
        return removeObject(item);
    }
    public SaleConditionsEntryInfo get(int index)
    {
        return(SaleConditionsEntryInfo)getObject(index);
    }
    public SaleConditionsEntryInfo get(Object key)
    {
        return(SaleConditionsEntryInfo)getObject(key);
    }
    public void set(int index, SaleConditionsEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SaleConditionsEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SaleConditionsEntryInfo item)
    {
        return super.indexOf(item);
    }
}