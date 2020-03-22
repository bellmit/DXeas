package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RandPPolicyCollection extends AbstractObjectCollection 
{
    public RandPPolicyCollection()
    {
        super(RandPPolicyInfo.class);
    }
    public boolean add(RandPPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RandPPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RandPPolicyInfo item)
    {
        return removeObject(item);
    }
    public RandPPolicyInfo get(int index)
    {
        return(RandPPolicyInfo)getObject(index);
    }
    public RandPPolicyInfo get(Object key)
    {
        return(RandPPolicyInfo)getObject(key);
    }
    public void set(int index, RandPPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RandPPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RandPPolicyInfo item)
    {
        return super.indexOf(item);
    }
}