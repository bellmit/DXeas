package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProcesstechCollection extends AbstractObjectCollection 
{
    public ProcesstechCollection()
    {
        super(ProcesstechInfo.class);
    }
    public boolean add(ProcesstechInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProcesstechCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProcesstechInfo item)
    {
        return removeObject(item);
    }
    public ProcesstechInfo get(int index)
    {
        return(ProcesstechInfo)getObject(index);
    }
    public ProcesstechInfo get(Object key)
    {
        return(ProcesstechInfo)getObject(key);
    }
    public void set(int index, ProcesstechInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProcesstechInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProcesstechInfo item)
    {
        return super.indexOf(item);
    }
}