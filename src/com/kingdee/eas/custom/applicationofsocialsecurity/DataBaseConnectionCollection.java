package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DataBaseConnectionCollection extends AbstractObjectCollection 
{
    public DataBaseConnectionCollection()
    {
        super(DataBaseConnectionInfo.class);
    }
    public boolean add(DataBaseConnectionInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DataBaseConnectionCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DataBaseConnectionInfo item)
    {
        return removeObject(item);
    }
    public DataBaseConnectionInfo get(int index)
    {
        return(DataBaseConnectionInfo)getObject(index);
    }
    public DataBaseConnectionInfo get(Object key)
    {
        return(DataBaseConnectionInfo)getObject(key);
    }
    public void set(int index, DataBaseConnectionInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DataBaseConnectionInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DataBaseConnectionInfo item)
    {
        return super.indexOf(item);
    }
}