package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FodderStdEntryCollection extends AbstractObjectCollection 
{
    public FodderStdEntryCollection()
    {
        super(FodderStdEntryInfo.class);
    }
    public boolean add(FodderStdEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FodderStdEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FodderStdEntryInfo item)
    {
        return removeObject(item);
    }
    public FodderStdEntryInfo get(int index)
    {
        return(FodderStdEntryInfo)getObject(index);
    }
    public FodderStdEntryInfo get(Object key)
    {
        return(FodderStdEntryInfo)getObject(key);
    }
    public void set(int index, FodderStdEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FodderStdEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FodderStdEntryInfo item)
    {
        return super.indexOf(item);
    }
}