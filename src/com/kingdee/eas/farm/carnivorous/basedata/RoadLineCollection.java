package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RoadLineCollection extends AbstractObjectCollection 
{
    public RoadLineCollection()
    {
        super(RoadLineInfo.class);
    }
    public boolean add(RoadLineInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RoadLineCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RoadLineInfo item)
    {
        return removeObject(item);
    }
    public RoadLineInfo get(int index)
    {
        return(RoadLineInfo)getObject(index);
    }
    public RoadLineInfo get(Object key)
    {
        return(RoadLineInfo)getObject(key);
    }
    public void set(int index, RoadLineInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RoadLineInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RoadLineInfo item)
    {
        return super.indexOf(item);
    }
}