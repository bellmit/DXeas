package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CostAllocationEntryCollection extends AbstractObjectCollection 
{
    public CostAllocationEntryCollection()
    {
        super(CostAllocationEntryInfo.class);
    }
    public boolean add(CostAllocationEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CostAllocationEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CostAllocationEntryInfo item)
    {
        return removeObject(item);
    }
    public CostAllocationEntryInfo get(int index)
    {
        return(CostAllocationEntryInfo)getObject(index);
    }
    public CostAllocationEntryInfo get(Object key)
    {
        return(CostAllocationEntryInfo)getObject(key);
    }
    public void set(int index, CostAllocationEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CostAllocationEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CostAllocationEntryInfo item)
    {
        return super.indexOf(item);
    }
}