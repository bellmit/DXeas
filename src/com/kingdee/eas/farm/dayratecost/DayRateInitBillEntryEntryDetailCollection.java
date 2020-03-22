package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DayRateInitBillEntryEntryDetailCollection extends AbstractObjectCollection 
{
    public DayRateInitBillEntryEntryDetailCollection()
    {
        super(DayRateInitBillEntryEntryDetailInfo.class);
    }
    public boolean add(DayRateInitBillEntryEntryDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DayRateInitBillEntryEntryDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DayRateInitBillEntryEntryDetailInfo item)
    {
        return removeObject(item);
    }
    public DayRateInitBillEntryEntryDetailInfo get(int index)
    {
        return(DayRateInitBillEntryEntryDetailInfo)getObject(index);
    }
    public DayRateInitBillEntryEntryDetailInfo get(Object key)
    {
        return(DayRateInitBillEntryEntryDetailInfo)getObject(key);
    }
    public void set(int index, DayRateInitBillEntryEntryDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DayRateInitBillEntryEntryDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DayRateInitBillEntryEntryDetailInfo item)
    {
        return super.indexOf(item);
    }
}