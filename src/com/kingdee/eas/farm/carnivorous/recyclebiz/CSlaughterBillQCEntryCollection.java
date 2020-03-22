package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CSlaughterBillQCEntryCollection extends AbstractObjectCollection 
{
    public CSlaughterBillQCEntryCollection()
    {
        super(CSlaughterBillQCEntryInfo.class);
    }
    public boolean add(CSlaughterBillQCEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CSlaughterBillQCEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CSlaughterBillQCEntryInfo item)
    {
        return removeObject(item);
    }
    public CSlaughterBillQCEntryInfo get(int index)
    {
        return(CSlaughterBillQCEntryInfo)getObject(index);
    }
    public CSlaughterBillQCEntryInfo get(Object key)
    {
        return(CSlaughterBillQCEntryInfo)getObject(key);
    }
    public void set(int index, CSlaughterBillQCEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CSlaughterBillQCEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CSlaughterBillQCEntryInfo item)
    {
        return super.indexOf(item);
    }
}