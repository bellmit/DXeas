package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LongTimeArAmountCollection extends AbstractObjectCollection 
{
    public LongTimeArAmountCollection()
    {
        super(LongTimeArAmountInfo.class);
    }
    public boolean add(LongTimeArAmountInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LongTimeArAmountCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LongTimeArAmountInfo item)
    {
        return removeObject(item);
    }
    public LongTimeArAmountInfo get(int index)
    {
        return(LongTimeArAmountInfo)getObject(index);
    }
    public LongTimeArAmountInfo get(Object key)
    {
        return(LongTimeArAmountInfo)getObject(key);
    }
    public void set(int index, LongTimeArAmountInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LongTimeArAmountInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LongTimeArAmountInfo item)
    {
        return super.indexOf(item);
    }
}