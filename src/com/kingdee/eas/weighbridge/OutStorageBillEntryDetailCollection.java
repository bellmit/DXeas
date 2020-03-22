package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OutStorageBillEntryDetailCollection extends AbstractObjectCollection 
{
    public OutStorageBillEntryDetailCollection()
    {
        super(OutStorageBillEntryDetailInfo.class);
    }
    public boolean add(OutStorageBillEntryDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OutStorageBillEntryDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OutStorageBillEntryDetailInfo item)
    {
        return removeObject(item);
    }
    public OutStorageBillEntryDetailInfo get(int index)
    {
        return(OutStorageBillEntryDetailInfo)getObject(index);
    }
    public OutStorageBillEntryDetailInfo get(Object key)
    {
        return(OutStorageBillEntryDetailInfo)getObject(key);
    }
    public void set(int index, OutStorageBillEntryDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OutStorageBillEntryDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OutStorageBillEntryDetailInfo item)
    {
        return super.indexOf(item);
    }
}