package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FeedCostPriceCollection extends AbstractObjectCollection 
{
    public FeedCostPriceCollection()
    {
        super(FeedCostPriceInfo.class);
    }
    public boolean add(FeedCostPriceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FeedCostPriceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FeedCostPriceInfo item)
    {
        return removeObject(item);
    }
    public FeedCostPriceInfo get(int index)
    {
        return(FeedCostPriceInfo)getObject(index);
    }
    public FeedCostPriceInfo get(Object key)
    {
        return(FeedCostPriceInfo)getObject(key);
    }
    public void set(int index, FeedCostPriceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FeedCostPriceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FeedCostPriceInfo item)
    {
        return super.indexOf(item);
    }
}