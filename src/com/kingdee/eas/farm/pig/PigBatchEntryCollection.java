package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigBatchEntryCollection extends AbstractObjectCollection 
{
    public PigBatchEntryCollection()
    {
        super(PigBatchEntryInfo.class);
    }
    public boolean add(PigBatchEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigBatchEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigBatchEntryInfo item)
    {
        return removeObject(item);
    }
    public PigBatchEntryInfo get(int index)
    {
        return(PigBatchEntryInfo)getObject(index);
    }
    public PigBatchEntryInfo get(Object key)
    {
        return(PigBatchEntryInfo)getObject(key);
    }
    public void set(int index, PigBatchEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigBatchEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigBatchEntryInfo item)
    {
        return super.indexOf(item);
    }
}