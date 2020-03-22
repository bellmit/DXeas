package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SecondAllotCollection extends AbstractObjectCollection 
{
    public SecondAllotCollection()
    {
        super(SecondAllotInfo.class);
    }
    public boolean add(SecondAllotInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SecondAllotCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SecondAllotInfo item)
    {
        return removeObject(item);
    }
    public SecondAllotInfo get(int index)
    {
        return(SecondAllotInfo)getObject(index);
    }
    public SecondAllotInfo get(Object key)
    {
        return(SecondAllotInfo)getObject(key);
    }
    public void set(int index, SecondAllotInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SecondAllotInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SecondAllotInfo item)
    {
        return super.indexOf(item);
    }
}