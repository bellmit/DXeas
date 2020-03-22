package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OtherStorageBillEntryDetailCollection extends AbstractObjectCollection 
{
    public OtherStorageBillEntryDetailCollection()
    {
        super(OtherStorageBillEntryDetailInfo.class);
    }
    public boolean add(OtherStorageBillEntryDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OtherStorageBillEntryDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OtherStorageBillEntryDetailInfo item)
    {
        return removeObject(item);
    }
    public OtherStorageBillEntryDetailInfo get(int index)
    {
        return(OtherStorageBillEntryDetailInfo)getObject(index);
    }
    public OtherStorageBillEntryDetailInfo get(Object key)
    {
        return(OtherStorageBillEntryDetailInfo)getObject(key);
    }
    public void set(int index, OtherStorageBillEntryDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OtherStorageBillEntryDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OtherStorageBillEntryDetailInfo item)
    {
        return super.indexOf(item);
    }
}