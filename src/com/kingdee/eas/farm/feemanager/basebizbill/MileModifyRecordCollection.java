package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MileModifyRecordCollection extends AbstractObjectCollection 
{
    public MileModifyRecordCollection()
    {
        super(MileModifyRecordInfo.class);
    }
    public boolean add(MileModifyRecordInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MileModifyRecordCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MileModifyRecordInfo item)
    {
        return removeObject(item);
    }
    public MileModifyRecordInfo get(int index)
    {
        return(MileModifyRecordInfo)getObject(index);
    }
    public MileModifyRecordInfo get(Object key)
    {
        return(MileModifyRecordInfo)getObject(key);
    }
    public void set(int index, MileModifyRecordInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MileModifyRecordInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MileModifyRecordInfo item)
    {
        return super.indexOf(item);
    }
}