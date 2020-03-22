package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigBatchCollection extends AbstractObjectCollection 
{
    public PigBatchCollection()
    {
        super(PigBatchInfo.class);
    }
    public boolean add(PigBatchInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigBatchCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigBatchInfo item)
    {
        return removeObject(item);
    }
    public PigBatchInfo get(int index)
    {
        return(PigBatchInfo)getObject(index);
    }
    public PigBatchInfo get(Object key)
    {
        return(PigBatchInfo)getObject(key);
    }
    public void set(int index, PigBatchInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigBatchInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigBatchInfo item)
    {
        return super.indexOf(item);
    }
}