package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggPriceDataCollection extends AbstractObjectCollection 
{
    public EggPriceDataCollection()
    {
        super(EggPriceDataInfo.class);
    }
    public boolean add(EggPriceDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggPriceDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggPriceDataInfo item)
    {
        return removeObject(item);
    }
    public EggPriceDataInfo get(int index)
    {
        return(EggPriceDataInfo)getObject(index);
    }
    public EggPriceDataInfo get(Object key)
    {
        return(EggPriceDataInfo)getObject(key);
    }
    public void set(int index, EggPriceDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggPriceDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggPriceDataInfo item)
    {
        return super.indexOf(item);
    }
}