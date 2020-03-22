package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OutStorageBillCollection extends AbstractObjectCollection 
{
    public OutStorageBillCollection()
    {
        super(OutStorageBillInfo.class);
    }
    public boolean add(OutStorageBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OutStorageBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OutStorageBillInfo item)
    {
        return removeObject(item);
    }
    public OutStorageBillInfo get(int index)
    {
        return(OutStorageBillInfo)getObject(index);
    }
    public OutStorageBillInfo get(Object key)
    {
        return(OutStorageBillInfo)getObject(key);
    }
    public void set(int index, OutStorageBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OutStorageBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OutStorageBillInfo item)
    {
        return super.indexOf(item);
    }
}