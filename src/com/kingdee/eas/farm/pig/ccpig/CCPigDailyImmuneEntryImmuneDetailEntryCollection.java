package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigDailyImmuneEntryImmuneDetailEntryCollection extends AbstractObjectCollection 
{
    public CCPigDailyImmuneEntryImmuneDetailEntryCollection()
    {
        super(CCPigDailyImmuneEntryImmuneDetailEntryInfo.class);
    }
    public boolean add(CCPigDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigDailyImmuneEntryImmuneDetailEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigDailyImmuneEntryImmuneDetailEntryInfo get(int index)
    {
        return(CCPigDailyImmuneEntryImmuneDetailEntryInfo)getObject(index);
    }
    public CCPigDailyImmuneEntryImmuneDetailEntryInfo get(Object key)
    {
        return(CCPigDailyImmuneEntryImmuneDetailEntryInfo)getObject(key);
    }
    public void set(int index, CCPigDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigDailyImmuneEntryImmuneDetailEntryInfo item)
    {
        return super.indexOf(item);
    }
}