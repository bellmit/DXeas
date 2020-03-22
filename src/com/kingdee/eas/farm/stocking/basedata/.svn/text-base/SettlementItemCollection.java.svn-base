package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlementItemCollection extends AbstractObjectCollection 
{
    public SettlementItemCollection()
    {
        super(SettlementItemInfo.class);
    }
    public boolean add(SettlementItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlementItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlementItemInfo item)
    {
        return removeObject(item);
    }
    public SettlementItemInfo get(int index)
    {
        return(SettlementItemInfo)getObject(index);
    }
    public SettlementItemInfo get(Object key)
    {
        return(SettlementItemInfo)getObject(key);
    }
    public void set(int index, SettlementItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlementItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlementItemInfo item)
    {
        return super.indexOf(item);
    }
}