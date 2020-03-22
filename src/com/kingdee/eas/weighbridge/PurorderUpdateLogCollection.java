package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PurorderUpdateLogCollection extends AbstractObjectCollection 
{
    public PurorderUpdateLogCollection()
    {
        super(PurorderUpdateLogInfo.class);
    }
    public boolean add(PurorderUpdateLogInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PurorderUpdateLogCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PurorderUpdateLogInfo item)
    {
        return removeObject(item);
    }
    public PurorderUpdateLogInfo get(int index)
    {
        return(PurorderUpdateLogInfo)getObject(index);
    }
    public PurorderUpdateLogInfo get(Object key)
    {
        return(PurorderUpdateLogInfo)getObject(key);
    }
    public void set(int index, PurorderUpdateLogInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PurorderUpdateLogInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PurorderUpdateLogInfo item)
    {
        return super.indexOf(item);
    }
}