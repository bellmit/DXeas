package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SellSeedlingSettlePolicyCollection extends AbstractObjectCollection 
{
    public SellSeedlingSettlePolicyCollection()
    {
        super(SellSeedlingSettlePolicyInfo.class);
    }
    public boolean add(SellSeedlingSettlePolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SellSeedlingSettlePolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SellSeedlingSettlePolicyInfo item)
    {
        return removeObject(item);
    }
    public SellSeedlingSettlePolicyInfo get(int index)
    {
        return(SellSeedlingSettlePolicyInfo)getObject(index);
    }
    public SellSeedlingSettlePolicyInfo get(Object key)
    {
        return(SellSeedlingSettlePolicyInfo)getObject(key);
    }
    public void set(int index, SellSeedlingSettlePolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SellSeedlingSettlePolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SellSeedlingSettlePolicyInfo item)
    {
        return super.indexOf(item);
    }
}