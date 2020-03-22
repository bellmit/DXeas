package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TAttendFarmRecordEntryCollection extends AbstractObjectCollection 
{
    public TAttendFarmRecordEntryCollection()
    {
        super(TAttendFarmRecordEntryInfo.class);
    }
    public boolean add(TAttendFarmRecordEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TAttendFarmRecordEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TAttendFarmRecordEntryInfo item)
    {
        return removeObject(item);
    }
    public TAttendFarmRecordEntryInfo get(int index)
    {
        return(TAttendFarmRecordEntryInfo)getObject(index);
    }
    public TAttendFarmRecordEntryInfo get(Object key)
    {
        return(TAttendFarmRecordEntryInfo)getObject(key);
    }
    public void set(int index, TAttendFarmRecordEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TAttendFarmRecordEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TAttendFarmRecordEntryInfo item)
    {
        return super.indexOf(item);
    }
}