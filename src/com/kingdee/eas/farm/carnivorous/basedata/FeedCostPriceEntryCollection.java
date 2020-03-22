package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedCostPriceEntryCollection extends AbstractObjectCollection 
{
    public FeedCostPriceEntryCollection()
    {
        super(FeedCostPriceEntryInfo.class);
    }
    public boolean add(FeedCostPriceEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedCostPriceEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedCostPriceEntryInfo item)
    {
        return removeObject(item);
    }
    public FeedCostPriceEntryInfo get(int index)
    {
        return(FeedCostPriceEntryInfo)getObject(index);
    }
    public FeedCostPriceEntryInfo get(Object key)
    {
        return(FeedCostPriceEntryInfo)getObject(key);
    }
    public void set(int index, FeedCostPriceEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedCostPriceEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedCostPriceEntryInfo item)
    {
        return super.indexOf(item);
    }
}