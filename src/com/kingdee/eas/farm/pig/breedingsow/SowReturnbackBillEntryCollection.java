package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SowReturnbackBillEntryCollection extends AbstractObjectCollection 
{
    public SowReturnbackBillEntryCollection()
    {
        super(SowReturnbackBillEntryInfo.class);
    }
    public boolean add(SowReturnbackBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SowReturnbackBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SowReturnbackBillEntryInfo item)
    {
        return removeObject(item);
    }
    public SowReturnbackBillEntryInfo get(int index)
    {
        return(SowReturnbackBillEntryInfo)getObject(index);
    }
    public SowReturnbackBillEntryInfo get(Object key)
    {
        return(SowReturnbackBillEntryInfo)getObject(key);
    }
    public void set(int index, SowReturnbackBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SowReturnbackBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SowReturnbackBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}