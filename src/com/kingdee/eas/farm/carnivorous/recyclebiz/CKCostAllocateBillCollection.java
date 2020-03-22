package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKCostAllocateBillCollection extends AbstractObjectCollection 
{
    public CKCostAllocateBillCollection()
    {
        super(CKCostAllocateBillInfo.class);
    }
    public boolean add(CKCostAllocateBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKCostAllocateBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKCostAllocateBillInfo item)
    {
        return removeObject(item);
    }
    public CKCostAllocateBillInfo get(int index)
    {
        return(CKCostAllocateBillInfo)getObject(index);
    }
    public CKCostAllocateBillInfo get(Object key)
    {
        return(CKCostAllocateBillInfo)getObject(key);
    }
    public void set(int index, CKCostAllocateBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKCostAllocateBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKCostAllocateBillInfo item)
    {
        return super.indexOf(item);
    }
}