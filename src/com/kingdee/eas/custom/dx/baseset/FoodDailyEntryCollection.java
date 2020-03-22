package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FoodDailyEntryCollection extends AbstractObjectCollection 
{
    public FoodDailyEntryCollection()
    {
        super(FoodDailyEntryInfo.class);
    }
    public boolean add(FoodDailyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FoodDailyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FoodDailyEntryInfo item)
    {
        return removeObject(item);
    }
    public FoodDailyEntryInfo get(int index)
    {
        return(FoodDailyEntryInfo)getObject(index);
    }
    public FoodDailyEntryInfo get(Object key)
    {
        return(FoodDailyEntryInfo)getObject(key);
    }
    public void set(int index, FoodDailyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FoodDailyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FoodDailyEntryInfo item)
    {
        return super.indexOf(item);
    }
}