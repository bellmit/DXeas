package com.kingdee.eas.custom.mobileRPT;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RPTRoleRoleEntryCollection extends AbstractObjectCollection 
{
    public RPTRoleRoleEntryCollection()
    {
        super(RPTRoleRoleEntryInfo.class);
    }
    public boolean add(RPTRoleRoleEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RPTRoleRoleEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RPTRoleRoleEntryInfo item)
    {
        return removeObject(item);
    }
    public RPTRoleRoleEntryInfo get(int index)
    {
        return(RPTRoleRoleEntryInfo)getObject(index);
    }
    public RPTRoleRoleEntryInfo get(Object key)
    {
        return(RPTRoleRoleEntryInfo)getObject(key);
    }
    public void set(int index, RPTRoleRoleEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RPTRoleRoleEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RPTRoleRoleEntryInfo item)
    {
        return super.indexOf(item);
    }
}