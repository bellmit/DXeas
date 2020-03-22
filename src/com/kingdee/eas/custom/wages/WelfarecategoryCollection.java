package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WelfarecategoryCollection extends AbstractObjectCollection 
{
    public WelfarecategoryCollection()
    {
        super(WelfarecategoryInfo.class);
    }
    public boolean add(WelfarecategoryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WelfarecategoryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WelfarecategoryInfo item)
    {
        return removeObject(item);
    }
    public WelfarecategoryInfo get(int index)
    {
        return(WelfarecategoryInfo)getObject(index);
    }
    public WelfarecategoryInfo get(Object key)
    {
        return(WelfarecategoryInfo)getObject(key);
    }
    public void set(int index, WelfarecategoryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WelfarecategoryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WelfarecategoryInfo item)
    {
        return super.indexOf(item);
    }
}