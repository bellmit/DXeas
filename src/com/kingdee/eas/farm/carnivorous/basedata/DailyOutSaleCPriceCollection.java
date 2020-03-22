package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DailyOutSaleCPriceCollection extends AbstractObjectCollection 
{
    public DailyOutSaleCPriceCollection()
    {
        super(DailyOutSaleCPriceInfo.class);
    }
    public boolean add(DailyOutSaleCPriceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DailyOutSaleCPriceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DailyOutSaleCPriceInfo item)
    {
        return removeObject(item);
    }
    public DailyOutSaleCPriceInfo get(int index)
    {
        return(DailyOutSaleCPriceInfo)getObject(index);
    }
    public DailyOutSaleCPriceInfo get(Object key)
    {
        return(DailyOutSaleCPriceInfo)getObject(key);
    }
    public void set(int index, DailyOutSaleCPriceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DailyOutSaleCPriceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DailyOutSaleCPriceInfo item)
    {
        return super.indexOf(item);
    }
}