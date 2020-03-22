package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InsteadSeedPriceDataPriceEntryCollection extends AbstractObjectCollection 
{
    public InsteadSeedPriceDataPriceEntryCollection()
    {
        super(InsteadSeedPriceDataPriceEntryInfo.class);
    }
    public boolean add(InsteadSeedPriceDataPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InsteadSeedPriceDataPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InsteadSeedPriceDataPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public InsteadSeedPriceDataPriceEntryInfo get(int index)
    {
        return(InsteadSeedPriceDataPriceEntryInfo)getObject(index);
    }
    public InsteadSeedPriceDataPriceEntryInfo get(Object key)
    {
        return(InsteadSeedPriceDataPriceEntryInfo)getObject(key);
    }
    public void set(int index, InsteadSeedPriceDataPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InsteadSeedPriceDataPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InsteadSeedPriceDataPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}