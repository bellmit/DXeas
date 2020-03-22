package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarketPolicyCollection extends AbstractObjectCollection 
{
    public MarketPolicyCollection()
    {
        super(MarketPolicyInfo.class);
    }
    public boolean add(MarketPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarketPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarketPolicyInfo item)
    {
        return removeObject(item);
    }
    public MarketPolicyInfo get(int index)
    {
        return(MarketPolicyInfo)getObject(index);
    }
    public MarketPolicyInfo get(Object key)
    {
        return(MarketPolicyInfo)getObject(key);
    }
    public void set(int index, MarketPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarketPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarketPolicyInfo item)
    {
        return super.indexOf(item);
    }
}