package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MarginGetPolicyCollection extends AbstractObjectCollection 
{
    public MarginGetPolicyCollection()
    {
        super(MarginGetPolicyInfo.class);
    }
    public boolean add(MarginGetPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MarginGetPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MarginGetPolicyInfo item)
    {
        return removeObject(item);
    }
    public MarginGetPolicyInfo get(int index)
    {
        return(MarginGetPolicyInfo)getObject(index);
    }
    public MarginGetPolicyInfo get(Object key)
    {
        return(MarginGetPolicyInfo)getObject(key);
    }
    public void set(int index, MarginGetPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MarginGetPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MarginGetPolicyInfo item)
    {
        return super.indexOf(item);
    }
}