package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OutSourcingEggPriceCollection extends AbstractObjectCollection 
{
    public OutSourcingEggPriceCollection()
    {
        super(OutSourcingEggPriceInfo.class);
    }
    public boolean add(OutSourcingEggPriceInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OutSourcingEggPriceCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OutSourcingEggPriceInfo item)
    {
        return removeObject(item);
    }
    public OutSourcingEggPriceInfo get(int index)
    {
        return(OutSourcingEggPriceInfo)getObject(index);
    }
    public OutSourcingEggPriceInfo get(Object key)
    {
        return(OutSourcingEggPriceInfo)getObject(key);
    }
    public void set(int index, OutSourcingEggPriceInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OutSourcingEggPriceInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OutSourcingEggPriceInfo item)
    {
        return super.indexOf(item);
    }
}