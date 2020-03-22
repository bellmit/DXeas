package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeInStorageBillEntryDetailCollection extends AbstractObjectCollection 
{
    public FeInStorageBillEntryDetailCollection()
    {
        super(FeInStorageBillEntryDetailInfo.class);
    }
    public boolean add(FeInStorageBillEntryDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeInStorageBillEntryDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeInStorageBillEntryDetailInfo item)
    {
        return removeObject(item);
    }
    public FeInStorageBillEntryDetailInfo get(int index)
    {
        return(FeInStorageBillEntryDetailInfo)getObject(index);
    }
    public FeInStorageBillEntryDetailInfo get(Object key)
    {
        return(FeInStorageBillEntryDetailInfo)getObject(key);
    }
    public void set(int index, FeInStorageBillEntryDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeInStorageBillEntryDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeInStorageBillEntryDetailInfo item)
    {
        return super.indexOf(item);
    }
}