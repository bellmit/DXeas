package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CTransDrugBillEntryCollection extends AbstractObjectCollection 
{
    public CTransDrugBillEntryCollection()
    {
        super(CTransDrugBillEntryInfo.class);
    }
    public boolean add(CTransDrugBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CTransDrugBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CTransDrugBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CTransDrugBillEntryInfo get(int index)
    {
        return(CTransDrugBillEntryInfo)getObject(index);
    }
    public CTransDrugBillEntryInfo get(Object key)
    {
        return(CTransDrugBillEntryInfo)getObject(key);
    }
    public void set(int index, CTransDrugBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CTransDrugBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CTransDrugBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}