package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StdCarassRateCollection extends AbstractObjectCollection 
{
    public StdCarassRateCollection()
    {
        super(StdCarassRateInfo.class);
    }
    public boolean add(StdCarassRateInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StdCarassRateCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StdCarassRateInfo item)
    {
        return removeObject(item);
    }
    public StdCarassRateInfo get(int index)
    {
        return(StdCarassRateInfo)getObject(index);
    }
    public StdCarassRateInfo get(Object key)
    {
        return(StdCarassRateInfo)getObject(key);
    }
    public void set(int index, StdCarassRateInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StdCarassRateInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StdCarassRateInfo item)
    {
        return super.indexOf(item);
    }
}