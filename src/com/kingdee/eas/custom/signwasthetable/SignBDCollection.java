package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SignBDCollection extends AbstractObjectCollection 
{
    public SignBDCollection()
    {
        super(SignBDInfo.class);
    }
    public boolean add(SignBDInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SignBDCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SignBDInfo item)
    {
        return removeObject(item);
    }
    public SignBDInfo get(int index)
    {
        return(SignBDInfo)getObject(index);
    }
    public SignBDInfo get(Object key)
    {
        return(SignBDInfo)getObject(key);
    }
    public void set(int index, SignBDInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SignBDInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SignBDInfo item)
    {
        return super.indexOf(item);
    }
}