package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlePolicyCollection extends AbstractObjectCollection 
{
    public SettlePolicyCollection()
    {
        super(SettlePolicyInfo.class);
    }
    public boolean add(SettlePolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlePolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlePolicyInfo item)
    {
        return removeObject(item);
    }
    public SettlePolicyInfo get(int index)
    {
        return(SettlePolicyInfo)getObject(index);
    }
    public SettlePolicyInfo get(Object key)
    {
        return(SettlePolicyInfo)getObject(key);
    }
    public void set(int index, SettlePolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlePolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlePolicyInfo item)
    {
        return super.indexOf(item);
    }
}