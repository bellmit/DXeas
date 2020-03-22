package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchContractBillReceiveBillEntryCollection extends AbstractObjectCollection 
{
    public BatchContractBillReceiveBillEntryCollection()
    {
        super(BatchContractBillReceiveBillEntryInfo.class);
    }
    public boolean add(BatchContractBillReceiveBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchContractBillReceiveBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchContractBillReceiveBillEntryInfo item)
    {
        return removeObject(item);
    }
    public BatchContractBillReceiveBillEntryInfo get(int index)
    {
        return(BatchContractBillReceiveBillEntryInfo)getObject(index);
    }
    public BatchContractBillReceiveBillEntryInfo get(Object key)
    {
        return(BatchContractBillReceiveBillEntryInfo)getObject(key);
    }
    public void set(int index, BatchContractBillReceiveBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchContractBillReceiveBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchContractBillReceiveBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}