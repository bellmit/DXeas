package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PackbasicEntryCollection extends AbstractObjectCollection 
{
    public PackbasicEntryCollection()
    {
        super(PackbasicEntryInfo.class);
    }
    public boolean add(PackbasicEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PackbasicEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PackbasicEntryInfo item)
    {
        return removeObject(item);
    }
    public PackbasicEntryInfo get(int index)
    {
        return(PackbasicEntryInfo)getObject(index);
    }
    public PackbasicEntryInfo get(Object key)
    {
        return(PackbasicEntryInfo)getObject(key);
    }
    public void set(int index, PackbasicEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PackbasicEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PackbasicEntryInfo item)
    {
        return super.indexOf(item);
    }
}