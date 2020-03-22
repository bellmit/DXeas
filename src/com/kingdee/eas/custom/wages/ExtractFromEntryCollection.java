package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExtractFromEntryCollection extends AbstractObjectCollection 
{
    public ExtractFromEntryCollection()
    {
        super(ExtractFromEntryInfo.class);
    }
    public boolean add(ExtractFromEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExtractFromEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExtractFromEntryInfo item)
    {
        return removeObject(item);
    }
    public ExtractFromEntryInfo get(int index)
    {
        return(ExtractFromEntryInfo)getObject(index);
    }
    public ExtractFromEntryInfo get(Object key)
    {
        return(ExtractFromEntryInfo)getObject(key);
    }
    public void set(int index, ExtractFromEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExtractFromEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExtractFromEntryInfo item)
    {
        return super.indexOf(item);
    }
}