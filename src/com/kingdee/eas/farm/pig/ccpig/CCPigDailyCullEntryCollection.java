package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigDailyCullEntryCollection extends AbstractObjectCollection 
{
    public CCPigDailyCullEntryCollection()
    {
        super(CCPigDailyCullEntryInfo.class);
    }
    public boolean add(CCPigDailyCullEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigDailyCullEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigDailyCullEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigDailyCullEntryInfo get(int index)
    {
        return(CCPigDailyCullEntryInfo)getObject(index);
    }
    public CCPigDailyCullEntryInfo get(Object key)
    {
        return(CCPigDailyCullEntryInfo)getObject(key);
    }
    public void set(int index, CCPigDailyCullEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigDailyCullEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigDailyCullEntryInfo item)
    {
        return super.indexOf(item);
    }
}