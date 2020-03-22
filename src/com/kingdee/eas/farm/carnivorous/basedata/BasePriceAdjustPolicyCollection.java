package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BasePriceAdjustPolicyCollection extends AbstractObjectCollection 
{
    public BasePriceAdjustPolicyCollection()
    {
        super(BasePriceAdjustPolicyInfo.class);
    }
    public boolean add(BasePriceAdjustPolicyInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BasePriceAdjustPolicyCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BasePriceAdjustPolicyInfo item)
    {
        return removeObject(item);
    }
    public BasePriceAdjustPolicyInfo get(int index)
    {
        return(BasePriceAdjustPolicyInfo)getObject(index);
    }
    public BasePriceAdjustPolicyInfo get(Object key)
    {
        return(BasePriceAdjustPolicyInfo)getObject(key);
    }
    public void set(int index, BasePriceAdjustPolicyInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BasePriceAdjustPolicyInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BasePriceAdjustPolicyInfo item)
    {
        return super.indexOf(item);
    }
}