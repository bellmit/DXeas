package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKFreightBillCollection extends AbstractObjectCollection 
{
    public CKFreightBillCollection()
    {
        super(CKFreightBillInfo.class);
    }
    public boolean add(CKFreightBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKFreightBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKFreightBillInfo item)
    {
        return removeObject(item);
    }
    public CKFreightBillInfo get(int index)
    {
        return(CKFreightBillInfo)getObject(index);
    }
    public CKFreightBillInfo get(Object key)
    {
        return(CKFreightBillInfo)getObject(key);
    }
    public void set(int index, CKFreightBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKFreightBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKFreightBillInfo item)
    {
        return super.indexOf(item);
    }
}