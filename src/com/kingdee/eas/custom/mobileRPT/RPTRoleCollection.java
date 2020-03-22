package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RPTRoleCollection extends AbstractObjectCollection 
{
    public RPTRoleCollection()
    {
        super(RPTRoleInfo.class);
    }
    public boolean add(RPTRoleInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RPTRoleCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RPTRoleInfo item)
    {
        return removeObject(item);
    }
    public RPTRoleInfo get(int index)
    {
        return(RPTRoleInfo)getObject(index);
    }
    public RPTRoleInfo get(Object key)
    {
        return(RPTRoleInfo)getObject(key);
    }
    public void set(int index, RPTRoleInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RPTRoleInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RPTRoleInfo item)
    {
        return super.indexOf(item);
    }
}