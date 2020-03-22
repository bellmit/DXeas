package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RandPPolicyPolicyEntryCollection extends AbstractObjectCollection 
{
    public RandPPolicyPolicyEntryCollection()
    {
        super(RandPPolicyPolicyEntryInfo.class);
    }
    public boolean add(RandPPolicyPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RandPPolicyPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RandPPolicyPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public RandPPolicyPolicyEntryInfo get(int index)
    {
        return(RandPPolicyPolicyEntryInfo)getObject(index);
    }
    public RandPPolicyPolicyEntryInfo get(Object key)
    {
        return(RandPPolicyPolicyEntryInfo)getObject(key);
    }
    public void set(int index, RandPPolicyPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RandPPolicyPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RandPPolicyPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}