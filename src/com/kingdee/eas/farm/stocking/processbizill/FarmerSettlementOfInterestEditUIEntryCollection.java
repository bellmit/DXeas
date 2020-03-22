package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerSettlementOfInterestEditUIEntryCollection extends AbstractObjectCollection 
{
    public FarmerSettlementOfInterestEditUIEntryCollection()
    {
        super(FarmerSettlementOfInterestEditUIEntryInfo.class);
    }
    public boolean add(FarmerSettlementOfInterestEditUIEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerSettlementOfInterestEditUIEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerSettlementOfInterestEditUIEntryInfo item)
    {
        return removeObject(item);
    }
    public FarmerSettlementOfInterestEditUIEntryInfo get(int index)
    {
        return(FarmerSettlementOfInterestEditUIEntryInfo)getObject(index);
    }
    public FarmerSettlementOfInterestEditUIEntryInfo get(Object key)
    {
        return(FarmerSettlementOfInterestEditUIEntryInfo)getObject(key);
    }
    public void set(int index, FarmerSettlementOfInterestEditUIEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerSettlementOfInterestEditUIEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerSettlementOfInterestEditUIEntryInfo item)
    {
        return super.indexOf(item);
    }
}