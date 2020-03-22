package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InsteadSeedPriceDataRangeCollection extends AbstractObjectCollection 
{
    public InsteadSeedPriceDataRangeCollection()
    {
        super(InsteadSeedPriceDataRangeInfo.class);
    }
    public boolean add(InsteadSeedPriceDataRangeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InsteadSeedPriceDataRangeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InsteadSeedPriceDataRangeInfo item)
    {
        return removeObject(item);
    }
    public InsteadSeedPriceDataRangeInfo get(int index)
    {
        return(InsteadSeedPriceDataRangeInfo)getObject(index);
    }
    public InsteadSeedPriceDataRangeInfo get(Object key)
    {
        return(InsteadSeedPriceDataRangeInfo)getObject(key);
    }
    public void set(int index, InsteadSeedPriceDataRangeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InsteadSeedPriceDataRangeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InsteadSeedPriceDataRangeInfo item)
    {
        return super.indexOf(item);
    }
}