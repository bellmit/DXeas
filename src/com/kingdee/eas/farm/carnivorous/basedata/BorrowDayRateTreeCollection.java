package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BorrowDayRateTreeCollection extends AbstractObjectCollection 
{
    public BorrowDayRateTreeCollection()
    {
        super(BorrowDayRateTreeInfo.class);
    }
    public boolean add(BorrowDayRateTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BorrowDayRateTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BorrowDayRateTreeInfo item)
    {
        return removeObject(item);
    }
    public BorrowDayRateTreeInfo get(int index)
    {
        return(BorrowDayRateTreeInfo)getObject(index);
    }
    public BorrowDayRateTreeInfo get(Object key)
    {
        return(BorrowDayRateTreeInfo)getObject(key);
    }
    public void set(int index, BorrowDayRateTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BorrowDayRateTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BorrowDayRateTreeInfo item)
    {
        return super.indexOf(item);
    }
}