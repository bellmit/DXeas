package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigBatchEntryCollection extends AbstractObjectCollection 
{
    public CCPigBatchEntryCollection()
    {
        super(CCPigBatchEntryInfo.class);
    }
    public boolean add(CCPigBatchEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigBatchEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigBatchEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigBatchEntryInfo get(int index)
    {
        return(CCPigBatchEntryInfo)getObject(index);
    }
    public CCPigBatchEntryInfo get(Object key)
    {
        return(CCPigBatchEntryInfo)getObject(key);
    }
    public void set(int index, CCPigBatchEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigBatchEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigBatchEntryInfo item)
    {
        return super.indexOf(item);
    }
}