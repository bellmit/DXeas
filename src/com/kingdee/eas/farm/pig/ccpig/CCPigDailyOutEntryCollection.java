package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigDailyOutEntryCollection extends AbstractObjectCollection 
{
    public CCPigDailyOutEntryCollection()
    {
        super(CCPigDailyOutEntryInfo.class);
    }
    public boolean add(CCPigDailyOutEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigDailyOutEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigDailyOutEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigDailyOutEntryInfo get(int index)
    {
        return(CCPigDailyOutEntryInfo)getObject(index);
    }
    public CCPigDailyOutEntryInfo get(Object key)
    {
        return(CCPigDailyOutEntryInfo)getObject(key);
    }
    public void set(int index, CCPigDailyOutEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigDailyOutEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigDailyOutEntryInfo item)
    {
        return super.indexOf(item);
    }
}