package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlePolicyRecycleEntryCollection extends AbstractObjectCollection 
{
    public SettlePolicyRecycleEntryCollection()
    {
        super(SettlePolicyRecycleEntryInfo.class);
    }
    public boolean add(SettlePolicyRecycleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlePolicyRecycleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlePolicyRecycleEntryInfo item)
    {
        return removeObject(item);
    }
    public SettlePolicyRecycleEntryInfo get(int index)
    {
        return(SettlePolicyRecycleEntryInfo)getObject(index);
    }
    public SettlePolicyRecycleEntryInfo get(Object key)
    {
        return(SettlePolicyRecycleEntryInfo)getObject(key);
    }
    public void set(int index, SettlePolicyRecycleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlePolicyRecycleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlePolicyRecycleEntryInfo item)
    {
        return super.indexOf(item);
    }
}