package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConFeedPolicyCollection extends AbstractObjectCollection 
{
    public ConFeedPolicyCollection()
    {
        super(ConFeedPolicyInfo.class);
    }
    public boolean add(ConFeedPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConFeedPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConFeedPolicyInfo item)
    {
        return removeObject(item);
    }
    public ConFeedPolicyInfo get(int index)
    {
        return(ConFeedPolicyInfo)getObject(index);
    }
    public ConFeedPolicyInfo get(Object key)
    {
        return(ConFeedPolicyInfo)getObject(key);
    }
    public void set(int index, ConFeedPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConFeedPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConFeedPolicyInfo item)
    {
        return super.indexOf(item);
    }
}