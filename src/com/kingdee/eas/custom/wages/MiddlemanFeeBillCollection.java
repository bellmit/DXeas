package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MiddlemanFeeBillCollection extends AbstractObjectCollection 
{
    public MiddlemanFeeBillCollection()
    {
        super(MiddlemanFeeBillInfo.class);
    }
    public boolean add(MiddlemanFeeBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MiddlemanFeeBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MiddlemanFeeBillInfo item)
    {
        return removeObject(item);
    }
    public MiddlemanFeeBillInfo get(int index)
    {
        return(MiddlemanFeeBillInfo)getObject(index);
    }
    public MiddlemanFeeBillInfo get(Object key)
    {
        return(MiddlemanFeeBillInfo)getObject(key);
    }
    public void set(int index, MiddlemanFeeBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MiddlemanFeeBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MiddlemanFeeBillInfo item)
    {
        return super.indexOf(item);
    }
}