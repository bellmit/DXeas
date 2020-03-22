package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreightMileageBillEntryCollection extends AbstractObjectCollection 
{
    public FreightMileageBillEntryCollection()
    {
        super(FreightMileageBillEntryInfo.class);
    }
    public boolean add(FreightMileageBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreightMileageBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreightMileageBillEntryInfo item)
    {
        return removeObject(item);
    }
    public FreightMileageBillEntryInfo get(int index)
    {
        return(FreightMileageBillEntryInfo)getObject(index);
    }
    public FreightMileageBillEntryInfo get(Object key)
    {
        return(FreightMileageBillEntryInfo)getObject(key);
    }
    public void set(int index, FreightMileageBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreightMileageBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreightMileageBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}