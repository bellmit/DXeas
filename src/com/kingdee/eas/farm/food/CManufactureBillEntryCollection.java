package com.kingdee.eas.farm.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CManufactureBillEntryCollection extends AbstractObjectCollection 
{
    public CManufactureBillEntryCollection()
    {
        super(CManufactureBillEntryInfo.class);
    }
    public boolean add(CManufactureBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CManufactureBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CManufactureBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CManufactureBillEntryInfo get(int index)
    {
        return(CManufactureBillEntryInfo)getObject(index);
    }
    public CManufactureBillEntryInfo get(Object key)
    {
        return(CManufactureBillEntryInfo)getObject(key);
    }
    public void set(int index, CManufactureBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CManufactureBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CManufactureBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}