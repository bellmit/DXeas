package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKGrowthFreightBillCollection extends AbstractObjectCollection 
{
    public CKGrowthFreightBillCollection()
    {
        super(CKGrowthFreightBillInfo.class);
    }
    public boolean add(CKGrowthFreightBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKGrowthFreightBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKGrowthFreightBillInfo item)
    {
        return removeObject(item);
    }
    public CKGrowthFreightBillInfo get(int index)
    {
        return(CKGrowthFreightBillInfo)getObject(index);
    }
    public CKGrowthFreightBillInfo get(Object key)
    {
        return(CKGrowthFreightBillInfo)getObject(key);
    }
    public void set(int index, CKGrowthFreightBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKGrowthFreightBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKGrowthFreightBillInfo item)
    {
        return super.indexOf(item);
    }
}