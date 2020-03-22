package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmersCollection extends AbstractObjectCollection 
{
    public FarmersCollection()
    {
        super(FarmersInfo.class);
    }
    public boolean add(FarmersInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmersCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmersInfo item)
    {
        return removeObject(item);
    }
    public FarmersInfo get(int index)
    {
        return(FarmersInfo)getObject(index);
    }
    public FarmersInfo get(Object key)
    {
        return(FarmersInfo)getObject(key);
    }
    public void set(int index, FarmersInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmersInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmersInfo item)
    {
        return super.indexOf(item);
    }
}