package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostAllocationCollection extends AbstractObjectCollection 
{
    public CostAllocationCollection()
    {
        super(CostAllocationInfo.class);
    }
    public boolean add(CostAllocationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostAllocationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostAllocationInfo item)
    {
        return removeObject(item);
    }
    public CostAllocationInfo get(int index)
    {
        return(CostAllocationInfo)getObject(index);
    }
    public CostAllocationInfo get(Object key)
    {
        return(CostAllocationInfo)getObject(key);
    }
    public void set(int index, CostAllocationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CostAllocationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostAllocationInfo item)
    {
        return super.indexOf(item);
    }
}