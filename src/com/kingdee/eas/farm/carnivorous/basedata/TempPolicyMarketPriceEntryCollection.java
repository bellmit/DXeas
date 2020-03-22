package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TempPolicyMarketPriceEntryCollection extends AbstractObjectCollection 
{
    public TempPolicyMarketPriceEntryCollection()
    {
        super(TempPolicyMarketPriceEntryInfo.class);
    }
    public boolean add(TempPolicyMarketPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TempPolicyMarketPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TempPolicyMarketPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public TempPolicyMarketPriceEntryInfo get(int index)
    {
        return(TempPolicyMarketPriceEntryInfo)getObject(index);
    }
    public TempPolicyMarketPriceEntryInfo get(Object key)
    {
        return(TempPolicyMarketPriceEntryInfo)getObject(key);
    }
    public void set(int index, TempPolicyMarketPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TempPolicyMarketPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TempPolicyMarketPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}