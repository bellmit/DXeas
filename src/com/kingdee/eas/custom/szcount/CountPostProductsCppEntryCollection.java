package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CountPostProductsCppEntryCollection extends AbstractObjectCollection 
{
    public CountPostProductsCppEntryCollection()
    {
        super(CountPostProductsCppEntryInfo.class);
    }
    public boolean add(CountPostProductsCppEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CountPostProductsCppEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CountPostProductsCppEntryInfo item)
    {
        return removeObject(item);
    }
    public CountPostProductsCppEntryInfo get(int index)
    {
        return(CountPostProductsCppEntryInfo)getObject(index);
    }
    public CountPostProductsCppEntryInfo get(Object key)
    {
        return(CountPostProductsCppEntryInfo)getObject(key);
    }
    public void set(int index, CountPostProductsCppEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CountPostProductsCppEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CountPostProductsCppEntryInfo item)
    {
        return super.indexOf(item);
    }
}