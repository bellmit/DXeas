package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LifeFeeCollection extends AbstractObjectCollection 
{
    public LifeFeeCollection()
    {
        super(LifeFeeInfo.class);
    }
    public boolean add(LifeFeeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LifeFeeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LifeFeeInfo item)
    {
        return removeObject(item);
    }
    public LifeFeeInfo get(int index)
    {
        return(LifeFeeInfo)getObject(index);
    }
    public LifeFeeInfo get(Object key)
    {
        return(LifeFeeInfo)getObject(key);
    }
    public void set(int index, LifeFeeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LifeFeeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LifeFeeInfo item)
    {
        return super.indexOf(item);
    }
}