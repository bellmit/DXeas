package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OtherGroupSetCollection extends AbstractObjectCollection 
{
    public OtherGroupSetCollection()
    {
        super(OtherGroupSetInfo.class);
    }
    public boolean add(OtherGroupSetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OtherGroupSetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OtherGroupSetInfo item)
    {
        return removeObject(item);
    }
    public OtherGroupSetInfo get(int index)
    {
        return(OtherGroupSetInfo)getObject(index);
    }
    public OtherGroupSetInfo get(Object key)
    {
        return(OtherGroupSetInfo)getObject(key);
    }
    public void set(int index, OtherGroupSetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OtherGroupSetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OtherGroupSetInfo item)
    {
        return super.indexOf(item);
    }
}