package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FractionOtherBillEntryCollection extends AbstractObjectCollection 
{
    public FractionOtherBillEntryCollection()
    {
        super(FractionOtherBillEntryInfo.class);
    }
    public boolean add(FractionOtherBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FractionOtherBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FractionOtherBillEntryInfo item)
    {
        return removeObject(item);
    }
    public FractionOtherBillEntryInfo get(int index)
    {
        return(FractionOtherBillEntryInfo)getObject(index);
    }
    public FractionOtherBillEntryInfo get(Object key)
    {
        return(FractionOtherBillEntryInfo)getObject(key);
    }
    public void set(int index, FractionOtherBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FractionOtherBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FractionOtherBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}