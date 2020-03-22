package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ClosingRecordCollection extends AbstractObjectCollection 
{
    public ClosingRecordCollection()
    {
        super(ClosingRecordInfo.class);
    }
    public boolean add(ClosingRecordInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ClosingRecordCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ClosingRecordInfo item)
    {
        return removeObject(item);
    }
    public ClosingRecordInfo get(int index)
    {
        return(ClosingRecordInfo)getObject(index);
    }
    public ClosingRecordInfo get(Object key)
    {
        return(ClosingRecordInfo)getObject(key);
    }
    public void set(int index, ClosingRecordInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ClosingRecordInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ClosingRecordInfo item)
    {
        return super.indexOf(item);
    }
}