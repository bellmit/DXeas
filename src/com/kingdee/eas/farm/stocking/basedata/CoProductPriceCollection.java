package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CoProductPriceCollection extends AbstractObjectCollection 
{
    public CoProductPriceCollection()
    {
        super(CoProductPriceInfo.class);
    }
    public boolean add(CoProductPriceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CoProductPriceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CoProductPriceInfo item)
    {
        return removeObject(item);
    }
    public CoProductPriceInfo get(int index)
    {
        return(CoProductPriceInfo)getObject(index);
    }
    public CoProductPriceInfo get(Object key)
    {
        return(CoProductPriceInfo)getObject(key);
    }
    public void set(int index, CoProductPriceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CoProductPriceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CoProductPriceInfo item)
    {
        return super.indexOf(item);
    }
}