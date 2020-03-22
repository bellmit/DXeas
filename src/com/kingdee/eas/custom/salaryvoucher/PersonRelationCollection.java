package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonRelationCollection extends AbstractObjectCollection 
{
    public PersonRelationCollection()
    {
        super(PersonRelationInfo.class);
    }
    public boolean add(PersonRelationInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonRelationCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonRelationInfo item)
    {
        return removeObject(item);
    }
    public PersonRelationInfo get(int index)
    {
        return(PersonRelationInfo)getObject(index);
    }
    public PersonRelationInfo get(Object key)
    {
        return(PersonRelationInfo)getObject(key);
    }
    public void set(int index, PersonRelationInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonRelationInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonRelationInfo item)
    {
        return super.indexOf(item);
    }
}