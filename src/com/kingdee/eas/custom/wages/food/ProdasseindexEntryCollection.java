package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProdasseindexEntryCollection extends AbstractObjectCollection 
{
    public ProdasseindexEntryCollection()
    {
        super(ProdasseindexEntryInfo.class);
    }
    public boolean add(ProdasseindexEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProdasseindexEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProdasseindexEntryInfo item)
    {
        return removeObject(item);
    }
    public ProdasseindexEntryInfo get(int index)
    {
        return(ProdasseindexEntryInfo)getObject(index);
    }
    public ProdasseindexEntryInfo get(Object key)
    {
        return(ProdasseindexEntryInfo)getObject(key);
    }
    public void set(int index, ProdasseindexEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProdasseindexEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProdasseindexEntryInfo item)
    {
        return super.indexOf(item);
    }
}