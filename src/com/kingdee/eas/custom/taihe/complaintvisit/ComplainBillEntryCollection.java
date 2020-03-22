package com.kingdee.eas.custom.taihe.complaintvisit;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ComplainBillEntryCollection extends AbstractObjectCollection 
{
    public ComplainBillEntryCollection()
    {
        super(ComplainBillEntryInfo.class);
    }
    public boolean add(ComplainBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ComplainBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ComplainBillEntryInfo item)
    {
        return removeObject(item);
    }
    public ComplainBillEntryInfo get(int index)
    {
        return(ComplainBillEntryInfo)getObject(index);
    }
    public ComplainBillEntryInfo get(Object key)
    {
        return(ComplainBillEntryInfo)getObject(key);
    }
    public void set(int index, ComplainBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ComplainBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ComplainBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}