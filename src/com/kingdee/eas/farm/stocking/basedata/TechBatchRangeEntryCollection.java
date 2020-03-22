package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TechBatchRangeEntryCollection extends AbstractObjectCollection 
{
    public TechBatchRangeEntryCollection()
    {
        super(TechBatchRangeEntryInfo.class);
    }
    public boolean add(TechBatchRangeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TechBatchRangeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TechBatchRangeEntryInfo item)
    {
        return removeObject(item);
    }
    public TechBatchRangeEntryInfo get(int index)
    {
        return(TechBatchRangeEntryInfo)getObject(index);
    }
    public TechBatchRangeEntryInfo get(Object key)
    {
        return(TechBatchRangeEntryInfo)getObject(key);
    }
    public void set(int index, TechBatchRangeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TechBatchRangeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TechBatchRangeEntryInfo item)
    {
        return super.indexOf(item);
    }
}