package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonTaxCollection extends AbstractObjectCollection 
{
    public PersonTaxCollection()
    {
        super(PersonTaxInfo.class);
    }
    public boolean add(PersonTaxInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonTaxCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonTaxInfo item)
    {
        return removeObject(item);
    }
    public PersonTaxInfo get(int index)
    {
        return(PersonTaxInfo)getObject(index);
    }
    public PersonTaxInfo get(Object key)
    {
        return(PersonTaxInfo)getObject(key);
    }
    public void set(int index, PersonTaxInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonTaxInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonTaxInfo item)
    {
        return super.indexOf(item);
    }
}