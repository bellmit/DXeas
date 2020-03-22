package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MonthBillFarmCollection extends AbstractObjectCollection 
{
    public MonthBillFarmCollection()
    {
        super(MonthBillFarmInfo.class);
    }
    public boolean add(MonthBillFarmInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MonthBillFarmCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MonthBillFarmInfo item)
    {
        return removeObject(item);
    }
    public MonthBillFarmInfo get(int index)
    {
        return(MonthBillFarmInfo)getObject(index);
    }
    public MonthBillFarmInfo get(Object key)
    {
        return(MonthBillFarmInfo)getObject(key);
    }
    public void set(int index, MonthBillFarmInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MonthBillFarmInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MonthBillFarmInfo item)
    {
        return super.indexOf(item);
    }
}