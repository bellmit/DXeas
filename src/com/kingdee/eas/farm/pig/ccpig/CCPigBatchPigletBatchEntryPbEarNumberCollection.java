package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigBatchPigletBatchEntryPbEarNumberCollection extends AbstractObjectCollection 
{
    public CCPigBatchPigletBatchEntryPbEarNumberCollection()
    {
        super(CCPigBatchPigletBatchEntryPbEarNumberInfo.class);
    }
    public boolean add(CCPigBatchPigletBatchEntryPbEarNumberInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigBatchPigletBatchEntryPbEarNumberCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigBatchPigletBatchEntryPbEarNumberInfo item)
    {
        return removeObject(item);
    }
    public CCPigBatchPigletBatchEntryPbEarNumberInfo get(int index)
    {
        return(CCPigBatchPigletBatchEntryPbEarNumberInfo)getObject(index);
    }
    public CCPigBatchPigletBatchEntryPbEarNumberInfo get(Object key)
    {
        return(CCPigBatchPigletBatchEntryPbEarNumberInfo)getObject(key);
    }
    public void set(int index, CCPigBatchPigletBatchEntryPbEarNumberInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigBatchPigletBatchEntryPbEarNumberInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigBatchPigletBatchEntryPbEarNumberInfo item)
    {
        return super.indexOf(item);
    }
}