package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ArAmountOffsetDetailBillEntryCollection extends AbstractObjectCollection 
{
    public ArAmountOffsetDetailBillEntryCollection()
    {
        super(ArAmountOffsetDetailBillEntryInfo.class);
    }
    public boolean add(ArAmountOffsetDetailBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ArAmountOffsetDetailBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ArAmountOffsetDetailBillEntryInfo item)
    {
        return removeObject(item);
    }
    public ArAmountOffsetDetailBillEntryInfo get(int index)
    {
        return(ArAmountOffsetDetailBillEntryInfo)getObject(index);
    }
    public ArAmountOffsetDetailBillEntryInfo get(Object key)
    {
        return(ArAmountOffsetDetailBillEntryInfo)getObject(key);
    }
    public void set(int index, ArAmountOffsetDetailBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ArAmountOffsetDetailBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ArAmountOffsetDetailBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}