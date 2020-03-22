package com.kingdee.eas.farm.pig;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PigFarmCollection extends AbstractObjectCollection 
{
    public PigFarmCollection()
    {
        super(PigFarmInfo.class);
    }
    public boolean add(PigFarmInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PigFarmCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PigFarmInfo item)
    {
        return removeObject(item);
    }
    public PigFarmInfo get(int index)
    {
        return(PigFarmInfo)getObject(index);
    }
    public PigFarmInfo get(Object key)
    {
        return(PigFarmInfo)getObject(key);
    }
    public void set(int index, PigFarmInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PigFarmInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PigFarmInfo item)
    {
        return super.indexOf(item);
    }
}