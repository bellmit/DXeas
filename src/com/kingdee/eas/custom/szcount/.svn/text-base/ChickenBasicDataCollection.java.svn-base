package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChickenBasicDataCollection extends AbstractObjectCollection 
{
    public ChickenBasicDataCollection()
    {
        super(ChickenBasicDataInfo.class);
    }
    public boolean add(ChickenBasicDataInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChickenBasicDataCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChickenBasicDataInfo item)
    {
        return removeObject(item);
    }
    public ChickenBasicDataInfo get(int index)
    {
        return(ChickenBasicDataInfo)getObject(index);
    }
    public ChickenBasicDataInfo get(Object key)
    {
        return(ChickenBasicDataInfo)getObject(key);
    }
    public void set(int index, ChickenBasicDataInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChickenBasicDataInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChickenBasicDataInfo item)
    {
        return super.indexOf(item);
    }
}