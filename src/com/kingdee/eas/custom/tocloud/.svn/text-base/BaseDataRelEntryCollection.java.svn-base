package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BaseDataRelEntryCollection extends AbstractObjectCollection 
{
    public BaseDataRelEntryCollection()
    {
        super(BaseDataRelEntryInfo.class);
    }
    public boolean add(BaseDataRelEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BaseDataRelEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BaseDataRelEntryInfo item)
    {
        return removeObject(item);
    }
    public BaseDataRelEntryInfo get(int index)
    {
        return(BaseDataRelEntryInfo)getObject(index);
    }
    public BaseDataRelEntryInfo get(Object key)
    {
        return(BaseDataRelEntryInfo)getObject(key);
    }
    public void set(int index, BaseDataRelEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BaseDataRelEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BaseDataRelEntryInfo item)
    {
        return super.indexOf(item);
    }
}