package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class WgtItemCollection extends AbstractObjectCollection 
{
    public WgtItemCollection()
    {
        super(WgtItemInfo.class);
    }
    public boolean add(WgtItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(WgtItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(WgtItemInfo item)
    {
        return removeObject(item);
    }
    public WgtItemInfo get(int index)
    {
        return(WgtItemInfo)getObject(index);
    }
    public WgtItemInfo get(Object key)
    {
        return(WgtItemInfo)getObject(key);
    }
    public void set(int index, WgtItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(WgtItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(WgtItemInfo item)
    {
        return super.indexOf(item);
    }
}