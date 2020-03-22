package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CountrycheckPicentryCollection extends AbstractObjectCollection 
{
    public CountrycheckPicentryCollection()
    {
        super(CountrycheckPicentryInfo.class);
    }
    public boolean add(CountrycheckPicentryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CountrycheckPicentryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CountrycheckPicentryInfo item)
    {
        return removeObject(item);
    }
    public CountrycheckPicentryInfo get(int index)
    {
        return(CountrycheckPicentryInfo)getObject(index);
    }
    public CountrycheckPicentryInfo get(Object key)
    {
        return(CountrycheckPicentryInfo)getObject(key);
    }
    public void set(int index, CountrycheckPicentryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CountrycheckPicentryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CountrycheckPicentryInfo item)
    {
        return super.indexOf(item);
    }
}