package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InvestmentPolicyCollection extends AbstractObjectCollection 
{
    public InvestmentPolicyCollection()
    {
        super(InvestmentPolicyInfo.class);
    }
    public boolean add(InvestmentPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InvestmentPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InvestmentPolicyInfo item)
    {
        return removeObject(item);
    }
    public InvestmentPolicyInfo get(int index)
    {
        return(InvestmentPolicyInfo)getObject(index);
    }
    public InvestmentPolicyInfo get(Object key)
    {
        return(InvestmentPolicyInfo)getObject(key);
    }
    public void set(int index, InvestmentPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InvestmentPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InvestmentPolicyInfo item)
    {
        return super.indexOf(item);
    }
}