package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchBreedApplyBillCollection extends AbstractObjectCollection 
{
    public BatchBreedApplyBillCollection()
    {
        super(BatchBreedApplyBillInfo.class);
    }
    public boolean add(BatchBreedApplyBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchBreedApplyBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchBreedApplyBillInfo item)
    {
        return removeObject(item);
    }
    public BatchBreedApplyBillInfo get(int index)
    {
        return(BatchBreedApplyBillInfo)getObject(index);
    }
    public BatchBreedApplyBillInfo get(Object key)
    {
        return(BatchBreedApplyBillInfo)getObject(key);
    }
    public void set(int index, BatchBreedApplyBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchBreedApplyBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchBreedApplyBillInfo item)
    {
        return super.indexOf(item);
    }
}