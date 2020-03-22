package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreshCountBillEntryCollection extends AbstractObjectCollection 
{
    public FreshCountBillEntryCollection()
    {
        super(FreshCountBillEntryInfo.class);
    }
    public boolean add(FreshCountBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreshCountBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreshCountBillEntryInfo item)
    {
        return removeObject(item);
    }
    public FreshCountBillEntryInfo get(int index)
    {
        return(FreshCountBillEntryInfo)getObject(index);
    }
    public FreshCountBillEntryInfo get(Object key)
    {
        return(FreshCountBillEntryInfo)getObject(key);
    }
    public void set(int index, FreshCountBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreshCountBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreshCountBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}