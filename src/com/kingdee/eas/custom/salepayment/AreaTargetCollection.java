package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class AreaTargetCollection extends AbstractObjectCollection 
{
    public AreaTargetCollection()
    {
        super(AreaTargetInfo.class);
    }
    public boolean add(AreaTargetInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(AreaTargetCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(AreaTargetInfo item)
    {
        return removeObject(item);
    }
    public AreaTargetInfo get(int index)
    {
        return(AreaTargetInfo)getObject(index);
    }
    public AreaTargetInfo get(Object key)
    {
        return(AreaTargetInfo)getObject(key);
    }
    public void set(int index, AreaTargetInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(AreaTargetInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(AreaTargetInfo item)
    {
        return super.indexOf(item);
    }
}