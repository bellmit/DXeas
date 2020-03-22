package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class IncubatorTreeCollection extends AbstractObjectCollection 
{
    public IncubatorTreeCollection()
    {
        super(IncubatorTreeInfo.class);
    }
    public boolean add(IncubatorTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(IncubatorTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(IncubatorTreeInfo item)
    {
        return removeObject(item);
    }
    public IncubatorTreeInfo get(int index)
    {
        return(IncubatorTreeInfo)getObject(index);
    }
    public IncubatorTreeInfo get(Object key)
    {
        return(IncubatorTreeInfo)getObject(key);
    }
    public void set(int index, IncubatorTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(IncubatorTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(IncubatorTreeInfo item)
    {
        return super.indexOf(item);
    }
}