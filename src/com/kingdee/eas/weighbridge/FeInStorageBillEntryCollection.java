package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeInStorageBillEntryCollection extends AbstractObjectCollection 
{
    public FeInStorageBillEntryCollection()
    {
        super(FeInStorageBillEntryInfo.class);
    }
    public boolean add(FeInStorageBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeInStorageBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeInStorageBillEntryInfo item)
    {
        return removeObject(item);
    }
    public FeInStorageBillEntryInfo get(int index)
    {
        return(FeInStorageBillEntryInfo)getObject(index);
    }
    public FeInStorageBillEntryInfo get(Object key)
    {
        return(FeInStorageBillEntryInfo)getObject(key);
    }
    public void set(int index, FeInStorageBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeInStorageBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeInStorageBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}