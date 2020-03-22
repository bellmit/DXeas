package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerApplyBillFarmEntryCollection extends AbstractObjectCollection 
{
    public FarmerApplyBillFarmEntryCollection()
    {
        super(FarmerApplyBillFarmEntryInfo.class);
    }
    public boolean add(FarmerApplyBillFarmEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerApplyBillFarmEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerApplyBillFarmEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmerApplyBillFarmEntryInfo get(int index)
    {
        return(FarmerApplyBillFarmEntryInfo)getObject(index);
    }
    public FarmerApplyBillFarmEntryInfo get(Object key)
    {
        return(FarmerApplyBillFarmEntryInfo)getObject(key);
    }
    public void set(int index, FarmerApplyBillFarmEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerApplyBillFarmEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerApplyBillFarmEntryInfo item)
    {
        return super.indexOf(item);
    }
}