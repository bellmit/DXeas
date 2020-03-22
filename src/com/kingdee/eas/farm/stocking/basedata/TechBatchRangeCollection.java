package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TechBatchRangeCollection extends AbstractObjectCollection 
{
    public TechBatchRangeCollection()
    {
        super(TechBatchRangeInfo.class);
    }
    public boolean add(TechBatchRangeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TechBatchRangeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TechBatchRangeInfo item)
    {
        return removeObject(item);
    }
    public TechBatchRangeInfo get(int index)
    {
        return(TechBatchRangeInfo)getObject(index);
    }
    public TechBatchRangeInfo get(Object key)
    {
        return(TechBatchRangeInfo)getObject(key);
    }
    public void set(int index, TechBatchRangeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TechBatchRangeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TechBatchRangeInfo item)
    {
        return super.indexOf(item);
    }
}