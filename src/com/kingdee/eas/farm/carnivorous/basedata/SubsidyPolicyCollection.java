package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SubsidyPolicyCollection extends AbstractObjectCollection 
{
    public SubsidyPolicyCollection()
    {
        super(SubsidyPolicyInfo.class);
    }
    public boolean add(SubsidyPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SubsidyPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SubsidyPolicyInfo item)
    {
        return removeObject(item);
    }
    public SubsidyPolicyInfo get(int index)
    {
        return(SubsidyPolicyInfo)getObject(index);
    }
    public SubsidyPolicyInfo get(Object key)
    {
        return(SubsidyPolicyInfo)getObject(key);
    }
    public void set(int index, SubsidyPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SubsidyPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SubsidyPolicyInfo item)
    {
        return super.indexOf(item);
    }
}