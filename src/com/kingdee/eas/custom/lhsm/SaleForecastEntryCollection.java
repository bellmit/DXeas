package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SaleForecastEntryCollection extends AbstractObjectCollection 
{
    public SaleForecastEntryCollection()
    {
        super(SaleForecastEntryInfo.class);
    }
    public boolean add(SaleForecastEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SaleForecastEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SaleForecastEntryInfo item)
    {
        return removeObject(item);
    }
    public SaleForecastEntryInfo get(int index)
    {
        return(SaleForecastEntryInfo)getObject(index);
    }
    public SaleForecastEntryInfo get(Object key)
    {
        return(SaleForecastEntryInfo)getObject(key);
    }
    public void set(int index, SaleForecastEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SaleForecastEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SaleForecastEntryInfo item)
    {
        return super.indexOf(item);
    }
}