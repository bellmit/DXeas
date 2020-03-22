package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigDailyCullEntryCullEarNumberEntryCollection extends AbstractObjectCollection 
{
    public CCPigDailyCullEntryCullEarNumberEntryCollection()
    {
        super(CCPigDailyCullEntryCullEarNumberEntryInfo.class);
    }
    public boolean add(CCPigDailyCullEntryCullEarNumberEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigDailyCullEntryCullEarNumberEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigDailyCullEntryCullEarNumberEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigDailyCullEntryCullEarNumberEntryInfo get(int index)
    {
        return(CCPigDailyCullEntryCullEarNumberEntryInfo)getObject(index);
    }
    public CCPigDailyCullEntryCullEarNumberEntryInfo get(Object key)
    {
        return(CCPigDailyCullEntryCullEarNumberEntryInfo)getObject(key);
    }
    public void set(int index, CCPigDailyCullEntryCullEarNumberEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigDailyCullEntryCullEarNumberEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigDailyCullEntryCullEarNumberEntryInfo item)
    {
        return super.indexOf(item);
    }
}