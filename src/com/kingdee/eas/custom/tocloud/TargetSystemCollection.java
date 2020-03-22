package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TargetSystemCollection extends AbstractObjectCollection 
{
    public TargetSystemCollection()
    {
        super(TargetSystemInfo.class);
    }
    public boolean add(TargetSystemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TargetSystemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TargetSystemInfo item)
    {
        return removeObject(item);
    }
    public TargetSystemInfo get(int index)
    {
        return(TargetSystemInfo)getObject(index);
    }
    public TargetSystemInfo get(Object key)
    {
        return(TargetSystemInfo)getObject(key);
    }
    public void set(int index, TargetSystemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TargetSystemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TargetSystemInfo item)
    {
        return super.indexOf(item);
    }
}