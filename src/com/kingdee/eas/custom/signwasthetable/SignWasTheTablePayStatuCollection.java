package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SignWasTheTablePayStatuCollection extends AbstractObjectCollection 
{
    public SignWasTheTablePayStatuCollection()
    {
        super(SignWasTheTablePayStatuInfo.class);
    }
    public boolean add(SignWasTheTablePayStatuInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SignWasTheTablePayStatuCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SignWasTheTablePayStatuInfo item)
    {
        return removeObject(item);
    }
    public SignWasTheTablePayStatuInfo get(int index)
    {
        return(SignWasTheTablePayStatuInfo)getObject(index);
    }
    public SignWasTheTablePayStatuInfo get(Object key)
    {
        return(SignWasTheTablePayStatuInfo)getObject(key);
    }
    public void set(int index, SignWasTheTablePayStatuInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SignWasTheTablePayStatuInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SignWasTheTablePayStatuInfo item)
    {
        return super.indexOf(item);
    }
}