package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DayRateCostDetailEntryDetailCollection extends AbstractObjectCollection 
{
    public DayRateCostDetailEntryDetailCollection()
    {
        super(DayRateCostDetailEntryDetailInfo.class);
    }
    public boolean add(DayRateCostDetailEntryDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DayRateCostDetailEntryDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DayRateCostDetailEntryDetailInfo item)
    {
        return removeObject(item);
    }
    public DayRateCostDetailEntryDetailInfo get(int index)
    {
        return(DayRateCostDetailEntryDetailInfo)getObject(index);
    }
    public DayRateCostDetailEntryDetailInfo get(Object key)
    {
        return(DayRateCostDetailEntryDetailInfo)getObject(key);
    }
    public void set(int index, DayRateCostDetailEntryDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DayRateCostDetailEntryDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DayRateCostDetailEntryDetailInfo item)
    {
        return super.indexOf(item);
    }
}