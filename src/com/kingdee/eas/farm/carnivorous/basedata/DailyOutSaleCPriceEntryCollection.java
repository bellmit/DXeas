package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DailyOutSaleCPriceEntryCollection extends AbstractObjectCollection 
{
    public DailyOutSaleCPriceEntryCollection()
    {
        super(DailyOutSaleCPriceEntryInfo.class);
    }
    public boolean add(DailyOutSaleCPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DailyOutSaleCPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DailyOutSaleCPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public DailyOutSaleCPriceEntryInfo get(int index)
    {
        return(DailyOutSaleCPriceEntryInfo)getObject(index);
    }
    public DailyOutSaleCPriceEntryInfo get(Object key)
    {
        return(DailyOutSaleCPriceEntryInfo)getObject(key);
    }
    public void set(int index, DailyOutSaleCPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DailyOutSaleCPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DailyOutSaleCPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}