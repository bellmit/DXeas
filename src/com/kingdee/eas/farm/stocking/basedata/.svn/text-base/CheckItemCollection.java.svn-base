package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckItemCollection extends AbstractObjectCollection 
{
    public CheckItemCollection()
    {
        super(CheckItemInfo.class);
    }
    public boolean add(CheckItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckItemInfo item)
    {
        return removeObject(item);
    }
    public CheckItemInfo get(int index)
    {
        return(CheckItemInfo)getObject(index);
    }
    public CheckItemInfo get(Object key)
    {
        return(CheckItemInfo)getObject(key);
    }
    public void set(int index, CheckItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckItemInfo item)
    {
        return super.indexOf(item);
    }
}