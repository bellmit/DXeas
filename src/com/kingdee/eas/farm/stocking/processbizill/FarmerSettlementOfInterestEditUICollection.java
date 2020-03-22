package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerSettlementOfInterestEditUICollection extends AbstractObjectCollection 
{
    public FarmerSettlementOfInterestEditUICollection()
    {
        super(FarmerSettlementOfInterestEditUIInfo.class);
    }
    public boolean add(FarmerSettlementOfInterestEditUIInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerSettlementOfInterestEditUICollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerSettlementOfInterestEditUIInfo item)
    {
        return removeObject(item);
    }
    public FarmerSettlementOfInterestEditUIInfo get(int index)
    {
        return(FarmerSettlementOfInterestEditUIInfo)getObject(index);
    }
    public FarmerSettlementOfInterestEditUIInfo get(Object key)
    {
        return(FarmerSettlementOfInterestEditUIInfo)getObject(key);
    }
    public void set(int index, FarmerSettlementOfInterestEditUIInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerSettlementOfInterestEditUIInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerSettlementOfInterestEditUIInfo item)
    {
        return super.indexOf(item);
    }
}