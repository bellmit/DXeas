package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FreightMileageBillCollection extends AbstractObjectCollection 
{
    public FreightMileageBillCollection()
    {
        super(FreightMileageBillInfo.class);
    }
    public boolean add(FreightMileageBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FreightMileageBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FreightMileageBillInfo item)
    {
        return removeObject(item);
    }
    public FreightMileageBillInfo get(int index)
    {
        return(FreightMileageBillInfo)getObject(index);
    }
    public FreightMileageBillInfo get(Object key)
    {
        return(FreightMileageBillInfo)getObject(key);
    }
    public void set(int index, FreightMileageBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FreightMileageBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FreightMileageBillInfo item)
    {
        return super.indexOf(item);
    }
}