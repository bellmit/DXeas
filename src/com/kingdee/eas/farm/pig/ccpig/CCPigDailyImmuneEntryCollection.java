package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigDailyImmuneEntryCollection extends AbstractObjectCollection 
{
    public CCPigDailyImmuneEntryCollection()
    {
        super(CCPigDailyImmuneEntryInfo.class);
    }
    public boolean add(CCPigDailyImmuneEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigDailyImmuneEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigDailyImmuneEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigDailyImmuneEntryInfo get(int index)
    {
        return(CCPigDailyImmuneEntryInfo)getObject(index);
    }
    public CCPigDailyImmuneEntryInfo get(Object key)
    {
        return(CCPigDailyImmuneEntryInfo)getObject(key);
    }
    public void set(int index, CCPigDailyImmuneEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigDailyImmuneEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigDailyImmuneEntryInfo item)
    {
        return super.indexOf(item);
    }
}