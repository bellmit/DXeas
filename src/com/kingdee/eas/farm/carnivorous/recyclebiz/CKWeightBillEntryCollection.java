package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKWeightBillEntryCollection extends AbstractObjectCollection 
{
    public CKWeightBillEntryCollection()
    {
        super(CKWeightBillEntryInfo.class);
    }
    public boolean add(CKWeightBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKWeightBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKWeightBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CKWeightBillEntryInfo get(int index)
    {
        return(CKWeightBillEntryInfo)getObject(index);
    }
    public CKWeightBillEntryInfo get(Object key)
    {
        return(CKWeightBillEntryInfo)getObject(key);
    }
    public void set(int index, CKWeightBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKWeightBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKWeightBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}