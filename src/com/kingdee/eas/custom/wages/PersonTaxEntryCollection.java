package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonTaxEntryCollection extends AbstractObjectCollection 
{
    public PersonTaxEntryCollection()
    {
        super(PersonTaxEntryInfo.class);
    }
    public boolean add(PersonTaxEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonTaxEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonTaxEntryInfo item)
    {
        return removeObject(item);
    }
    public PersonTaxEntryInfo get(int index)
    {
        return(PersonTaxEntryInfo)getObject(index);
    }
    public PersonTaxEntryInfo get(Object key)
    {
        return(PersonTaxEntryInfo)getObject(key);
    }
    public void set(int index, PersonTaxEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonTaxEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonTaxEntryInfo item)
    {
        return super.indexOf(item);
    }
}