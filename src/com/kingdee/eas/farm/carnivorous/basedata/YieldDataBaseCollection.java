package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class YieldDataBaseCollection extends AbstractObjectCollection 
{
    public YieldDataBaseCollection()
    {
        super(YieldDataBaseInfo.class);
    }
    public boolean add(YieldDataBaseInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(YieldDataBaseCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(YieldDataBaseInfo item)
    {
        return removeObject(item);
    }
    public YieldDataBaseInfo get(int index)
    {
        return(YieldDataBaseInfo)getObject(index);
    }
    public YieldDataBaseInfo get(Object key)
    {
        return(YieldDataBaseInfo)getObject(key);
    }
    public void set(int index, YieldDataBaseInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(YieldDataBaseInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(YieldDataBaseInfo item)
    {
        return super.indexOf(item);
    }
}