package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonTypeCollection extends AbstractObjectCollection 
{
    public PersonTypeCollection()
    {
        super(PersonTypeInfo.class);
    }
    public boolean add(PersonTypeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonTypeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonTypeInfo item)
    {
        return removeObject(item);
    }
    public PersonTypeInfo get(int index)
    {
        return(PersonTypeInfo)getObject(index);
    }
    public PersonTypeInfo get(Object key)
    {
        return(PersonTypeInfo)getObject(key);
    }
    public void set(int index, PersonTypeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonTypeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonTypeInfo item)
    {
        return super.indexOf(item);
    }
}