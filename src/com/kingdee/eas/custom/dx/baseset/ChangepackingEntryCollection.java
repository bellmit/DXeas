package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ChangepackingEntryCollection extends AbstractObjectCollection 
{
    public ChangepackingEntryCollection()
    {
        super(ChangepackingEntryInfo.class);
    }
    public boolean add(ChangepackingEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ChangepackingEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ChangepackingEntryInfo item)
    {
        return removeObject(item);
    }
    public ChangepackingEntryInfo get(int index)
    {
        return(ChangepackingEntryInfo)getObject(index);
    }
    public ChangepackingEntryInfo get(Object key)
    {
        return(ChangepackingEntryInfo)getObject(key);
    }
    public void set(int index, ChangepackingEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ChangepackingEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ChangepackingEntryInfo item)
    {
        return super.indexOf(item);
    }
}