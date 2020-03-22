package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SaleForecastCollection extends AbstractObjectCollection 
{
    public SaleForecastCollection()
    {
        super(SaleForecastInfo.class);
    }
    public boolean add(SaleForecastInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SaleForecastCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SaleForecastInfo item)
    {
        return removeObject(item);
    }
    public SaleForecastInfo get(int index)
    {
        return(SaleForecastInfo)getObject(index);
    }
    public SaleForecastInfo get(Object key)
    {
        return(SaleForecastInfo)getObject(key);
    }
    public void set(int index, SaleForecastInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SaleForecastInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SaleForecastInfo item)
    {
        return super.indexOf(item);
    }
}