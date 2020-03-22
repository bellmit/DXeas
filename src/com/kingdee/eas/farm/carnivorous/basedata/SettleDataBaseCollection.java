package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettleDataBaseCollection extends AbstractObjectCollection 
{
    public SettleDataBaseCollection()
    {
        super(SettleDataBaseInfo.class);
    }
    public boolean add(SettleDataBaseInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettleDataBaseCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettleDataBaseInfo item)
    {
        return removeObject(item);
    }
    public SettleDataBaseInfo get(int index)
    {
        return(SettleDataBaseInfo)getObject(index);
    }
    public SettleDataBaseInfo get(Object key)
    {
        return(SettleDataBaseInfo)getObject(key);
    }
    public void set(int index, SettleDataBaseInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettleDataBaseInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettleDataBaseInfo item)
    {
        return super.indexOf(item);
    }
}