package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class IncubatorCollection extends AbstractObjectCollection 
{
    public IncubatorCollection()
    {
        super(IncubatorInfo.class);
    }
    public boolean add(IncubatorInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(IncubatorCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(IncubatorInfo item)
    {
        return removeObject(item);
    }
    public IncubatorInfo get(int index)
    {
        return(IncubatorInfo)getObject(index);
    }
    public IncubatorInfo get(Object key)
    {
        return(IncubatorInfo)getObject(key);
    }
    public void set(int index, IncubatorInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(IncubatorInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(IncubatorInfo item)
    {
        return super.indexOf(item);
    }
}