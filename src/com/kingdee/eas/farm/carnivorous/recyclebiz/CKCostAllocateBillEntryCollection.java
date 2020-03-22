package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKCostAllocateBillEntryCollection extends AbstractObjectCollection 
{
    public CKCostAllocateBillEntryCollection()
    {
        super(CKCostAllocateBillEntryInfo.class);
    }
    public boolean add(CKCostAllocateBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKCostAllocateBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKCostAllocateBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CKCostAllocateBillEntryInfo get(int index)
    {
        return(CKCostAllocateBillEntryInfo)getObject(index);
    }
    public CKCostAllocateBillEntryInfo get(Object key)
    {
        return(CKCostAllocateBillEntryInfo)getObject(key);
    }
    public void set(int index, CKCostAllocateBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKCostAllocateBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKCostAllocateBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}