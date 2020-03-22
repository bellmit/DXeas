package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CCLeaveBillEntryCollection extends AbstractObjectCollection 
{
    public CCLeaveBillEntryCollection()
    {
        super(CCLeaveBillEntryInfo.class);
    }
    public boolean add(CCLeaveBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CCLeaveBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CCLeaveBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CCLeaveBillEntryInfo get(int index)
    {
        return(CCLeaveBillEntryInfo)getObject(index);
    }
    public CCLeaveBillEntryInfo get(Object key)
    {
        return(CCLeaveBillEntryInfo)getObject(key);
    }
    public void set(int index, CCLeaveBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CCLeaveBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CCLeaveBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}