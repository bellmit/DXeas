package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TransportationrecordAssEntryCollection extends AbstractObjectCollection 
{
    public TransportationrecordAssEntryCollection()
    {
        super(TransportationrecordAssEntryInfo.class);
    }
    public boolean add(TransportationrecordAssEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TransportationrecordAssEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TransportationrecordAssEntryInfo item)
    {
        return removeObject(item);
    }
    public TransportationrecordAssEntryInfo get(int index)
    {
        return(TransportationrecordAssEntryInfo)getObject(index);
    }
    public TransportationrecordAssEntryInfo get(Object key)
    {
        return(TransportationrecordAssEntryInfo)getObject(key);
    }
    public void set(int index, TransportationrecordAssEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TransportationrecordAssEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TransportationrecordAssEntryInfo item)
    {
        return super.indexOf(item);
    }
}