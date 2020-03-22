package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CountPostProductsCppEntryGroupEntryCollection extends AbstractObjectCollection 
{
    public CountPostProductsCppEntryGroupEntryCollection()
    {
        super(CountPostProductsCppEntryGroupEntryInfo.class);
    }
    public boolean add(CountPostProductsCppEntryGroupEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CountPostProductsCppEntryGroupEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CountPostProductsCppEntryGroupEntryInfo item)
    {
        return removeObject(item);
    }
    public CountPostProductsCppEntryGroupEntryInfo get(int index)
    {
        return(CountPostProductsCppEntryGroupEntryInfo)getObject(index);
    }
    public CountPostProductsCppEntryGroupEntryInfo get(Object key)
    {
        return(CountPostProductsCppEntryGroupEntryInfo)getObject(key);
    }
    public void set(int index, CountPostProductsCppEntryGroupEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CountPostProductsCppEntryGroupEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CountPostProductsCppEntryGroupEntryInfo item)
    {
        return super.indexOf(item);
    }
}