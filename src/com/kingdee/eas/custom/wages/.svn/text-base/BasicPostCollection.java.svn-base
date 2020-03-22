package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BasicPostCollection extends AbstractObjectCollection 
{
    public BasicPostCollection()
    {
        super(BasicPostInfo.class);
    }
    public boolean add(BasicPostInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BasicPostCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BasicPostInfo item)
    {
        return removeObject(item);
    }
    public BasicPostInfo get(int index)
    {
        return(BasicPostInfo)getObject(index);
    }
    public BasicPostInfo get(Object key)
    {
        return(BasicPostInfo)getObject(key);
    }
    public void set(int index, BasicPostInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BasicPostInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BasicPostInfo item)
    {
        return super.indexOf(item);
    }
}