package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenDailyPriceCollection extends AbstractObjectCollection 
{
    public ChickenDailyPriceCollection()
    {
        super(ChickenDailyPriceInfo.class);
    }
    public boolean add(ChickenDailyPriceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenDailyPriceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenDailyPriceInfo item)
    {
        return removeObject(item);
    }
    public ChickenDailyPriceInfo get(int index)
    {
        return(ChickenDailyPriceInfo)getObject(index);
    }
    public ChickenDailyPriceInfo get(Object key)
    {
        return(ChickenDailyPriceInfo)getObject(key);
    }
    public void set(int index, ChickenDailyPriceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenDailyPriceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenDailyPriceInfo item)
    {
        return super.indexOf(item);
    }
}