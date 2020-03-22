package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DriverTreeCollection extends AbstractObjectCollection 
{
    public DriverTreeCollection()
    {
        super(DriverTreeInfo.class);
    }
    public boolean add(DriverTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DriverTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DriverTreeInfo item)
    {
        return removeObject(item);
    }
    public DriverTreeInfo get(int index)
    {
        return(DriverTreeInfo)getObject(index);
    }
    public DriverTreeInfo get(Object key)
    {
        return(DriverTreeInfo)getObject(key);
    }
    public void set(int index, DriverTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DriverTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DriverTreeInfo item)
    {
        return super.indexOf(item);
    }
}