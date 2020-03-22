package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InvestmentPolicyEntryCollection extends AbstractObjectCollection 
{
    public InvestmentPolicyEntryCollection()
    {
        super(InvestmentPolicyEntryInfo.class);
    }
    public boolean add(InvestmentPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InvestmentPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InvestmentPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public InvestmentPolicyEntryInfo get(int index)
    {
        return(InvestmentPolicyEntryInfo)getObject(index);
    }
    public InvestmentPolicyEntryInfo get(Object key)
    {
        return(InvestmentPolicyEntryInfo)getObject(key);
    }
    public void set(int index, InvestmentPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InvestmentPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InvestmentPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}