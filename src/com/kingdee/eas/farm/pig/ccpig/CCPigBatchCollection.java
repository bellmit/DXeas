package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCPigBatchCollection extends AbstractObjectCollection 
{
    public CCPigBatchCollection()
    {
        super(CCPigBatchInfo.class);
    }
    public boolean add(CCPigBatchInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCPigBatchCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCPigBatchInfo item)
    {
        return removeObject(item);
    }
    public CCPigBatchInfo get(int index)
    {
        return(CCPigBatchInfo)getObject(index);
    }
    public CCPigBatchInfo get(Object key)
    {
        return(CCPigBatchInfo)getObject(key);
    }
    public void set(int index, CCPigBatchInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCPigBatchInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCPigBatchInfo item)
    {
        return super.indexOf(item);
    }
}