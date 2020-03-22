package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SettlementMECollection extends AbstractObjectCollection 
{
    public SettlementMECollection()
    {
        super(SettlementMEInfo.class);
    }
    public boolean add(SettlementMEInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SettlementMECollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SettlementMEInfo item)
    {
        return removeObject(item);
    }
    public SettlementMEInfo get(int index)
    {
        return(SettlementMEInfo)getObject(index);
    }
    public SettlementMEInfo get(Object key)
    {
        return(SettlementMEInfo)getObject(key);
    }
    public void set(int index, SettlementMEInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SettlementMEInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SettlementMEInfo item)
    {
        return super.indexOf(item);
    }
}