package com.kingdee.eas.custom.test;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SignwasthetableEntryCollection extends AbstractObjectCollection 
{
    public SignwasthetableEntryCollection()
    {
        super(SignwasthetableEntryInfo.class);
    }
    public boolean add(SignwasthetableEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SignwasthetableEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SignwasthetableEntryInfo item)
    {
        return removeObject(item);
    }
    public SignwasthetableEntryInfo get(int index)
    {
        return(SignwasthetableEntryInfo)getObject(index);
    }
    public SignwasthetableEntryInfo get(Object key)
    {
        return(SignwasthetableEntryInfo)getObject(key);
    }
    public void set(int index, SignwasthetableEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SignwasthetableEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SignwasthetableEntryInfo item)
    {
        return super.indexOf(item);
    }
}