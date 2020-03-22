package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConFeedContractCollection extends AbstractObjectCollection 
{
    public ConFeedContractCollection()
    {
        super(ConFeedContractInfo.class);
    }
    public boolean add(ConFeedContractInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConFeedContractCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConFeedContractInfo item)
    {
        return removeObject(item);
    }
    public ConFeedContractInfo get(int index)
    {
        return(ConFeedContractInfo)getObject(index);
    }
    public ConFeedContractInfo get(Object key)
    {
        return(ConFeedContractInfo)getObject(key);
    }
    public void set(int index, ConFeedContractInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConFeedContractInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConFeedContractInfo item)
    {
        return super.indexOf(item);
    }
}