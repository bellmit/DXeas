package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreshDailyCollection extends AbstractObjectCollection 
{
    public FreshDailyCollection()
    {
        super(FreshDailyInfo.class);
    }
    public boolean add(FreshDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreshDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreshDailyInfo item)
    {
        return removeObject(item);
    }
    public FreshDailyInfo get(int index)
    {
        return(FreshDailyInfo)getObject(index);
    }
    public FreshDailyInfo get(Object key)
    {
        return(FreshDailyInfo)getObject(key);
    }
    public void set(int index, FreshDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreshDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreshDailyInfo item)
    {
        return super.indexOf(item);
    }
}