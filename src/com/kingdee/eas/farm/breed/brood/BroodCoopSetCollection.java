package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BroodCoopSetCollection extends AbstractObjectCollection 
{
    public BroodCoopSetCollection()
    {
        super(BroodCoopSetInfo.class);
    }
    public boolean add(BroodCoopSetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BroodCoopSetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BroodCoopSetInfo item)
    {
        return removeObject(item);
    }
    public BroodCoopSetInfo get(int index)
    {
        return(BroodCoopSetInfo)getObject(index);
    }
    public BroodCoopSetInfo get(Object key)
    {
        return(BroodCoopSetInfo)getObject(key);
    }
    public void set(int index, BroodCoopSetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BroodCoopSetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BroodCoopSetInfo item)
    {
        return super.indexOf(item);
    }
}