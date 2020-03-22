package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginPolicyCollection extends AbstractObjectCollection 
{
    public MarginPolicyCollection()
    {
        super(MarginPolicyInfo.class);
    }
    public boolean add(MarginPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginPolicyInfo item)
    {
        return removeObject(item);
    }
    public MarginPolicyInfo get(int index)
    {
        return(MarginPolicyInfo)getObject(index);
    }
    public MarginPolicyInfo get(Object key)
    {
        return(MarginPolicyInfo)getObject(key);
    }
    public void set(int index, MarginPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginPolicyInfo item)
    {
        return super.indexOf(item);
    }
}