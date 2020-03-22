package com.kingdee.eas.farm.breed;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PlatFormPermissionEntryCollection extends AbstractObjectCollection 
{
    public PlatFormPermissionEntryCollection()
    {
        super(PlatFormPermissionEntryInfo.class);
    }
    public boolean add(PlatFormPermissionEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PlatFormPermissionEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PlatFormPermissionEntryInfo item)
    {
        return removeObject(item);
    }
    public PlatFormPermissionEntryInfo get(int index)
    {
        return(PlatFormPermissionEntryInfo)getObject(index);
    }
    public PlatFormPermissionEntryInfo get(Object key)
    {
        return(PlatFormPermissionEntryInfo)getObject(key);
    }
    public void set(int index, PlatFormPermissionEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PlatFormPermissionEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PlatFormPermissionEntryInfo item)
    {
        return super.indexOf(item);
    }
}