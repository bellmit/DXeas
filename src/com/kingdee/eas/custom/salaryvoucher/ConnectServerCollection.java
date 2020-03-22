package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ConnectServerCollection extends AbstractObjectCollection 
{
    public ConnectServerCollection()
    {
        super(ConnectServerInfo.class);
    }
    public boolean add(ConnectServerInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ConnectServerCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ConnectServerInfo item)
    {
        return removeObject(item);
    }
    public ConnectServerInfo get(int index)
    {
        return(ConnectServerInfo)getObject(index);
    }
    public ConnectServerInfo get(Object key)
    {
        return(ConnectServerInfo)getObject(key);
    }
    public void set(int index, ConnectServerInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ConnectServerInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ConnectServerInfo item)
    {
        return super.indexOf(item);
    }
}