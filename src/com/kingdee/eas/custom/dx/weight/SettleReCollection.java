package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettleReCollection extends AbstractObjectCollection 
{
    public SettleReCollection()
    {
        super(SettleReInfo.class);
    }
    public boolean add(SettleReInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettleReCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettleReInfo item)
    {
        return removeObject(item);
    }
    public SettleReInfo get(int index)
    {
        return(SettleReInfo)getObject(index);
    }
    public SettleReInfo get(Object key)
    {
        return(SettleReInfo)getObject(key);
    }
    public void set(int index, SettleReInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettleReInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettleReInfo item)
    {
        return super.indexOf(item);
    }
}