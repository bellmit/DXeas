package com.kingdee.eas.custom.rye;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class RyeReadFilesCollection extends AbstractObjectCollection 
{
    public RyeReadFilesCollection()
    {
        super(RyeReadFilesInfo.class);
    }
    public boolean add(RyeReadFilesInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(RyeReadFilesCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(RyeReadFilesInfo item)
    {
        return removeObject(item);
    }
    public RyeReadFilesInfo get(int index)
    {
        return(RyeReadFilesInfo)getObject(index);
    }
    public RyeReadFilesInfo get(Object key)
    {
        return(RyeReadFilesInfo)getObject(key);
    }
    public void set(int index, RyeReadFilesInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(RyeReadFilesInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(RyeReadFilesInfo item)
    {
        return super.indexOf(item);
    }
}