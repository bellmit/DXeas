package com.kingdee.eas.custom.rye;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RyeReadFilesEntryCollection extends AbstractObjectCollection 
{
    public RyeReadFilesEntryCollection()
    {
        super(RyeReadFilesEntryInfo.class);
    }
    public boolean add(RyeReadFilesEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RyeReadFilesEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RyeReadFilesEntryInfo item)
    {
        return removeObject(item);
    }
    public RyeReadFilesEntryInfo get(int index)
    {
        return(RyeReadFilesEntryInfo)getObject(index);
    }
    public RyeReadFilesEntryInfo get(Object key)
    {
        return(RyeReadFilesEntryInfo)getObject(key);
    }
    public void set(int index, RyeReadFilesEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RyeReadFilesEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RyeReadFilesEntryInfo item)
    {
        return super.indexOf(item);
    }
}