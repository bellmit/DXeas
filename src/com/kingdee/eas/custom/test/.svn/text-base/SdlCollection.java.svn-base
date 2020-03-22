package com.kingdee.eas.custom.test;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SdlCollection extends AbstractObjectCollection 
{
    public SdlCollection()
    {
        super(SdlInfo.class);
    }
    public boolean add(SdlInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SdlCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SdlInfo item)
    {
        return removeObject(item);
    }
    public SdlInfo get(int index)
    {
        return(SdlInfo)getObject(index);
    }
    public SdlInfo get(Object key)
    {
        return(SdlInfo)getObject(key);
    }
    public void set(int index, SdlInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SdlInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SdlInfo item)
    {
        return super.indexOf(item);
    }
}