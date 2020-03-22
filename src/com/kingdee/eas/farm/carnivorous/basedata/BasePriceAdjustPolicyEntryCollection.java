package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BasePriceAdjustPolicyEntryCollection extends AbstractObjectCollection 
{
    public BasePriceAdjustPolicyEntryCollection()
    {
        super(BasePriceAdjustPolicyEntryInfo.class);
    }
    public boolean add(BasePriceAdjustPolicyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BasePriceAdjustPolicyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BasePriceAdjustPolicyEntryInfo item)
    {
        return removeObject(item);
    }
    public BasePriceAdjustPolicyEntryInfo get(int index)
    {
        return(BasePriceAdjustPolicyEntryInfo)getObject(index);
    }
    public BasePriceAdjustPolicyEntryInfo get(Object key)
    {
        return(BasePriceAdjustPolicyEntryInfo)getObject(key);
    }
    public void set(int index, BasePriceAdjustPolicyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BasePriceAdjustPolicyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BasePriceAdjustPolicyEntryInfo item)
    {
        return super.indexOf(item);
    }
}