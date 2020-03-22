package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MonthFeeCollection extends AbstractObjectCollection 
{
    public MonthFeeCollection()
    {
        super(MonthFeeInfo.class);
    }
    public boolean add(MonthFeeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MonthFeeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MonthFeeInfo item)
    {
        return removeObject(item);
    }
    public MonthFeeInfo get(int index)
    {
        return(MonthFeeInfo)getObject(index);
    }
    public MonthFeeInfo get(Object key)
    {
        return(MonthFeeInfo)getObject(key);
    }
    public void set(int index, MonthFeeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MonthFeeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MonthFeeInfo item)
    {
        return super.indexOf(item);
    }
}