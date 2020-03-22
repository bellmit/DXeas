package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CTransDrugBillCollection extends AbstractObjectCollection 
{
    public CTransDrugBillCollection()
    {
        super(CTransDrugBillInfo.class);
    }
    public boolean add(CTransDrugBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CTransDrugBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CTransDrugBillInfo item)
    {
        return removeObject(item);
    }
    public CTransDrugBillInfo get(int index)
    {
        return(CTransDrugBillInfo)getObject(index);
    }
    public CTransDrugBillInfo get(Object key)
    {
        return(CTransDrugBillInfo)getObject(key);
    }
    public void set(int index, CTransDrugBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CTransDrugBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CTransDrugBillInfo item)
    {
        return super.indexOf(item);
    }
}