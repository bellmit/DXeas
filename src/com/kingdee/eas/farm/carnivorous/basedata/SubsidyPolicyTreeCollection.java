package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SubsidyPolicyTreeCollection extends AbstractObjectCollection 
{
    public SubsidyPolicyTreeCollection()
    {
        super(SubsidyPolicyTreeInfo.class);
    }
    public boolean add(SubsidyPolicyTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SubsidyPolicyTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SubsidyPolicyTreeInfo item)
    {
        return removeObject(item);
    }
    public SubsidyPolicyTreeInfo get(int index)
    {
        return(SubsidyPolicyTreeInfo)getObject(index);
    }
    public SubsidyPolicyTreeInfo get(Object key)
    {
        return(SubsidyPolicyTreeInfo)getObject(key);
    }
    public void set(int index, SubsidyPolicyTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SubsidyPolicyTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SubsidyPolicyTreeInfo item)
    {
        return super.indexOf(item);
    }
}