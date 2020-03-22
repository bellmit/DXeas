package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MonthFeeEntryCollection extends AbstractObjectCollection 
{
    public MonthFeeEntryCollection()
    {
        super(MonthFeeEntryInfo.class);
    }
    public boolean add(MonthFeeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MonthFeeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MonthFeeEntryInfo item)
    {
        return removeObject(item);
    }
    public MonthFeeEntryInfo get(int index)
    {
        return(MonthFeeEntryInfo)getObject(index);
    }
    public MonthFeeEntryInfo get(Object key)
    {
        return(MonthFeeEntryInfo)getObject(key);
    }
    public void set(int index, MonthFeeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MonthFeeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MonthFeeEntryInfo item)
    {
        return super.indexOf(item);
    }
}