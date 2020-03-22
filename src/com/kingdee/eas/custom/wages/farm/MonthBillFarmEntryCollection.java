package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MonthBillFarmEntryCollection extends AbstractObjectCollection 
{
    public MonthBillFarmEntryCollection()
    {
        super(MonthBillFarmEntryInfo.class);
    }
    public boolean add(MonthBillFarmEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MonthBillFarmEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MonthBillFarmEntryInfo item)
    {
        return removeObject(item);
    }
    public MonthBillFarmEntryInfo get(int index)
    {
        return(MonthBillFarmEntryInfo)getObject(index);
    }
    public MonthBillFarmEntryInfo get(Object key)
    {
        return(MonthBillFarmEntryInfo)getObject(key);
    }
    public void set(int index, MonthBillFarmEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MonthBillFarmEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MonthBillFarmEntryInfo item)
    {
        return super.indexOf(item);
    }
}