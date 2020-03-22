package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKGrowthFreightBillEntryCollection extends AbstractObjectCollection 
{
    public CKGrowthFreightBillEntryCollection()
    {
        super(CKGrowthFreightBillEntryInfo.class);
    }
    public boolean add(CKGrowthFreightBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKGrowthFreightBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKGrowthFreightBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CKGrowthFreightBillEntryInfo get(int index)
    {
        return(CKGrowthFreightBillEntryInfo)getObject(index);
    }
    public CKGrowthFreightBillEntryInfo get(Object key)
    {
        return(CKGrowthFreightBillEntryInfo)getObject(key);
    }
    public void set(int index, CKGrowthFreightBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKGrowthFreightBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKGrowthFreightBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}