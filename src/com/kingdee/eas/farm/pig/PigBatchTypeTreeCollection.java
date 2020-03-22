package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigBatchTypeTreeCollection extends AbstractObjectCollection 
{
    public PigBatchTypeTreeCollection()
    {
        super(PigBatchTypeTreeInfo.class);
    }
    public boolean add(PigBatchTypeTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigBatchTypeTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigBatchTypeTreeInfo item)
    {
        return removeObject(item);
    }
    public PigBatchTypeTreeInfo get(int index)
    {
        return(PigBatchTypeTreeInfo)getObject(index);
    }
    public PigBatchTypeTreeInfo get(Object key)
    {
        return(PigBatchTypeTreeInfo)getObject(key);
    }
    public void set(int index, PigBatchTypeTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigBatchTypeTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigBatchTypeTreeInfo item)
    {
        return super.indexOf(item);
    }
}