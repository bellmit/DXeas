package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckItemTreeCollection extends AbstractObjectCollection 
{
    public CheckItemTreeCollection()
    {
        super(CheckItemTreeInfo.class);
    }
    public boolean add(CheckItemTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckItemTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckItemTreeInfo item)
    {
        return removeObject(item);
    }
    public CheckItemTreeInfo get(int index)
    {
        return(CheckItemTreeInfo)getObject(index);
    }
    public CheckItemTreeInfo get(Object key)
    {
        return(CheckItemTreeInfo)getObject(key);
    }
    public void set(int index, CheckItemTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckItemTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckItemTreeInfo item)
    {
        return super.indexOf(item);
    }
}