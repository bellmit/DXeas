package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKWeightBillCollection extends AbstractObjectCollection 
{
    public CKWeightBillCollection()
    {
        super(CKWeightBillInfo.class);
    }
    public boolean add(CKWeightBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKWeightBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKWeightBillInfo item)
    {
        return removeObject(item);
    }
    public CKWeightBillInfo get(int index)
    {
        return(CKWeightBillInfo)getObject(index);
    }
    public CKWeightBillInfo get(Object key)
    {
        return(CKWeightBillInfo)getObject(key);
    }
    public void set(int index, CKWeightBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKWeightBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKWeightBillInfo item)
    {
        return super.indexOf(item);
    }
}