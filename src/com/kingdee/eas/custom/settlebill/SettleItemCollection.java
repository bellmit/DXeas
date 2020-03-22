package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettleItemCollection extends AbstractObjectCollection 
{
    public SettleItemCollection()
    {
        super(SettleItemInfo.class);
    }
    public boolean add(SettleItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettleItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettleItemInfo item)
    {
        return removeObject(item);
    }
    public SettleItemInfo get(int index)
    {
        return(SettleItemInfo)getObject(index);
    }
    public SettleItemInfo get(Object key)
    {
        return(SettleItemInfo)getObject(key);
    }
    public void set(int index, SettleItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettleItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettleItemInfo item)
    {
        return super.indexOf(item);
    }
}