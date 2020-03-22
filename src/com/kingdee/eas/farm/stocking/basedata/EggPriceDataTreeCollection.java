package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggPriceDataTreeCollection extends AbstractObjectCollection 
{
    public EggPriceDataTreeCollection()
    {
        super(EggPriceDataTreeInfo.class);
    }
    public boolean add(EggPriceDataTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggPriceDataTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggPriceDataTreeInfo item)
    {
        return removeObject(item);
    }
    public EggPriceDataTreeInfo get(int index)
    {
        return(EggPriceDataTreeInfo)getObject(index);
    }
    public EggPriceDataTreeInfo get(Object key)
    {
        return(EggPriceDataTreeInfo)getObject(key);
    }
    public void set(int index, EggPriceDataTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggPriceDataTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggPriceDataTreeInfo item)
    {
        return super.indexOf(item);
    }
}