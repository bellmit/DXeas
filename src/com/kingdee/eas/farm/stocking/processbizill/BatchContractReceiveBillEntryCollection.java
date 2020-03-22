package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchContractReceiveBillEntryCollection extends AbstractObjectCollection 
{
    public BatchContractReceiveBillEntryCollection()
    {
        super(BatchContractReceiveBillEntryInfo.class);
    }
    public boolean add(BatchContractReceiveBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchContractReceiveBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchContractReceiveBillEntryInfo item)
    {
        return removeObject(item);
    }
    public BatchContractReceiveBillEntryInfo get(int index)
    {
        return(BatchContractReceiveBillEntryInfo)getObject(index);
    }
    public BatchContractReceiveBillEntryInfo get(Object key)
    {
        return(BatchContractReceiveBillEntryInfo)getObject(key);
    }
    public void set(int index, BatchContractReceiveBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchContractReceiveBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchContractReceiveBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}