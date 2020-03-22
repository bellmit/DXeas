package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenDailyCollection extends AbstractObjectCollection 
{
    public ChickenDailyCollection()
    {
        super(ChickenDailyInfo.class);
    }
    public boolean add(ChickenDailyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenDailyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenDailyInfo item)
    {
        return removeObject(item);
    }
    public ChickenDailyInfo get(int index)
    {
        return(ChickenDailyInfo)getObject(index);
    }
    public ChickenDailyInfo get(Object key)
    {
        return(ChickenDailyInfo)getObject(key);
    }
    public void set(int index, ChickenDailyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenDailyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenDailyInfo item)
    {
        return super.indexOf(item);
    }
}