package com.kingdee.eas.custom.taihe.complaintvisit;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ComplainBillComplainEntryCollection extends AbstractObjectCollection 
{
    public ComplainBillComplainEntryCollection()
    {
        super(ComplainBillComplainEntryInfo.class);
    }
    public boolean add(ComplainBillComplainEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ComplainBillComplainEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ComplainBillComplainEntryInfo item)
    {
        return removeObject(item);
    }
    public ComplainBillComplainEntryInfo get(int index)
    {
        return(ComplainBillComplainEntryInfo)getObject(index);
    }
    public ComplainBillComplainEntryInfo get(Object key)
    {
        return(ComplainBillComplainEntryInfo)getObject(key);
    }
    public void set(int index, ComplainBillComplainEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ComplainBillComplainEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ComplainBillComplainEntryInfo item)
    {
        return super.indexOf(item);
    }
}