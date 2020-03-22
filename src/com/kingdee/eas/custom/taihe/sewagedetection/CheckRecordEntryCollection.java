package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CheckRecordEntryCollection extends AbstractObjectCollection 
{
    public CheckRecordEntryCollection()
    {
        super(CheckRecordEntryInfo.class);
    }
    public boolean add(CheckRecordEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CheckRecordEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CheckRecordEntryInfo item)
    {
        return removeObject(item);
    }
    public CheckRecordEntryInfo get(int index)
    {
        return(CheckRecordEntryInfo)getObject(index);
    }
    public CheckRecordEntryInfo get(Object key)
    {
        return(CheckRecordEntryInfo)getObject(key);
    }
    public void set(int index, CheckRecordEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CheckRecordEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CheckRecordEntryInfo item)
    {
        return super.indexOf(item);
    }
}