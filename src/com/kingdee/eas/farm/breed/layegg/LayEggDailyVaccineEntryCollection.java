package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LayEggDailyVaccineEntryCollection extends AbstractObjectCollection 
{
    public LayEggDailyVaccineEntryCollection()
    {
        super(LayEggDailyVaccineEntryInfo.class);
    }
    public boolean add(LayEggDailyVaccineEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LayEggDailyVaccineEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LayEggDailyVaccineEntryInfo item)
    {
        return removeObject(item);
    }
    public LayEggDailyVaccineEntryInfo get(int index)
    {
        return(LayEggDailyVaccineEntryInfo)getObject(index);
    }
    public LayEggDailyVaccineEntryInfo get(Object key)
    {
        return(LayEggDailyVaccineEntryInfo)getObject(key);
    }
    public void set(int index, LayEggDailyVaccineEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LayEggDailyVaccineEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LayEggDailyVaccineEntryInfo item)
    {
        return super.indexOf(item);
    }
}