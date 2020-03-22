package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlePolicySubsidyEntryCollection extends AbstractObjectCollection 
{
    public SettlePolicySubsidyEntryCollection()
    {
        super(SettlePolicySubsidyEntryInfo.class);
    }
    public boolean add(SettlePolicySubsidyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlePolicySubsidyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlePolicySubsidyEntryInfo item)
    {
        return removeObject(item);
    }
    public SettlePolicySubsidyEntryInfo get(int index)
    {
        return(SettlePolicySubsidyEntryInfo)getObject(index);
    }
    public SettlePolicySubsidyEntryInfo get(Object key)
    {
        return(SettlePolicySubsidyEntryInfo)getObject(key);
    }
    public void set(int index, SettlePolicySubsidyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlePolicySubsidyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlePolicySubsidyEntryInfo item)
    {
        return super.indexOf(item);
    }
}