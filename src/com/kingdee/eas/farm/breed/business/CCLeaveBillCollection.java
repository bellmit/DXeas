package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCLeaveBillCollection extends AbstractObjectCollection 
{
    public CCLeaveBillCollection()
    {
        super(CCLeaveBillInfo.class);
    }
    public boolean add(CCLeaveBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCLeaveBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCLeaveBillInfo item)
    {
        return removeObject(item);
    }
    public CCLeaveBillInfo get(int index)
    {
        return(CCLeaveBillInfo)getObject(index);
    }
    public CCLeaveBillInfo get(Object key)
    {
        return(CCLeaveBillInfo)getObject(key);
    }
    public void set(int index, CCLeaveBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCLeaveBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCLeaveBillInfo item)
    {
        return super.indexOf(item);
    }
}