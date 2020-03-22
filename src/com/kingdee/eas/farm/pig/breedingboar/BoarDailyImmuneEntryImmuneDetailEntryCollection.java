package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BoarDailyImmuneEntryImmuneDetailEntryCollection extends AbstractObjectCollection 
{
    public BoarDailyImmuneEntryImmuneDetailEntryCollection()
    {
        super(BoarDailyImmuneEntryImmuneDetailEntryInfo.class);
    }
    public boolean add(BoarDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BoarDailyImmuneEntryImmuneDetailEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BoarDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        return removeObject(item);
    }
    public BoarDailyImmuneEntryImmuneDetailEntryInfo get(int index)
    {
        return(BoarDailyImmuneEntryImmuneDetailEntryInfo)getObject(index);
    }
    public BoarDailyImmuneEntryImmuneDetailEntryInfo get(Object key)
    {
        return(BoarDailyImmuneEntryImmuneDetailEntryInfo)getObject(key);
    }
    public void set(int index, BoarDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BoarDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BoarDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        return super.indexOf(item);
    }
}