package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EasLogsCollection extends AbstractObjectCollection 
{
    public EasLogsCollection()
    {
        super(EasLogsInfo.class);
    }
    public boolean add(EasLogsInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EasLogsCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EasLogsInfo item)
    {
        return removeObject(item);
    }
    public EasLogsInfo get(int index)
    {
        return(EasLogsInfo)getObject(index);
    }
    public EasLogsInfo get(Object key)
    {
        return(EasLogsInfo)getObject(key);
    }
    public void set(int index, EasLogsInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EasLogsInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EasLogsInfo item)
    {
        return super.indexOf(item);
    }
}