package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MonthFreightCalBillCollection extends AbstractObjectCollection 
{
    public MonthFreightCalBillCollection()
    {
        super(MonthFreightCalBillInfo.class);
    }
    public boolean add(MonthFreightCalBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MonthFreightCalBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MonthFreightCalBillInfo item)
    {
        return removeObject(item);
    }
    public MonthFreightCalBillInfo get(int index)
    {
        return(MonthFreightCalBillInfo)getObject(index);
    }
    public MonthFreightCalBillInfo get(Object key)
    {
        return(MonthFreightCalBillInfo)getObject(key);
    }
    public void set(int index, MonthFreightCalBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MonthFreightCalBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MonthFreightCalBillInfo item)
    {
        return super.indexOf(item);
    }
}