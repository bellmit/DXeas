package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InvestmentPolicyChickenEntryCollection extends AbstractObjectCollection 
{
    public InvestmentPolicyChickenEntryCollection()
    {
        super(InvestmentPolicyChickenEntryInfo.class);
    }
    public boolean add(InvestmentPolicyChickenEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InvestmentPolicyChickenEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InvestmentPolicyChickenEntryInfo item)
    {
        return removeObject(item);
    }
    public InvestmentPolicyChickenEntryInfo get(int index)
    {
        return(InvestmentPolicyChickenEntryInfo)getObject(index);
    }
    public InvestmentPolicyChickenEntryInfo get(Object key)
    {
        return(InvestmentPolicyChickenEntryInfo)getObject(key);
    }
    public void set(int index, InvestmentPolicyChickenEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InvestmentPolicyChickenEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InvestmentPolicyChickenEntryInfo item)
    {
        return super.indexOf(item);
    }
}