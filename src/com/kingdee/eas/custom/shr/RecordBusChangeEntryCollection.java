package com.kingdee.eas.custom.shr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RecordBusChangeEntryCollection extends AbstractObjectCollection 
{
    public RecordBusChangeEntryCollection()
    {
        super(RecordBusChangeEntryInfo.class);
    }
    public boolean add(RecordBusChangeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RecordBusChangeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RecordBusChangeEntryInfo item)
    {
        return removeObject(item);
    }
    public RecordBusChangeEntryInfo get(int index)
    {
        return(RecordBusChangeEntryInfo)getObject(index);
    }
    public RecordBusChangeEntryInfo get(Object key)
    {
        return(RecordBusChangeEntryInfo)getObject(key);
    }
    public void set(int index, RecordBusChangeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RecordBusChangeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RecordBusChangeEntryInfo item)
    {
        return super.indexOf(item);
    }
}