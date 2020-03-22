package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class HenhouseCollection extends AbstractObjectCollection 
{
    public HenhouseCollection()
    {
        super(HenhouseInfo.class);
    }
    public boolean add(HenhouseInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(HenhouseCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(HenhouseInfo item)
    {
        return removeObject(item);
    }
    public HenhouseInfo get(int index)
    {
        return(HenhouseInfo)getObject(index);
    }
    public HenhouseInfo get(Object key)
    {
        return(HenhouseInfo)getObject(key);
    }
    public void set(int index, HenhouseInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(HenhouseInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(HenhouseInfo item)
    {
        return super.indexOf(item);
    }
}