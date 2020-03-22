package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TransportationrecordCollection extends AbstractObjectCollection 
{
    public TransportationrecordCollection()
    {
        super(TransportationrecordInfo.class);
    }
    public boolean add(TransportationrecordInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TransportationrecordCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TransportationrecordInfo item)
    {
        return removeObject(item);
    }
    public TransportationrecordInfo get(int index)
    {
        return(TransportationrecordInfo)getObject(index);
    }
    public TransportationrecordInfo get(Object key)
    {
        return(TransportationrecordInfo)getObject(key);
    }
    public void set(int index, TransportationrecordInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TransportationrecordInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TransportationrecordInfo item)
    {
        return super.indexOf(item);
    }
}