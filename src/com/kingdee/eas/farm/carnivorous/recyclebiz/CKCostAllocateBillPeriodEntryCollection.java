package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKCostAllocateBillPeriodEntryCollection extends AbstractObjectCollection 
{
    public CKCostAllocateBillPeriodEntryCollection()
    {
        super(CKCostAllocateBillPeriodEntryInfo.class);
    }
    public boolean add(CKCostAllocateBillPeriodEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKCostAllocateBillPeriodEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKCostAllocateBillPeriodEntryInfo item)
    {
        return removeObject(item);
    }
    public CKCostAllocateBillPeriodEntryInfo get(int index)
    {
        return(CKCostAllocateBillPeriodEntryInfo)getObject(index);
    }
    public CKCostAllocateBillPeriodEntryInfo get(Object key)
    {
        return(CKCostAllocateBillPeriodEntryInfo)getObject(key);
    }
    public void set(int index, CKCostAllocateBillPeriodEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKCostAllocateBillPeriodEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKCostAllocateBillPeriodEntryInfo item)
    {
        return super.indexOf(item);
    }
}