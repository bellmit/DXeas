package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class OverPayEntryCollection extends AbstractObjectCollection 
{
    public OverPayEntryCollection()
    {
        super(OverPayEntryInfo.class);
    }
    public boolean add(OverPayEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(OverPayEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(OverPayEntryInfo item)
    {
        return removeObject(item);
    }
    public OverPayEntryInfo get(int index)
    {
        return(OverPayEntryInfo)getObject(index);
    }
    public OverPayEntryInfo get(Object key)
    {
        return(OverPayEntryInfo)getObject(key);
    }
    public void set(int index, OverPayEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(OverPayEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(OverPayEntryInfo item)
    {
        return super.indexOf(item);
    }
}