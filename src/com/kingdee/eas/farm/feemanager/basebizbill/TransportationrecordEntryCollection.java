package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TransportationrecordEntryCollection extends AbstractObjectCollection 
{
    public TransportationrecordEntryCollection()
    {
        super(TransportationrecordEntryInfo.class);
    }
    public boolean add(TransportationrecordEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TransportationrecordEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TransportationrecordEntryInfo item)
    {
        return removeObject(item);
    }
    public TransportationrecordEntryInfo get(int index)
    {
        return(TransportationrecordEntryInfo)getObject(index);
    }
    public TransportationrecordEntryInfo get(Object key)
    {
        return(TransportationrecordEntryInfo)getObject(key);
    }
    public void set(int index, TransportationrecordEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TransportationrecordEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TransportationrecordEntryInfo item)
    {
        return super.indexOf(item);
    }
}