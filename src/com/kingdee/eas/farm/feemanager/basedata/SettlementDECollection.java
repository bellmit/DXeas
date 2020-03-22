package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlementDECollection extends AbstractObjectCollection 
{
    public SettlementDECollection()
    {
        super(SettlementDEInfo.class);
    }
    public boolean add(SettlementDEInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlementDECollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlementDEInfo item)
    {
        return removeObject(item);
    }
    public SettlementDEInfo get(int index)
    {
        return(SettlementDEInfo)getObject(index);
    }
    public SettlementDEInfo get(Object key)
    {
        return(SettlementDEInfo)getObject(key);
    }
    public void set(int index, SettlementDEInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlementDEInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlementDEInfo item)
    {
        return super.indexOf(item);
    }
}