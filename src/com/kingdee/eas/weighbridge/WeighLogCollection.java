package com.kingdee.eas.weighbridge;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WeighLogCollection extends AbstractObjectCollection 
{
    public WeighLogCollection()
    {
        super(WeighLogInfo.class);
    }
    public boolean add(WeighLogInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WeighLogCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WeighLogInfo item)
    {
        return removeObject(item);
    }
    public WeighLogInfo get(int index)
    {
        return(WeighLogInfo)getObject(index);
    }
    public WeighLogInfo get(Object key)
    {
        return(WeighLogInfo)getObject(key);
    }
    public void set(int index, WeighLogInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WeighLogInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WeighLogInfo item)
    {
        return super.indexOf(item);
    }
}