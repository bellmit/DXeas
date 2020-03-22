package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InvestmentPolicyChickenCollection extends AbstractObjectCollection 
{
    public InvestmentPolicyChickenCollection()
    {
        super(InvestmentPolicyChickenInfo.class);
    }
    public boolean add(InvestmentPolicyChickenInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InvestmentPolicyChickenCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InvestmentPolicyChickenInfo item)
    {
        return removeObject(item);
    }
    public InvestmentPolicyChickenInfo get(int index)
    {
        return(InvestmentPolicyChickenInfo)getObject(index);
    }
    public InvestmentPolicyChickenInfo get(Object key)
    {
        return(InvestmentPolicyChickenInfo)getObject(key);
    }
    public void set(int index, InvestmentPolicyChickenInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InvestmentPolicyChickenInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InvestmentPolicyChickenInfo item)
    {
        return super.indexOf(item);
    }
}