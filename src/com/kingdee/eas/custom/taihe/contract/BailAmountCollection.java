package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BailAmountCollection extends AbstractObjectCollection 
{
    public BailAmountCollection()
    {
        super(BailAmountInfo.class);
    }
    public boolean add(BailAmountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BailAmountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BailAmountInfo item)
    {
        return removeObject(item);
    }
    public BailAmountInfo get(int index)
    {
        return(BailAmountInfo)getObject(index);
    }
    public BailAmountInfo get(Object key)
    {
        return(BailAmountInfo)getObject(key);
    }
    public void set(int index, BailAmountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BailAmountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BailAmountInfo item)
    {
        return super.indexOf(item);
    }
}