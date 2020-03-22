package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InsteadSeedPriceDataCollection extends AbstractObjectCollection 
{
    public InsteadSeedPriceDataCollection()
    {
        super(InsteadSeedPriceDataInfo.class);
    }
    public boolean add(InsteadSeedPriceDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InsteadSeedPriceDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InsteadSeedPriceDataInfo item)
    {
        return removeObject(item);
    }
    public InsteadSeedPriceDataInfo get(int index)
    {
        return(InsteadSeedPriceDataInfo)getObject(index);
    }
    public InsteadSeedPriceDataInfo get(Object key)
    {
        return(InsteadSeedPriceDataInfo)getObject(key);
    }
    public void set(int index, InsteadSeedPriceDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InsteadSeedPriceDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InsteadSeedPriceDataInfo item)
    {
        return super.indexOf(item);
    }
}