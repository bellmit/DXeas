package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ImmuneWayCollection extends AbstractObjectCollection 
{
    public ImmuneWayCollection()
    {
        super(ImmuneWayInfo.class);
    }
    public boolean add(ImmuneWayInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ImmuneWayCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ImmuneWayInfo item)
    {
        return removeObject(item);
    }
    public ImmuneWayInfo get(int index)
    {
        return(ImmuneWayInfo)getObject(index);
    }
    public ImmuneWayInfo get(Object key)
    {
        return(ImmuneWayInfo)getObject(key);
    }
    public void set(int index, ImmuneWayInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ImmuneWayInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ImmuneWayInfo item)
    {
        return super.indexOf(item);
    }
}