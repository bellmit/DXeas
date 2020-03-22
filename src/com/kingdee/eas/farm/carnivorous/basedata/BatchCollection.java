package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BatchCollection extends AbstractObjectCollection 
{
    public BatchCollection()
    {
        super(BatchInfo.class);
    }
    public boolean add(BatchInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BatchCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BatchInfo item)
    {
        return removeObject(item);
    }
    public BatchInfo get(int index)
    {
        return(BatchInfo)getObject(index);
    }
    public BatchInfo get(Object key)
    {
        return(BatchInfo)getObject(key);
    }
    public void set(int index, BatchInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BatchInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BatchInfo item)
    {
        return super.indexOf(item);
    }
}