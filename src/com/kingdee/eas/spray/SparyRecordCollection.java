package com.kingdee.eas.spray;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SparyRecordCollection extends AbstractObjectCollection 
{
    public SparyRecordCollection()
    {
        super(SparyRecordInfo.class);
    }
    public boolean add(SparyRecordInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SparyRecordCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SparyRecordInfo item)
    {
        return removeObject(item);
    }
    public SparyRecordInfo get(int index)
    {
        return(SparyRecordInfo)getObject(index);
    }
    public SparyRecordInfo get(Object key)
    {
        return(SparyRecordInfo)getObject(key);
    }
    public void set(int index, SparyRecordInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SparyRecordInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SparyRecordInfo item)
    {
        return super.indexOf(item);
    }
}