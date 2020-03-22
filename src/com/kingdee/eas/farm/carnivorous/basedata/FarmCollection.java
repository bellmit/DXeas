package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmCollection extends AbstractObjectCollection 
{
    public FarmCollection()
    {
        super(FarmInfo.class);
    }
    public boolean add(FarmInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmInfo item)
    {
        return removeObject(item);
    }
    public FarmInfo get(int index)
    {
        return(FarmInfo)getObject(index);
    }
    public FarmInfo get(Object key)
    {
        return(FarmInfo)getObject(key);
    }
    public void set(int index, FarmInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmInfo item)
    {
        return super.indexOf(item);
    }
}