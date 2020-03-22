package com.kingdee.eas.custom.shr;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MyTestEntryCollection extends AbstractObjectCollection 
{
    public MyTestEntryCollection()
    {
        super(MyTestEntryInfo.class);
    }
    public boolean add(MyTestEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MyTestEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MyTestEntryInfo item)
    {
        return removeObject(item);
    }
    public MyTestEntryInfo get(int index)
    {
        return(MyTestEntryInfo)getObject(index);
    }
    public MyTestEntryInfo get(Object key)
    {
        return(MyTestEntryInfo)getObject(key);
    }
    public void set(int index, MyTestEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MyTestEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MyTestEntryInfo item)
    {
        return super.indexOf(item);
    }
}