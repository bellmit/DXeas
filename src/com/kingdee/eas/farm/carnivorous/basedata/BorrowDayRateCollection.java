package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BorrowDayRateCollection extends AbstractObjectCollection 
{
    public BorrowDayRateCollection()
    {
        super(BorrowDayRateInfo.class);
    }
    public boolean add(BorrowDayRateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BorrowDayRateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BorrowDayRateInfo item)
    {
        return removeObject(item);
    }
    public BorrowDayRateInfo get(int index)
    {
        return(BorrowDayRateInfo)getObject(index);
    }
    public BorrowDayRateInfo get(Object key)
    {
        return(BorrowDayRateInfo)getObject(key);
    }
    public void set(int index, BorrowDayRateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BorrowDayRateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BorrowDayRateInfo item)
    {
        return super.indexOf(item);
    }
}