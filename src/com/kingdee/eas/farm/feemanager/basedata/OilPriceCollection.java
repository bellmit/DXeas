package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OilPriceCollection extends AbstractObjectCollection 
{
    public OilPriceCollection()
    {
        super(OilPriceInfo.class);
    }
    public boolean add(OilPriceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OilPriceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OilPriceInfo item)
    {
        return removeObject(item);
    }
    public OilPriceInfo get(int index)
    {
        return(OilPriceInfo)getObject(index);
    }
    public OilPriceInfo get(Object key)
    {
        return(OilPriceInfo)getObject(key);
    }
    public void set(int index, OilPriceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OilPriceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OilPriceInfo item)
    {
        return super.indexOf(item);
    }
}