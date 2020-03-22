package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BasicPostFarmCollection extends AbstractObjectCollection 
{
    public BasicPostFarmCollection()
    {
        super(BasicPostFarmInfo.class);
    }
    public boolean add(BasicPostFarmInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BasicPostFarmCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BasicPostFarmInfo item)
    {
        return removeObject(item);
    }
    public BasicPostFarmInfo get(int index)
    {
        return(BasicPostFarmInfo)getObject(index);
    }
    public BasicPostFarmInfo get(Object key)
    {
        return(BasicPostFarmInfo)getObject(key);
    }
    public void set(int index, BasicPostFarmInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BasicPostFarmInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BasicPostFarmInfo item)
    {
        return super.indexOf(item);
    }
}