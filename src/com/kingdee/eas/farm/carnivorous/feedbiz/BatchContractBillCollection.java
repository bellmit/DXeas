package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchContractBillCollection extends AbstractObjectCollection 
{
    public BatchContractBillCollection()
    {
        super(BatchContractBillInfo.class);
    }
    public boolean add(BatchContractBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchContractBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchContractBillInfo item)
    {
        return removeObject(item);
    }
    public BatchContractBillInfo get(int index)
    {
        return(BatchContractBillInfo)getObject(index);
    }
    public BatchContractBillInfo get(Object key)
    {
        return(BatchContractBillInfo)getObject(key);
    }
    public void set(int index, BatchContractBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchContractBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchContractBillInfo item)
    {
        return super.indexOf(item);
    }
}