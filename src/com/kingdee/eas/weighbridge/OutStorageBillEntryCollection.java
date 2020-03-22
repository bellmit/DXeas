package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OutStorageBillEntryCollection extends AbstractObjectCollection 
{
    public OutStorageBillEntryCollection()
    {
        super(OutStorageBillEntryInfo.class);
    }
    public boolean add(OutStorageBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OutStorageBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OutStorageBillEntryInfo item)
    {
        return removeObject(item);
    }
    public OutStorageBillEntryInfo get(int index)
    {
        return(OutStorageBillEntryInfo)getObject(index);
    }
    public OutStorageBillEntryInfo get(Object key)
    {
        return(OutStorageBillEntryInfo)getObject(key);
    }
    public void set(int index, OutStorageBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OutStorageBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OutStorageBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}