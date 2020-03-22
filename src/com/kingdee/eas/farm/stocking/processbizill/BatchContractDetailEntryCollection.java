package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchContractDetailEntryCollection extends AbstractObjectCollection 
{
    public BatchContractDetailEntryCollection()
    {
        super(BatchContractDetailEntryInfo.class);
    }
    public boolean add(BatchContractDetailEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchContractDetailEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchContractDetailEntryInfo item)
    {
        return removeObject(item);
    }
    public BatchContractDetailEntryInfo get(int index)
    {
        return(BatchContractDetailEntryInfo)getObject(index);
    }
    public BatchContractDetailEntryInfo get(Object key)
    {
        return(BatchContractDetailEntryInfo)getObject(key);
    }
    public void set(int index, BatchContractDetailEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchContractDetailEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchContractDetailEntryInfo item)
    {
        return super.indexOf(item);
    }
}