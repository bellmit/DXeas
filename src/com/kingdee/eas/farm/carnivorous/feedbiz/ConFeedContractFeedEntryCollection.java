package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConFeedContractFeedEntryCollection extends AbstractObjectCollection 
{
    public ConFeedContractFeedEntryCollection()
    {
        super(ConFeedContractFeedEntryInfo.class);
    }
    public boolean add(ConFeedContractFeedEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConFeedContractFeedEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConFeedContractFeedEntryInfo item)
    {
        return removeObject(item);
    }
    public ConFeedContractFeedEntryInfo get(int index)
    {
        return(ConFeedContractFeedEntryInfo)getObject(index);
    }
    public ConFeedContractFeedEntryInfo get(Object key)
    {
        return(ConFeedContractFeedEntryInfo)getObject(key);
    }
    public void set(int index, ConFeedContractFeedEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConFeedContractFeedEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConFeedContractFeedEntryInfo item)
    {
        return super.indexOf(item);
    }
}