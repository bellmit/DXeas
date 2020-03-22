package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TechnicianCustomerEntryCollection extends AbstractObjectCollection 
{
    public TechnicianCustomerEntryCollection()
    {
        super(TechnicianCustomerEntryInfo.class);
    }
    public boolean add(TechnicianCustomerEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TechnicianCustomerEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TechnicianCustomerEntryInfo item)
    {
        return removeObject(item);
    }
    public TechnicianCustomerEntryInfo get(int index)
    {
        return(TechnicianCustomerEntryInfo)getObject(index);
    }
    public TechnicianCustomerEntryInfo get(Object key)
    {
        return(TechnicianCustomerEntryInfo)getObject(key);
    }
    public void set(int index, TechnicianCustomerEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TechnicianCustomerEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TechnicianCustomerEntryInfo item)
    {
        return super.indexOf(item);
    }
}