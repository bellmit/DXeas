package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PersonGuaranteeCollection extends AbstractObjectCollection 
{
    public PersonGuaranteeCollection()
    {
        super(PersonGuaranteeInfo.class);
    }
    public boolean add(PersonGuaranteeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PersonGuaranteeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PersonGuaranteeInfo item)
    {
        return removeObject(item);
    }
    public PersonGuaranteeInfo get(int index)
    {
        return(PersonGuaranteeInfo)getObject(index);
    }
    public PersonGuaranteeInfo get(Object key)
    {
        return(PersonGuaranteeInfo)getObject(key);
    }
    public void set(int index, PersonGuaranteeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PersonGuaranteeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PersonGuaranteeInfo item)
    {
        return super.indexOf(item);
    }
}