package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BoarDailyEnviConEntryCollection extends AbstractObjectCollection 
{
    public BoarDailyEnviConEntryCollection()
    {
        super(BoarDailyEnviConEntryInfo.class);
    }
    public boolean add(BoarDailyEnviConEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BoarDailyEnviConEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BoarDailyEnviConEntryInfo item)
    {
        return removeObject(item);
    }
    public BoarDailyEnviConEntryInfo get(int index)
    {
        return(BoarDailyEnviConEntryInfo)getObject(index);
    }
    public BoarDailyEnviConEntryInfo get(Object key)
    {
        return(BoarDailyEnviConEntryInfo)getObject(key);
    }
    public void set(int index, BoarDailyEnviConEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BoarDailyEnviConEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BoarDailyEnviConEntryInfo item)
    {
        return super.indexOf(item);
    }
}