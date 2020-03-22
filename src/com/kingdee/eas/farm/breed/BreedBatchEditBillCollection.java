package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BreedBatchEditBillCollection extends AbstractObjectCollection 
{
    public BreedBatchEditBillCollection()
    {
        super(BreedBatchEditBillInfo.class);
    }
    public boolean add(BreedBatchEditBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BreedBatchEditBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BreedBatchEditBillInfo item)
    {
        return removeObject(item);
    }
    public BreedBatchEditBillInfo get(int index)
    {
        return(BreedBatchEditBillInfo)getObject(index);
    }
    public BreedBatchEditBillInfo get(Object key)
    {
        return(BreedBatchEditBillInfo)getObject(key);
    }
    public void set(int index, BreedBatchEditBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BreedBatchEditBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BreedBatchEditBillInfo item)
    {
        return super.indexOf(item);
    }
}