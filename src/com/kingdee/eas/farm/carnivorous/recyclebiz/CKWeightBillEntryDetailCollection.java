package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKWeightBillEntryDetailCollection extends AbstractObjectCollection 
{
    public CKWeightBillEntryDetailCollection()
    {
        super(CKWeightBillEntryDetailInfo.class);
    }
    public boolean add(CKWeightBillEntryDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKWeightBillEntryDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKWeightBillEntryDetailInfo item)
    {
        return removeObject(item);
    }
    public CKWeightBillEntryDetailInfo get(int index)
    {
        return(CKWeightBillEntryDetailInfo)getObject(index);
    }
    public CKWeightBillEntryDetailInfo get(Object key)
    {
        return(CKWeightBillEntryDetailInfo)getObject(key);
    }
    public void set(int index, CKWeightBillEntryDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKWeightBillEntryDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKWeightBillEntryDetailInfo item)
    {
        return super.indexOf(item);
    }
}