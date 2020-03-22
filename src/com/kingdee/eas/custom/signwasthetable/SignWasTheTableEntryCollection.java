package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SignWasTheTableEntryCollection extends AbstractObjectCollection 
{
    public SignWasTheTableEntryCollection()
    {
        super(SignWasTheTableEntryInfo.class);
    }
    public boolean add(SignWasTheTableEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SignWasTheTableEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SignWasTheTableEntryInfo item)
    {
        return removeObject(item);
    }
    public SignWasTheTableEntryInfo get(int index)
    {
        return(SignWasTheTableEntryInfo)getObject(index);
    }
    public SignWasTheTableEntryInfo get(Object key)
    {
        return(SignWasTheTableEntryInfo)getObject(key);
    }
    public void set(int index, SignWasTheTableEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SignWasTheTableEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SignWasTheTableEntryInfo item)
    {
        return super.indexOf(item);
    }
}