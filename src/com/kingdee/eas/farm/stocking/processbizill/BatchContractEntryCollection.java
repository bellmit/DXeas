package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchContractEntryCollection extends AbstractObjectCollection 
{
    public BatchContractEntryCollection()
    {
        super(BatchContractEntryInfo.class);
    }
    public boolean add(BatchContractEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchContractEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchContractEntryInfo item)
    {
        return removeObject(item);
    }
    public BatchContractEntryInfo get(int index)
    {
        return(BatchContractEntryInfo)getObject(index);
    }
    public BatchContractEntryInfo get(Object key)
    {
        return(BatchContractEntryInfo)getObject(key);
    }
    public void set(int index, BatchContractEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchContractEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchContractEntryInfo item)
    {
        return super.indexOf(item);
    }
}