package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlePolicyPriceEntryCollection extends AbstractObjectCollection 
{
    public SettlePolicyPriceEntryCollection()
    {
        super(SettlePolicyPriceEntryInfo.class);
    }
    public boolean add(SettlePolicyPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlePolicyPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlePolicyPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public SettlePolicyPriceEntryInfo get(int index)
    {
        return(SettlePolicyPriceEntryInfo)getObject(index);
    }
    public SettlePolicyPriceEntryInfo get(Object key)
    {
        return(SettlePolicyPriceEntryInfo)getObject(key);
    }
    public void set(int index, SettlePolicyPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlePolicyPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlePolicyPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}