package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConFeedPolicyTreeCollection extends AbstractObjectCollection 
{
    public ConFeedPolicyTreeCollection()
    {
        super(ConFeedPolicyTreeInfo.class);
    }
    public boolean add(ConFeedPolicyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConFeedPolicyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConFeedPolicyTreeInfo item)
    {
        return removeObject(item);
    }
    public ConFeedPolicyTreeInfo get(int index)
    {
        return(ConFeedPolicyTreeInfo)getObject(index);
    }
    public ConFeedPolicyTreeInfo get(Object key)
    {
        return(ConFeedPolicyTreeInfo)getObject(key);
    }
    public void set(int index, ConFeedPolicyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConFeedPolicyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConFeedPolicyTreeInfo item)
    {
        return super.indexOf(item);
    }
}