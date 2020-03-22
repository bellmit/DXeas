package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CmChangeEntryCollection extends AbstractObjectCollection 
{
    public CmChangeEntryCollection()
    {
        super(CmChangeEntryInfo.class);
    }
    public boolean add(CmChangeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CmChangeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CmChangeEntryInfo item)
    {
        return removeObject(item);
    }
    public CmChangeEntryInfo get(int index)
    {
        return(CmChangeEntryInfo)getObject(index);
    }
    public CmChangeEntryInfo get(Object key)
    {
        return(CmChangeEntryInfo)getObject(key);
    }
    public void set(int index, CmChangeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CmChangeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CmChangeEntryInfo item)
    {
        return super.indexOf(item);
    }
}