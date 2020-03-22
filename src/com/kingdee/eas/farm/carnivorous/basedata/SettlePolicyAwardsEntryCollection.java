package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlePolicyAwardsEntryCollection extends AbstractObjectCollection 
{
    public SettlePolicyAwardsEntryCollection()
    {
        super(SettlePolicyAwardsEntryInfo.class);
    }
    public boolean add(SettlePolicyAwardsEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlePolicyAwardsEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlePolicyAwardsEntryInfo item)
    {
        return removeObject(item);
    }
    public SettlePolicyAwardsEntryInfo get(int index)
    {
        return(SettlePolicyAwardsEntryInfo)getObject(index);
    }
    public SettlePolicyAwardsEntryInfo get(Object key)
    {
        return(SettlePolicyAwardsEntryInfo)getObject(key);
    }
    public void set(int index, SettlePolicyAwardsEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlePolicyAwardsEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlePolicyAwardsEntryInfo item)
    {
        return super.indexOf(item);
    }
}