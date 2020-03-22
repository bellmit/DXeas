package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchBreedApplyBillEntryCollection extends AbstractObjectCollection 
{
    public BatchBreedApplyBillEntryCollection()
    {
        super(BatchBreedApplyBillEntryInfo.class);
    }
    public boolean add(BatchBreedApplyBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchBreedApplyBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchBreedApplyBillEntryInfo item)
    {
        return removeObject(item);
    }
    public BatchBreedApplyBillEntryInfo get(int index)
    {
        return(BatchBreedApplyBillEntryInfo)getObject(index);
    }
    public BatchBreedApplyBillEntryInfo get(Object key)
    {
        return(BatchBreedApplyBillEntryInfo)getObject(key);
    }
    public void set(int index, BatchBreedApplyBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchBreedApplyBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchBreedApplyBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}