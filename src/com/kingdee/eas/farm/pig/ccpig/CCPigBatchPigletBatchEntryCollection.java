package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigBatchPigletBatchEntryCollection extends AbstractObjectCollection 
{
    public CCPigBatchPigletBatchEntryCollection()
    {
        super(CCPigBatchPigletBatchEntryInfo.class);
    }
    public boolean add(CCPigBatchPigletBatchEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigBatchPigletBatchEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigBatchPigletBatchEntryInfo item)
    {
        return removeObject(item);
    }
    public CCPigBatchPigletBatchEntryInfo get(int index)
    {
        return(CCPigBatchPigletBatchEntryInfo)getObject(index);
    }
    public CCPigBatchPigletBatchEntryInfo get(Object key)
    {
        return(CCPigBatchPigletBatchEntryInfo)getObject(key);
    }
    public void set(int index, CCPigBatchPigletBatchEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigBatchPigletBatchEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigBatchPigletBatchEntryInfo item)
    {
        return super.indexOf(item);
    }
}