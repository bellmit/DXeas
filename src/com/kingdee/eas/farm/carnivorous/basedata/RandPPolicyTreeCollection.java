package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RandPPolicyTreeCollection extends AbstractObjectCollection 
{
    public RandPPolicyTreeCollection()
    {
        super(RandPPolicyTreeInfo.class);
    }
    public boolean add(RandPPolicyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RandPPolicyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RandPPolicyTreeInfo item)
    {
        return removeObject(item);
    }
    public RandPPolicyTreeInfo get(int index)
    {
        return(RandPPolicyTreeInfo)getObject(index);
    }
    public RandPPolicyTreeInfo get(Object key)
    {
        return(RandPPolicyTreeInfo)getObject(key);
    }
    public void set(int index, RandPPolicyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RandPPolicyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RandPPolicyTreeInfo item)
    {
        return super.indexOf(item);
    }
}