package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigDailyDCEntryCollection extends AbstractObjectCollection 
{
    public CCPigDailyDCEntryCollection()
    {
        super(CCPigDailyDCEntryInfo.class);
    }
    public boolean add(CCPigDailyDCEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigDailyDCEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigDailyDCEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigDailyDCEntryInfo get(int index)
    {
        return(CCPigDailyDCEntryInfo)getObject(index);
    }
    public CCPigDailyDCEntryInfo get(Object key)
    {
        return(CCPigDailyDCEntryInfo)getObject(key);
    }
    public void set(int index, CCPigDailyDCEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigDailyDCEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigDailyDCEntryInfo item)
    {
        return super.indexOf(item);
    }
}