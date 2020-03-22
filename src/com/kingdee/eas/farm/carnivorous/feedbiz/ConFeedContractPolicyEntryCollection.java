package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConFeedContractPolicyEntryCollection extends AbstractObjectCollection 
{
    public ConFeedContractPolicyEntryCollection()
    {
        super(ConFeedContractPolicyEntryInfo.class);
    }
    public boolean add(ConFeedContractPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConFeedContractPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConFeedContractPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public ConFeedContractPolicyEntryInfo get(int index)
    {
        return(ConFeedContractPolicyEntryInfo)getObject(index);
    }
    public ConFeedContractPolicyEntryInfo get(Object key)
    {
        return(ConFeedContractPolicyEntryInfo)getObject(key);
    }
    public void set(int index, ConFeedContractPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConFeedContractPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConFeedContractPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}