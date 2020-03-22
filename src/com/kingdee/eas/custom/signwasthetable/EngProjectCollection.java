package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EngProjectCollection extends AbstractObjectCollection 
{
    public EngProjectCollection()
    {
        super(EngProjectInfo.class);
    }
    public boolean add(EngProjectInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EngProjectCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EngProjectInfo item)
    {
        return removeObject(item);
    }
    public EngProjectInfo get(int index)
    {
        return(EngProjectInfo)getObject(index);
    }
    public EngProjectInfo get(Object key)
    {
        return(EngProjectInfo)getObject(key);
    }
    public void set(int index, EngProjectInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EngProjectInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EngProjectInfo item)
    {
        return super.indexOf(item);
    }
}