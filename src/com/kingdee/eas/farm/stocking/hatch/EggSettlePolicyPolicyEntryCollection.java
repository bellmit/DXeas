package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggSettlePolicyPolicyEntryCollection extends AbstractObjectCollection 
{
    public EggSettlePolicyPolicyEntryCollection()
    {
        super(EggSettlePolicyPolicyEntryInfo.class);
    }
    public boolean add(EggSettlePolicyPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggSettlePolicyPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggSettlePolicyPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public EggSettlePolicyPolicyEntryInfo get(int index)
    {
        return(EggSettlePolicyPolicyEntryInfo)getObject(index);
    }
    public EggSettlePolicyPolicyEntryInfo get(Object key)
    {
        return(EggSettlePolicyPolicyEntryInfo)getObject(key);
    }
    public void set(int index, EggSettlePolicyPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggSettlePolicyPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggSettlePolicyPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}